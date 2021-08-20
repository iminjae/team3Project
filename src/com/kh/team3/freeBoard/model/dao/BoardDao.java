package com.kh.team3.freeBoard.model.dao;

import static com.kh.team3.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Reply;
import com.kh.team3.freeBoard.model.vo.Board;
import com.kh.team3.freeBoard.model.vo.PageInfo;

public class BoardDao {
   

   private Properties prop = new Properties();

   public BoardDao() {
      String fileName = BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
      System.out.println("fileName   " + fileName);
      try {
    	  
         prop.load(new FileReader(fileName));
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block

         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block

         e.printStackTrace();
      }
   }
   
   public int getListCount(Connection conn) {
      
      int listCount = 0;
      Statement stmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("getListCount");
      
      try {
         stmt = conn.createStatement();
         rset = stmt.executeQuery(sql);
         
         if(rset.next()) {
            listCount = rset.getInt(1); // 숫자를 적거나 column명을 작성함 -> 보통은 column명을 적음
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
            close(rset);
            close(stmt);
         }

      return 0;
   }

   public ArrayList<Board> selectList(Connection conn, PageInfo pi) {
      ArrayList<Board> list = new ArrayList<>();
      
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      
      String sql = prop.getProperty("selectList");
      
      int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
      int endRow = startRow + pi.getBoardLimit() -1;
      
      /* currentPage = 1 -> startRow = 1, endRow = 10;
       * currentPage = 2 -> startRow = 11, endRow = 20;
       * currentPage = 3 -> startRow = 21, endRow = 30;
       * */
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         
         rset = pstmt.executeQuery();
         
         while(rset.next()) {
            list.add(new Board(rset.getInt("BOARD_NO"),
                           rset.getString("BOARD_TITLE"),
                           rset.getString("BOARD_CONTENT"),
                           rset.getInt("CATEGORY_NO"),
                           rset.getString("USER_ID"),
                           rset.getInt("BOARDTYPE_NO")
                           ));
            
           
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return list;
   }

   public int insertBoard(Connection conn, Board b) {
      
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("insertBoard");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1,b.getCategoryNo());
         pstmt.setString(2, b.getBoardTitle());
         pstmt.setString(3, b.getBoardContent());
         pstmt.setString(4, b.getUserId());
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public int insertAttachment(Connection conn, Attachment at) {
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("insertAttachment");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, at.getOriginName());
         pstmt.setString(2, at.getChangeName());
         pstmt.setString(3, at.getFilePath());
         
         
         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public int increaseCount(Connection conn, int bno) {
      int result = 0;
      PreparedStatement pstmt = null;
      
      String sql = prop.getProperty("increaseCount");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1,bno);

         result = pstmt.executeUpdate();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(pstmt);
      }
      
      return result;
   }

   public Board selectBoard(Connection conn, int bno) {
      Board b = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectBoard");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1,bno);

         rset = pstmt.executeQuery();
         
         if(rset.next()) { // bno로 딱 1개만 조회해서 while 안 써도 됨
            b = new Board(rset.getInt("BOARD_NO"),
                    rset.getString("BOARD_TITLE"),
                    rset.getString("BOARD_CONTENT"),
                    rset.getInt("CATEGORY_NO"),
                    rset.getString("USER_ID"),
                    rset.getInt("BOARDTYPE_NO")
                    );
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return b;
   }
   
   public Attachment selectAttachment(Connection conn, int bno) {
      Attachment at = null;
      PreparedStatement pstmt = null;
      ResultSet rset = null;
      
      String sql = prop.getProperty("selectAttachment");
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1,bno);

         rset = pstmt.executeQuery();
         
         if(rset.next()) { // bno로 딱 1개만 조회해서 while 안 써도 됨
            at = new Attachment();
            at.setFileNo(rset.getInt("FILE_NO"));
            at.setOriginName(rset.getString("ORIGIN_NAME"));
            at.setChangeName(rset.getString("CHANGE_NAME"));
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } finally {
         close(rset);
         close(pstmt);
      }
      
      return at;
   }

	public int deleteBoard(Connection conn, int bid) {
		 int result = 0;
	     PreparedStatement pstmt = null;
	     
	     String sql = prop.getProperty("deleteBoard");
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, bid);
	      
	        result = pstmt.executeUpdate();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } finally {
	        close(pstmt);
	     }
	     
	     return result;
	}

	public int deleteAttachment(Connection conn, int bid) {
		 int result = 0;
	     PreparedStatement pstmt = null;
	     
	     String sql = prop.getProperty("deleteAttachment");
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, bid);
	      
	        result = pstmt.executeUpdate();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } finally {
	        close(pstmt);
	     }
	     
	     return result;
	}

	public int updateBoard(Connection conn, Board b) {
		 int result = 0;
	     PreparedStatement pstmt = null;
	     String sql = prop.getProperty("updateBoard");
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, b.getCategoryNo());
	        pstmt.setString(2, b.getBoardTitle());
	        pstmt.setString(3, b.getBoardContent());
	        pstmt.setInt(4, b.getBoardNo());        
	      
	        result = pstmt.executeUpdate();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } finally {
	        close(pstmt);
	     }
	     
	     return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		int result = 0;
	     PreparedStatement pstmt = null;
	     String sql = prop.getProperty("updateAttachment");
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, at.getChangeName());
	        pstmt.setString(2, at.getOriginName());
	        pstmt.setString(3, at.getFilePath());
	        pstmt.setInt(4, at.getFileNo());        
	      
	        result = pstmt.executeUpdate();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } finally {
	        close(pstmt);
	     }
	     
	     return result;
	}

	public int insertNewAttachment(Connection conn, Attachment at) {
		  int result = 0;
	      PreparedStatement pstmt = null;

	      String sql = prop.getProperty("insertNewAttachment");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, at.getRefBoardNo());
	         pstmt.setString(2, at.getOriginName());
	         pstmt.setString(3, at.getChangeName());
	         pstmt.setString(4, at.getFilePath());	         
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	public ArrayList<Board> selectThList(Connection conn) {
		ArrayList<Board> list = new ArrayList<>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      
	      String sql = prop.getProperty("selectThList");
	
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	        	// 생성자 없어서 건건이 add 해서 객체 생성
	        	Board b = new Board();
	        	b.setBoardNo(rset.getInt("BOARD_NO"));
	        	b.setBoardTitle(rset.getString("BOARD_TITLE"));
	        	b.setBoardCount(rset.getInt("COUNT"));
	        	

	            list.add(b);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return list;
	   }

	public int insertThBoard(Connection conn, Board b) {
		  int result = 0;
	      PreparedStatement pstmt = null;
	      //INSERT INTO BOARD VALUES(SEQ_BNO.NEXTVAL, 2, NULL, ?, ?, ?, DEFAULT, SYSDATE, DEFAULT)
	      String sql = prop.getProperty("insertThBoard");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, b.getBoardTitle());
	         pstmt.setString(2, b.getBoardContent());
	         pstmt.setInt(3, Integer.parseInt(b.getUserId()));
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	public int insertThAttachment(Connection conn, ArrayList<Attachment> fileList) {
			int result = 0;
			PreparedStatement pstmt = null;
			//INSERT INTO ATTACHMENT VALUES(SEQ_FNO.NEXTVAL, SEQ_BNO.CURRVAL, ?, ?, ?, SYSDATE, 2, DEFAULT)
			String sql = prop.getProperty("insertAttachment");
		      try {
		    	  
		    	 for(int i = 0; i <fileList.size(); i++) {
		    		 
		    		 Attachment at = fileList.get(i);
		    		 pstmt = conn.prepareStatement(sql);
			         pstmt.setString(1, at.getOriginName());
			         pstmt.setString(2, at.getChangeName());
			         pstmt.setString(3, at.getFilePath());
			         
			         result += pstmt.executeUpdate();
		    	 }
		        
		      } catch (SQLException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      return result;
		}

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bid) {
		  ArrayList<Attachment> list = new ArrayList<>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      //selectAttachment=SELECT FILE_NO, ORIGIN_NAME, CHANGE_NAME FROM ATTACHMENT WHERE REF_BNO=? AND STATUS='Y'
	      
	      String sql = prop.getProperty("selectAttachment");
	
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, bid);
	         
	         rset = pstmt.executeQuery();
	         list = new ArrayList<>();
	         while(rset.next()) {
	        	
	        	Attachment at = new Attachment();
	        	at.setFileNo(rset.getInt("FILE_NO"));
	        	at.setOriginName(rset.getString("ORIGIN_NAME"));
	        	at.setChangeName(rset.getString("CHANGE_NAME"));
	        	
	            list.add(at);
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return list;
	   }

	public int insertReply(Connection conn, Reply r) {
		  int result = 0;
	      PreparedStatement pstmt = null;
	      
	      String sql = prop.getProperty("insertReply");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, r.getReplyContent() );
	         pstmt.setInt(2, r.getRefBoardId());
	         pstmt.setString(3, r.getReplyWriter());
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	public ArrayList<Reply> selectRList(Connection conn, int bId) {
		  ArrayList<Reply> list = new ArrayList<>();	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      // SELECT REPLY_NO, REPLY_CONTENT, USER_ID, CREATE_DATE FROM REPLY R JOIN MEMBER ON(REPLY_WRITER = USER_NO) 
	      // WHERE REF_BNO=? AND R.STATUS='Y' ORDER BY REPLY_NO DESC
	      String sql = prop.getProperty("selectRlist");
	
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, bId);
	         
	         rset = pstmt.executeQuery();
	         list = new ArrayList<>();
	         while(rset.next()) {
	        	list.add(new Reply(rset.getInt("REPLY_NO"),
	        					    rset.getString("REPLY_CONTENT"),
	        						rset.getString("USER_ID"),
	        						rset.getDate("CREATE_DATE")));
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return list;
	   }

	public ArrayList<Board> selectTopList(Connection conn) {
		 ArrayList<Board> list = null;	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;

//	      selectTopList=SELECT * FROM (SELECT BOARD_NO, BOARD_TITLE, COUNT, CHANGE_NAME \
//	    		  FROM BOARD JOIN (SELECT * FROM ATTACHMENT \
//	    		  WHERE FILE_NO IN( \
//	    		  SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY REF_BNO)) ON (REF_BNO = BOARD_NO) \
//	    		  WHERE BOARD.STATUS='Y' AND BOARD.BOARD_TYPE=2 ORDER BY COUNT DESC) WHERE ROWNUM <= 3
	      
	     
	      String sql = prop.getProperty("selectTopList");
	
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         rset = pstmt.executeQuery();
	         list = new ArrayList<>();
	         while(rset.next()) {
	        	Board b = new Board();
	        	
	        	b.setBoardNo(rset.getInt("BOARD_NO"));
	        	b.setBoardTitle(rset.getString("BOARD_TITLE"));
	        	
	        	
	        	list.add(b);
	    
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      
	      return list;
	   }

}