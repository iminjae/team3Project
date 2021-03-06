package com.kh.team3.mystore.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.mystore.model.dao.ReviewDao;
import com.kh.team3.mystore.model.vo.Jjim;
import com.kh.team3.mystore.model.vo.Review;




public class ReviewService {
	
	//리뷰 추가
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
	
	//리뷰 조회
	public ArrayList<Review> selectList(String loginUserId) {
		Connection conn = getConnection();
		System.out.println("서비스 아이디" + loginUserId);
		ArrayList<Review> list = new ReviewDao().selectList(conn, loginUserId);
		close(conn);
		
		return list;	
	}
	
	//내가 받은 리뷰 조회
	public ArrayList<Review> selectGetList(String loginUserId) {
		Connection conn = getConnection();
		System.out.println("서비스 내가 받은 리뷰 조회 아이디" + loginUserId);
		ArrayList<Review> list = new ReviewDao().selectGetList(conn, loginUserId);
		close(conn);
		
		return list;	
	}
	
	//디테일서비스
	public Review selectReview(int nno) {
		Connection conn = getConnection();
		
		Review rv = new ReviewDao().selectReview(conn, nno);

		close(conn);
		
		return rv;
	}
	
	//마이게시글
	public ArrayList<Review> selectMyBoardList(String loginuserId) {
		Connection conn = getConnection();
		System.out.println("서비스 아이디" + loginuserId);
		ArrayList<Review> list = new ReviewDao().selectMyBoardList(conn, loginuserId);
		close(conn);
		
		return list;	
	}
	
	//찜 조회
	public ArrayList<Jjim> selectJjimList(String loginuserId) {
		Connection conn = getConnection();
		System.out.println("서비스 아이디" + loginuserId);
		ArrayList<Jjim> list = new ReviewDao().selectJjimList(conn, loginuserId);
		close(conn);
		
		return list;	
	}
	
	//찜 삭제
	public int deleteJjim(int jno) {
		Connection conn = getConnection();
		
		int result = new ReviewDao().deleteJjim(conn,jno);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	//찜 추가 
	public int insertJjim(Jjim Jjim) {
		Connection conn = getConnection();

		int result= new ReviewDao().insertJjim(conn,Jjim);
		
		
		if(result> 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}


	
//	//찜 하나만 조회에서 jsp에서
//	public Jjim selectJjimOne(String userId, int bNo) {
//		Connection conn = getConnection();
//		Jjim list = new ReviewDao().selectJjimOne(conn, userId, bNo);
//		
//		System.out.println("~~~~~~~~~~~~~서비스에서 객체담아서 다시 서블릿으로" + list);
//		close(conn);
//		
//		return list;
//	}

}
