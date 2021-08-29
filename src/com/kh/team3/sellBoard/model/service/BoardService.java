package com.kh.team3.sellBoard.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.sellBoard.model.dao.BoardDao;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;
import com.kh.team3.sellBoard.model.vo.Reply;
import com.kh.team3.sellBoard.model.vo.ThumbsUp;



public class BoardService {

	public Board selectBoard(int bNo) {
		Connection conn = getConnection();

		int result = new BoardDao().increaseCount(conn, bNo);

		Board b = null;

		if (result > 0) {
			commit(conn);
			b = new BoardDao().selectBoard(conn, bNo);
		} else {
			rollback(conn);
		}
		close(conn);

		System.out.println("BoardService :" + b);

		return b;

	}

	public ArrayList<Attachment> selectThumbnail(int bNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(conn, bNo);
		close(conn);
		System.out.println("BoardService :" + list);
		return list;
	}

	public ArrayList<Board> selectThList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectThList(conn);
		close(conn);
//		System.out.println("service : "+ list);
		return list;
	}

	public int insertThumbnail(String userId, Board b, ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
//		System.out.println("service: " + userId + b+ fileList);
		int result1 = new BoardDao().insertThBoard(conn, b, userId);
		// 사진게시판이라 파일첨부는 필수
		int result2 = new BoardDao().insertThAttachment(conn, fileList);

		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;
	}

	public int deleteBoard(int bNo) {
		Connection conn = getConnection();

		int result1 = new BoardDao().deleteBoard(conn, bNo);
		int result2 = new BoardDao().deleteAttachment(conn, bNo);

		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;

	}

	public ArrayList<Reply> selectRList(int bNo) {
		Connection conn = getConnection();
		ArrayList<Reply> list = new BoardDao().selectRList(conn, bNo);
		close(conn);
		return list;
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();

		int result = new BoardDao().insertReply(conn, r);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;

	}

	public Board selectUpdateBoard(int bNo) {
		Connection conn = getConnection();

		Board b = new BoardDao().selectBoard(conn, bNo);

		close(conn);
		return b;
	}

	public Attachment selectAttachment(int bNo) {
		Connection conn = getConnection();

		Attachment at = new BoardDao().selectAttachment(conn, bNo);

		close(conn);
		return at;
	}

	public ArrayList<Board> selectCList(int category) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectCList(conn, category);
		close(conn);

		return list;
	}


	public int insertThumbsUp(ThumbsUp thumbsUp) {
		Connection conn = getConnection();

		int result = new BoardDao().insertThumbsUp(conn, thumbsUp);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result;

	}

	public int plusThumbsUp(int bNo) {
		Connection conn = getConnection();

		int result = new BoardDao().plusThumbsUp(conn, bNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	
	}

	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		System.out.println("서비스" + b.toString());
		
		int result1 = new BoardDao().updateBoard(conn, b);
		int result2 = new BoardDao().updateAttachment(conn, at);
		
		System.out.println("updateBoard : " + b);

		if (result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;
	}

	
	public int delectRList(int bNo) {
		Connection conn = getConnection();

		int result = new BoardDao().delectRList(conn, bNo);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	
	}

	
}

		



