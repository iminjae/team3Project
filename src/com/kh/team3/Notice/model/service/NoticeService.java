package com.kh.team3.Notice.model.service;

import static com.kh.team3 .common.JDBCTemplate.close;
import static com.kh.team3 .common.JDBCTemplate.commit;
import static com.kh.team3 .common.JDBCTemplate.getConnection;
import static com.kh.team3 .common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.Notice.model.dao.NoticeDao;
import com.kh.team3.Notice.model.vo.NoticeBoard;
import com.kh.team3.eventBoard.model.vo.Board;

public class NoticeService {
	

	public ArrayList<NoticeBoard> selectList() {
		Connection conn = getConnection();
		
		ArrayList<NoticeBoard> list = new NoticeDao().selectList(conn);
		close(conn);
		
		return list;
	}

	public int insertNotice(NoticeBoard b2 ,String userId) {
		Connection conn = getConnection();
		System.out.println("서비스"+ b2);
		
		int result = new NoticeDao().insertNotice(conn,b2 , userId);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public NoticeBoard selectNotice(int nno) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().increaseCount(conn, nno);
		NoticeBoard n = null;
		if(result > 0) {
			commit(conn);
			// 상세조회를 하러 왔기 때문에 cnt 올리고 커밋하고 조회 새로 하는것
			n = new NoticeDao().selectNotice(conn, nno);
			
		}else {
			rollback(conn);
		}
		close(conn);
		return n;
	}

	public int deleteNotice(int nno) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn,nno);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public NoticeBoard selectUpdateNotice(int nno) {
		Connection conn = getConnection();
		
		NoticeBoard n = new NoticeDao().selectNotice(conn, nno);
		close(conn);
		
		return n;
	}

	public int updateNotice(NoticeBoard n) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn,n);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	

}
