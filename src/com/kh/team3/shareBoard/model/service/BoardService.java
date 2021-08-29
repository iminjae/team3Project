package com.kh.team3.shareBoard.model.service;


import static com.kh.team3.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.shareBoard.model.dao.BoardDao;
import com.kh.team3.shareBoard.model.vo.Board;
import com.kh.team3.shareBoard.model.vo.PageInfo;
import com.kh.team3.shareBoard.model.vo.Reply;
import com.kh.team3.shareBoard.model.vo.Attachment;


public class BoardService {

	public int getListCount() {
		Connection conn = getConnection();
		int listCount = new BoardDao().getListCount(conn);
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		
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

	
	public int deleteBoard(int bno) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().deleteBoard(conn,bno);
		
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

	public int updateBoard(Board b) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().updateBoard(conn, b);

		
		
		if(result1  > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1 ;
	}

	public ArrayList<Board> selectThList() {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().selectThList(conn);
		close(conn);
		return list;
	}

	public int insertReply(Reply r) {
		Connection conn = getConnection();
		
		int result = new BoardDao().insertReply(conn, r);
		
		if(result > 0) { 
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;

	}

	public ArrayList<Reply> selectRList(int bno) {
		
		Connection conn = getConnection();
		ArrayList<Reply> list = new BoardDao().selectRList(conn, bno);
		close(conn);
		return list;
	}

	public int replyDelete(int rno) {
		Connection conn = getConnection();
		
		int result1 = new BoardDao().deleteReply(conn,rno);
		
		
		if(result1 > 0) { 
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result1;
	}

	public ArrayList<Board> serachIdList(PageInfo pi,String userId) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().searchIdList(conn, pi,userId);
		close(conn);
		return list;
		
	}

	public ArrayList<Board> serachTitleList(PageInfo pi, String title) {
		Connection conn = getConnection();
		ArrayList<Board> list = new BoardDao().searchTitleList(conn, pi,title);
		close(conn);
		return list;
	}

	public int insertSBoard(String user,Board b,
			ArrayList<Attachment> fileList) {
		Connection conn = getConnection();
		int result1 = new BoardDao().insertSBoard(conn, b, user);
		// 사진게시판이라 파일첨부는 필수
		int result2 = new BoardDao().insertAttachment(conn, fileList);

		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;
	}

	public ArrayList<Attachment> selectThumbnail(int bno) {
		Connection conn = getConnection();
		ArrayList<Attachment> list = new BoardDao().selectThumbnail(conn, bno);
		close(conn);
		return list;
	}

	public int updateSBoard( Board b, ArrayList<Attachment> fileList) {
		
		Connection conn = getConnection();
		int result1 = new BoardDao().updateBoard(conn, b);
		// 사진게시판이라 파일첨부는 필수
		
		int result2 = new BoardDao().updateAttachment(conn, fileList,b.getBoardNo());
		
		
		System.out.println("result1 : " + result1);
		System.out.println("result2 : " + result2);
		
		if (result1 > 0 && result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);

		return result1 * result2;
		
	}
	

}
