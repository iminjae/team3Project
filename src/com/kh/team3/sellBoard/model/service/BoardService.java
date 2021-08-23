package com.kh.team3.sellBoard.model.service;

import static com.kh.team3.common.JDBCTemplate.*;
import java.sql.Connection;
import java.util.ArrayList;
import com.kh.team3.sellBoard.model.dao.BoardDao;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;
import com.kh.team3.sellBoard.model.vo.PageInfo;
import com.kh.team3.sellBoard.model.vo.Reply;

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
		ArrayList<Board> list = new BoardDao().selectThList(conn); // 카테고리 번호 전달
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

	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();

		int result1 = new BoardDao().updateBoard(conn, b);
		int result2 = 1;

		if (at != null) {
			if (at.getFileNo() != 0) {
				result2 = new BoardDao().updateAttachment(conn, at);
			} else {
				result2 = new BoardDao().insertNewAttachment(conn, at);
			}
		}
		if (result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;
	}

	public Board selectUpdateBoard(int bNo) {
		Connection conn = getConnection();

		// 단순 조회만
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

}
