package com.kh.team3.review.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.team3.review.model.dao.ReviewDao;
import com.kh.team3.review.model.vo.Review;

public class ReviewService {
	
	//리뷰 등록
	public int insertReview(String userId, Review rv) {
		Connection conn = getConnection();
		
		int result= new ReviewDao().insertReview(conn, rv);
		
		
		if(result> 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

}
