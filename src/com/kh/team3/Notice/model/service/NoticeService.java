package com.kh.team3.Notice.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.team3.Notice.model.dao.NoticeDao;
import com.kh.team3.Notice.model.vo.NoticeBoard;
import com.kh.team3.eventBoard.model.vo.Board;


public class NoticeService {


	public int NoticeBoard(Board b2) {
		Connection conn = getConnection();
		
		int result1 = new NoticeDao().insertBoard(conn, b2);
		
		if(result1  > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1 ;
	}

	
}
