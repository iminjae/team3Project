package com.kh.team3.freeBoard.model.dao;

import static com.kh.team3.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.freeBoard.model.vo.Board;
import com.kh.team3.freeBoard.model.vo.PageInfo;
import com.kh.team3.freeBoard.model.vo.Reply;
import com.kh.team3.member.model.vo.Member;

public class BoardDao {
   

   private Properties prop = new Properties();

   public BoardDao() {
      String fileName = BoardDao.class.getResource("/sql/freeBoard/board-query.properties").getPath();
//      System.out.println("fileName1 :  " + fileName);
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
            list.add(new Board(
            				rset.getInt("BOARD_NO"),
            				rset.getString("BOARD_TITLE"),
            				rset.getInt("BOARD_COUNT"),
            				rset.getDate("CREATE_DATE"),
            				rset.getString("CATEGORY_NAME"),
            				rset.getString("USER_ID")
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
         
         pstmt.setString(1, b.getBoardTitle());
         pstmt.setString(2, b.getBoardContent());
         pstmt.setInt(3,b.getCategoryNo());
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
                    rset.getInt("BOARD_COUNT"),
                    rset.getDate("CREATE_DATE"),
                    rset.getInt("LIKE_COUNT"),
                    rset.getString("CATEGORY_NAME"),
                    rset.getString("USER_ID")
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
   
  

	public int deleteBoard(Connection conn, int bno) {
		 int result = 0;
	     PreparedStatement pstmt = null;
	     
	     String sql = prop.getProperty("deleteBoard");
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, bno);
	      
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

	public int insertReply(Connection conn, Reply r) {
		  int result = 0;
	      PreparedStatement pstmt = null;
	      
	      String sql = prop.getProperty("insertReply");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, r.getReplyContent() );
	         pstmt.setInt(2, r.getBoardNo());
	         pstmt.setString(3, r.getUserId());
	         
	         result = pstmt.executeUpdate();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	      }
	      
	      return result;
	   }

	public ArrayList<Reply> selectRList(Connection conn, int bno) {
			
		  ArrayList<Reply> list = new ArrayList<>();	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	     
	      String sql = prop.getProperty("selectRlist");
	
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, bno);
	         
	         rset = pstmt.executeQuery();
	         list = new ArrayList<>();
	         while(rset.next()) {
	        	list.add(new Reply(rset.getInt("REPLY_NO"),
	        					    rset.getString("REPLY_CONTENT"),
	        					    rset.getDate("CREATE_DATE"),
	        						rset.getString("USER_ID"),
	        						rset.getInt("BOARD_NO")
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

	public int deleteReply(Connection conn, int rno) {
		 int result = 0;
	     PreparedStatement pstmt = null;
	     
	     String sql = prop.getProperty("deleteReply");
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, rno);
	      
	        result = pstmt.executeUpdate();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } finally {
	        close(pstmt);
	     }
	     
	     return result;
	}

	public ArrayList<Board> searchIdList(Connection conn, PageInfo pi, String userId) {
		ArrayList<Board> list = new ArrayList<>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      
	      String sql = prop.getProperty("searchIdList");
	      
	      int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
	      int endRow = startRow + pi.getBoardLimit() -1;
	      
	      /* currentPage = 1 -> startRow = 1, endRow = 10;
	       * currentPage = 2 -> startRow = 11, endRow = 20;
	       * currentPage = 3 -> startRow = 21, endRow = 30;
	       * */
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, userId);
	         pstmt.setInt(2, startRow);
	         pstmt.setInt(3, endRow);
	         
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            list.add(new Board(
	            				rset.getInt("BOARD_NO"),
	            				rset.getString("BOARD_TITLE"),
	            				rset.getInt("BOARD_COUNT"),
	            				rset.getDate("CREATE_DATE"),
	            				rset.getString("CATEGORY_NAME"),
	            				rset.getString("USER_ID")
	            				
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

	public ArrayList<Board> searchTitleList(Connection conn, PageInfo pi, String title) {
		ArrayList<Board> list = new ArrayList<>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      
	      String sql = prop.getProperty("searchTitleList");
	      
	      int startRow = (pi.getCurrentPage()-1) * pi.getBoardLimit() +1;
	      int endRow = startRow + pi.getBoardLimit() -1;
	      
	      /* currentPage = 1 -> startRow = 1, endRow = 10;
	       * currentPage = 2 -> startRow = 11, endRow = 20;
	       * currentPage = 3 -> startRow = 21, endRow = 30;
	       * */
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, title);
	         pstmt.setInt(2, startRow);
	         pstmt.setInt(3, endRow);
	        
	         
	         rset = pstmt.executeQuery();
	         
	         while(rset.next()) {
	            list.add(new Board(
	            				rset.getInt("BOARD_NO"),
	            				rset.getString("BOARD_TITLE"),
	            				rset.getInt("BOARD_COUNT"),
	            				rset.getDate("CREATE_DATE"),
	            				rset.getString("CATEGORY_NAME"),
	            				rset.getString("USER_ID")
	            				
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

	public int updateStar(Connection conn, Member m, String rate) {
		 int result = 0;
	     PreparedStatement pstmt = null;
	     String sql = prop.getProperty("updateRate");
	     
	     
	     try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, Integer.parseInt(rate));
	        pstmt.setString(2, m.getUserId());
	              
	      
	        result = pstmt.executeUpdate();
	     } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	     } finally {
	        close(pstmt);
	     }
	     
	     return result;
	}

}