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
		return b;

	}

	public ArrayList<Attachment> selectThumbnail(int bNo) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(conn, bNo);
		close(conn);
		return list;
	}

	public ArrayList<Board> selectThList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectThList(conn);
		close(conn);
		//System.out.println("service : "+ list);
		return list;
	}

}
