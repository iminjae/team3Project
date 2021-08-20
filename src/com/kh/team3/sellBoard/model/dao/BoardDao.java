package com.kh.team3.sellBoard.model.dao;



import static com.kh.team3.common.JDBCTemplate.*;

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


import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;
import com.kh.team3.sellBoard.model.vo.PageInfo;
import com.kh.team3.sellBoard.model.vo.Reply;

public class BoardDao {
   

   private Properties prop = new Properties();

   public BoardDao() {
      String fileName = BoardDao.class.getResource("/sql/sellBoard/sellBoard-query.properties").getPath();
      System.out.println("fileName" + fileName);
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

	public int increaseCount(Connection conn, int bNo) {
		int result = 0;
	    PreparedStatement pstmt = null;
	    
	    String sql = prop.getProperty("increaseCount");
	    try {
	       pstmt = conn.prepareStatement(sql);
	       pstmt.setInt(1, bNo);
	
	       result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	       // TODO Auto-generated catch block
	       e.printStackTrace();
	    } finally {
	       close(pstmt);
	    }
	    
	    return result;
	}

	public Board selectBoard(Connection conn, int bNo) {
		  Board b = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectBoard");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, bNo);

	         rset = pstmt.executeQuery();
	         
//	         BOARD_NO // 게시글번호
//	         BOARD_TITLE // 게시글 제목
//	         BOARD_CONTENT // 게시글 내용
//	         BOARD_STATUS // 게시글 상태(판매중..)
//	         BOARD_COUNT // 게시글 조회수
//	         CREATE_DATE // 작성날짜
//	         LIKE_COUNT // 추천수
//	         STATUS // 삭제여부
//	         CATEGORY_NAME // 카테고리번호(노트북..) LEFT JOIN CATEGORY USING(CATEGORY_NO) 
//	         USER_ID // 작성자
//	         BOARDTYPE_NAME // 게시판 타입(1. 판매게시판) LEFT JOIN BOARDTYPE USING(BOARDTYPE_NO) 
//	         PRICE // 가격
	         
//	         selectBoard B.BOARD_NO, A.CATEGORY_NAME, B.BOARD_TITLE, B.BOARD_CONTENT, D.USER_ID, 
//	         B.BOARD_COUNT, B.CREATE_DATE, B.LIKE_COUNT, C.BOARDTYPE_NAME, B.PRICE 
//	         FROM BOARD B JOIN MEMBER D ON D.USER_ID = B.USER_ID 
//	         LEFT JOIN CATEGORY A ON A.CATEGORY_NO = B.CATEGORY_NO 
//	         LEFT JOIN BOARDTYPE C ON C.BOARDTYPE_NO = B.BOARDTYPE_NO WHERE B.STATUS = 'Y' AND B.BOARD_NO=1;

	         
	         if(rset.next()) { // bNo로 조회
	            b = new Board(rset.getInt("BOARD_NO"),
	                     rset.getString("CATEGORY_NAME"),
	                     rset.getString("BOARD_TITLE"),
	                     rset.getString("BOARD_CONTENT"),
	                     rset.getString("USER_ID"),
	                     rset.getInt("BOARD_COUNT"),
	                     rset.getDate("CREATE_DATE"), 
	                     rset.getInt("LIKE_COUNT"), 
	                     rset.getString("BOARDTYPE_NAME"), 
	                     rset.getInt("PRICE") 
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

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bNo) {
		ArrayList<Attachment> list = new ArrayList<>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      //selectAttachment=SELECT FILE_NO, ORIGIN_NAME, CHANGE_NAME 
	      //FROM ATTACHMENT WHERE BOARD_NO=? AND STATUS='Y'
	      
	      String sql = prop.getProperty("selectAttachment");
	
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, bNo);
	         
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

	public ArrayList<Board> selectThList(Connection conn) {
		  ArrayList<Board> list = new ArrayList<>();
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
//	      SELECT B.BOARD_NO, B.BOARD_TITLE, B.BOARD_COUNT, A.CHANGE_NAME 
//	      FROM BOARD B JOIN (SELECT * FROM ATTACHMENT 
//	      WHERE FILE_NO IN(SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY BOARD_NO)) A  ON (B.BOARD_NO = A.BOARD_NO)
//	      WHERE B.STATUS='Y' AND B.BOARDTYPE_NO=1 ORDER BY B.BOARD_NO DESC;
	      
	      //test = SELECT BOARD_NO, BOARD_TITLE FROM BOARD WHERE BOARDTYPE_NO= 1
	      
	      String sql = prop.getProperty("selectThList");
	      System.out.println("dao sql : " + sql);
	      try {
	         pstmt = conn.prepareStatement(sql);
	         rset = pstmt.executeQuery();

	         while(rset.next()) {
	        	// 생성자 없어서 건건이 add 해서 객체 생성
	        	Board b = new Board();
	        	b.setBoardNo(rset.getInt("BOARD_NO"));
	        	b.setBoardTitle(rset.getString("BOARD_TITLE"));
	        	b.setCount(rset.getInt("BOARD_COUNT"));
	        	b.setTitleImg(rset.getString("CHANGE_NAME"));
	        	
	        	
	            
	        	list.add(b);
//	            System.out.println("dao list : " + list);
	            System.out.println("dao b : " + b);
	           
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	      System.out.println("dao list : " + list);
	      return list;
	   }

}