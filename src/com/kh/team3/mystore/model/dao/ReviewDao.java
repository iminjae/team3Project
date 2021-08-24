package com.kh.team3.mystore.model.dao;


import static com.kh.team3.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.mystore.model.vo.Jjim;
import com.kh.team3.mystore.model.vo.Review;


public class ReviewDao {
	
	private Properties prop = new Properties();

	public ReviewDao() {
		String fileName = ReviewDao.class.getResource("/sql/mystore/mystore-query.properties").getPath();
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
	
	//리뷰인서트
	public int insertReview(Connection conn, Review rv) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rv.getUserId());
			pstmt.setInt(2, rv.getBoardNo());
			pstmt.setString(3, rv.getContent());
			pstmt.setString(4, rv.getRadio());


			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	//목록
	public ArrayList<Review> selectList(Connection conn, String loginUserId) {
		ArrayList<Review> list = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		

		System.out.println("다오 sql" + sql);
		try {
			System.out.println("다오 try sql" + sql);
			System.out.println("다오 트라이안 아이디"+ loginUserId);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginUserId );
			rset = pstmt.executeQuery(); 

			
			
			while(rset.next()) {
				list.add(new Review(rset.getInt("BOARD_NO"),
									rset.getString("CATEGORY_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getString("USER_ID"),
									rset.getDate("CREATE_DATE"), 
									rset.getInt("BOARD_COUNT"),
									rset.getInt("LIKE_COUNT"),
									rset.getString("REVIEW_CONTENT"),
									rset.getString("REVIEW_RADIO")
									));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		System.out.println("리뷰리스트다오>" + list);
		return list;
	}
	
	//디테일
	public Review selectReview(Connection conn, int nno) {
		Review rv =null;
	    PreparedStatement pstmt = null;
	    ResultSet rset = null; 
        String sql = prop.getProperty("selectReviewDetail");
        
        
//        SELECT B.BOARD_NO, C.CATEGORY_NAME, B.BOARD_TITLE, A.USER_ID,
//        B.CREATE_DATE, B.BOARD_COUNT, B.LIKE_COUNT, A.REVIEW_CONTENT, A.REVIEW_RADIO 
//        FROM REVIEW A JOIN BOARD B ON B.BOARD_NO = A.BOARD_NO 
//        JOIN CATEGORY C  ON C.CATEGORY_NO = B.CATEGORY_NO ORDER BY 1 DESC;
        try {
	         pstmt = conn.prepareStatement(sql);
	      
	         pstmt.setInt(1, nno);
	 
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	        	 rv = new Review(rset.getInt("BOARD_NO"),
								rset.getString("CATEGORY_NAME"),
								rset.getString("BOARD_TITLE"),
								rset.getString("USER_ID"),
								rset.getDate("CREATE_DATE"), 
								rset.getInt("BOARD_COUNT"),
								rset.getInt("LIKE_COUNT"),
								rset.getString("REVIEW_CONTENT"),
								rset.getString("REVIEW_RADIO")
							);
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }

	      
	      return rv;
	}

	//마이게시글
	public ArrayList<Review> selectMyBoardList(Connection conn, String loginuserId) {
		ArrayList<Review> list = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyBoard");
		
//		SELECT  A.BOARD_NO, C.BOARDTYPE_NAME, A.BOARD_TITLE, A.USER_ID, A.BOARD_COUNT, A.CREATE_DATE
//		FROM BOARD A JOIN CATEGORY B ON A.CATEGORY_NO = B.CATEGORY_NO
//		JOIN BOARDTYPE C ON A.BOARDTYPE_NO = C.BOARDTYPE_NO
//		WHERE A.USER_ID=? AND A.STATUS='Y' ORDER BY 1 DESC;

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginuserId);
			
			rset = pstmt.executeQuery(); 

			while(rset.next()) {
				list.add(new Review(rset.getInt("BOARD_NO"),
									rset.getString("BOARDTYPE_NAME"),
									rset.getString("BOARD_TITLE"),
									rset.getString("USER_ID"),
									rset.getInt("BOARD_COUNT"),								
									rset.getDate("CREATE_DATE")			
									));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	//찜 조회
	public ArrayList<Jjim> selectJjimList(Connection conn, String loginuserId) {
	ArrayList<Jjim> list = new ArrayList<Jjim>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMyJjim");
		
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, loginuserId );
			rset = pstmt.executeQuery(); 

			
			
			while(rset.next()) {
				list.add(new Jjim(rset.getInt("BOARD_NO"),
									rset.getString("USER_ID"),
									rset.getString("BOARD_TITLE"),
									rset.getString("BOARD_COUNT"),
									rset.getInt("LIKE_COUNT"),
									rset.getString("JJIM_CHECK"),
									rset.getString("CHANGE_NAME")
									));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}
	
	//찜 삭제
	public int deleteJjim(Connection conn, int jno) {
		 int result = 0;
	      PreparedStatement pstmt = null;
	      String sql = prop.getProperty("deleteMyJjim");
      
//	      UPDATE JJIM  SET
//	      JJIM_CHECK='N'
//	      WHERE BOARD_NO=?;
	      
	      try {
		         pstmt = conn.prepareStatement(sql);
		     
		         pstmt.setInt(1, jno);
		 
		         result = pstmt.executeUpdate();
		         
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      
		      return result;
	}
	
	//찜 추가
	public int insertJjim(Connection conn, Jjim jjim) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertJjim");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, jjim.getUserId());
			pstmt.setInt(2, jjim.getBoardNo());



			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}
	
//	//찜 하나만 조회 jsp에서 
//	public Jjim selectJjimOne(Connection conn, String userId, int bNo) {
//		Jjim one = null;
//		System.out.println("@@@@@@@@@찜 하나만 조회 다오 진입");
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		
//		String sql = prop.getProperty("selectOneJjim");
//		
//		System.out.println("에스큐엘"+ sql);
//		System.out.println("스트링 넘어올까?"+ userId +"~~" + bNo);
//		
////		SELECT A.BOARD_NO, A.USER_ID, B.JJIM_CHECK
////		FROM BOARD A JOIN JJIM B ON A.BOARD_NO = B.BOARD_NO
////		JOIN ATTACHMENT C ON B.BOARD_NO = C.BOARD_NO
////		WHERE B.USER_ID=? AND A.BOARD_NO=? AND B.JJIM_CHECK='Y' ORDER BY 1 DESC;
//
//		try {
//
//
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userId);
//			pstmt.setInt(2, bNo);
//			
//			rset = pstmt.executeQuery(); 
//
//			
//			
//		  if(rset.next()) {
//			  one = new Jjim(
//					  		rset.getString("USER_ID"), 
//					  		rset.getInt("BOARD_NO"),
//					  		rset.getString("JJIM_CHECK")
//							);
//	         }
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rset);
//			close(pstmt);
//		}
//
//		return one;
//	}

}
