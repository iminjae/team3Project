package com.kh.team3.freeBoard.model.service;

import static com.kh.team3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.freeBoard.model.dao.BoardDao;
import com.kh.team3.freeBoard.model.vo.Board;
import com.kh.team3.freeBoard.model.vo.PageInfo;
import com.kh.team3.sellBoard.model.vo.Attachment;


public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new BoardDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		System.out.println("1");
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		close(conn);
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().insertBoard(conn, b);
		
	
		if(result1  > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1 ;
	}


	public Board selectBoard(int bno) {
		Connection conn = getConnection();
		
		int result = new BoardDao().increaseCount(conn, bno);
		
		Board b = null;
		
		if(result > 0) {
			commit(conn);
			b = new BoardDao().selectBoard(conn, bno);
		}else {
			rollback(conn);
		}close(conn);
		return b;
		
		
	}

	
	public int deleteBoard(int bid) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().deleteBoard(conn,bid);
		
		// 첨부파일이 필수는 아니라서
		if(result1 > 0) { 
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1;

	}

	public Board selectUpdateBoard(int bno) {
		Connection conn = getConnection();
		
		// 단순 조회만
		Board b = new BoardDao().selectBoard(conn, bno);
		
		close(conn);
		return b;
	}

	public int updateBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().updateBoard(conn, b);
		int result2 = 1;
		
		
		if(result1 * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1 * result2;
	}

	public ArrayList<Board> selectThList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectThList(conn);
		close(conn);
		return list;
	}

	
	

}
