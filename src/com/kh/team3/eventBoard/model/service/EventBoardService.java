package com.kh.team3.eventBoard.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.eventBoard.model.dao.EventBoardDao;
import com.kh.team3.eventBoard.model.vo.Attachment;
import com.kh.team3.eventBoard.model.vo.Board;

public class EventBoardService {

	public int insertThumbnail(Board b, Attachment at) {
Connection conn = getConnection();
		
		int result1 = new EventBoardDao().insertThBoard(conn, b);
		int result2 = new EventBoardDao().insertAttachment(conn, at);
		
		
		if(result1 >0 && result2 > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;



	}
	
	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();

		int result1 = new EventBoardDao().updateBoard(conn, b);
		int result2 = 1;
		System.out.println("서비스의 at : " +at);
		if (at != null) {
			System.out.println("$");
				result2 = new EventBoardDao().updateAttachment(conn, at);
			}

		System.out.println("#");
		if (result1 * result2 > 0) {
			System.out.println("#1");
			commit(conn);
			System.out.println("#2");
			
		} else {
			rollback(conn);
		}
		close(conn);
		return result1 * result2;

	}

	public ArrayList<Board> selectThList() {
		Connection conn = getConnection();

		ArrayList<Board> list = new EventBoardDao().selectThList(conn);

		close(conn);

		return list;
	}

	public Board selectBoard(int bno) {
		Connection conn = getConnection();
		System.out.println("서비스 접근 및 조회수 다오 입장 전");
		int result = new EventBoardDao().increaseCount(conn, bno);

		Board b = null;
		if (result > 0) {
			commit(conn);
			System.out.println("조회수 올리고 커밋 후에 board 조회 다오 입장 전");
			b = new EventBoardDao().selectBoard(conn, bno);
			System.out.println("board 조회 완료");
		} else {
			rollback(conn);
		}

		close(conn);

		return b;
	}

	public Attachment selectThumnail(int bid) {
		Connection conn = getConnection();
		System.out.println("파일 조회 입장 전");
		Attachment list = new EventBoardDao().selectThumnail(conn, bid);
		System.out.println("파일 조회 퇴장");
		close(conn);
		return list;
	}
	
	public int deleteBoard(int bid) {

		Connection conn = getConnection();

		int result1 = new EventBoardDao().deleteBoard(conn, bid);
		int result2 = new EventBoardDao().deleteAttachment(conn, bid);

		if (result1 > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}

		close(conn);

		return result1;
	}

	public Board selectUpdateBoard(int bno) {

		Connection conn = getConnection();

		Board b = new EventBoardDao().selectBoardtwo(conn, bno);

		close(conn);

		return b;
	}
	
	public Attachment selectAttachment(int bno) {
		Connection conn = getConnection();

		Attachment at = new EventBoardDao().selectAttachment(conn, bno);

		close(conn);

		return at;
	}
}





