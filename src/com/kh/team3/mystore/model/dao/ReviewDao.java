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

	public int insertReview(Connection conn, Review rv) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rv.getUserId());
			pstmt.setString(2, rv.getContent());
			pstmt.setString(3, rv.getRadio());


			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<Review> selectList(Connection conn, String loginUserId) {
		ArrayList<Review> list = new ArrayList<Review>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReviewList");
		
//		SELECT B.BOARD_NO, C.CATEGORY_NAME, B.BOARD_TITLE, \
//		B.CREATE_DATE, B.BOARD_COUNT, B.LIKE_COUNT, A.REVIEW_CONTENT, A.REVIEW_RADIO\
//		FROM REVIEW A JOIN BOARD B ON B.BOARD_NO = A.BOARD_NO JOIN CATEGORY C  ON C.CATEGORY_NO = B.CATEGORY_NO\
//		ORDER BY 1 DESC
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
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

}
