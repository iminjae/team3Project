package com.kh.team3.sellBoard.model.dao;

import static com.kh.team3.common.JDBCTemplate.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;
import com.kh.team3.sellBoard.model.vo.Reply;
import com.kh.team3.sellBoard.model.vo.ThumbsUp;

public class BoardDao {

	private Properties prop = new Properties();

	public BoardDao() {
		String fileName = BoardDao.class.getResource("/sql/sellBoard/sellBoard-query.properties").getPath();
		System.out.println("fileName" + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int increaseCount(Connection conn, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		// UPDATE BOARD SET BOARD_COUNT=BOARD_COUNT+1 WHERE BOARD_NO=?
		String sql = prop.getProperty("increaseCount");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public Board selectBoard(Connection conn, int bNo) {
		Board b = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			rset = pstmt.executeQuery();
			
//			SELECT B.BOARD_NO, A.CATEGORY_NAME, B.BOARD_TITLE,
//			B.BOARD_CONTENT, D.USER_ID, B.BOARD_STATUS, 
//			B.BOARD_COUNT, B.CREATE_DATE, 
//			B.LIKE_COUNT, C.BOARDTYPE_NAME, B.PRICE, D.THUMBSUP_CHECK, B.STATUS 
//			FROM BOARD B JOIN MEMBER D ON D.USER_ID = B.USER_ID 
//			LEFT JOIN CATEGORY A ON A.CATEGORY_NO = B.CATEGORY_NO 
//			LEFT JOIN BOARDTYPE C ON C.BOARDTYPE_NO = B.BOARDTYPE_NO 
//			LEFT JOIN THUMBSUP D ON D.BOARD_NO = B.BOARD_NO 
//			WHERE B.STATUS = 'Y' AND B.BOARD_NO=?
//			
			if (rset.next()) { // bNo로 조회
				b = new Board(rset.getInt("BOARD_NO"), 
						rset.getString("CATEGORY_NAME"), 
						rset.getString("BOARD_TITLE"),
						rset.getString("BOARD_CONTENT"), 
						rset.getString("USER_ID"), 
						rset.getString("BOARD_STATUS"), 
						rset.getInt("BOARD_COUNT"),
						rset.getDate("CREATE_DATE"), 
						rset.getInt("LIKE_COUNT"), 
						rset.getString("BOARDTYPE_NAME"),
						rset.getInt("PRICE"),
						rset.getString("THUMBSUP_CHECK"),
						rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("BoardDao :" + b);
		return b;
	}

	public ArrayList<Attachment> selectThumbnail(Connection conn, int bNo) {
		ArrayList<Attachment> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// selectAttachment=SELECT FILE_NO, ORIGIN_NAME, CHANGE_NAME
		// FROM ATTACHMENT WHERE BOARD_NO=? AND STATUS='Y'

		String sql = prop.getProperty("selectAttachment");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while (rset.next()) {

				Attachment at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));

				list.add(at);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		System.out.println("BoardDao :" + list);
		return list;
	}

	public ArrayList<Board> selectThList(Connection conn) {
		ArrayList<Board> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

//		SELECT B.BOARD_NO, B.BOARD_TITLE, B.USER_ID, B.BOARD_COUNT, A.CHANGE_NAME, B.BOARDTYPE_NO, C.CATEGORY_NAME, B.BOARD_STATUS
//		FROM BOARD B JOIN CATEGORY C  ON (B.CATEGORY_NO=C.CATEGORY_NO)
//		JOIN (SELECT * FROM ATTACHMENT 
//		WHERE FILE_NO IN(SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY BOARD_NO)) A  ON (B.BOARD_NO = A.BOARD_NO)
//		WHERE B.STATUS='Y' AND B.BOARDTYPE_NO=1 ORDER BY B.BOARD_NO DESC;

		String sql = prop.getProperty("selectThList");
//		System.out.println("dao sql : " + sql);
		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				// 생성자 없어서 건건이 add 해서 객체 생성
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setUserId(rset.getString("USER_ID"));
				b.setbCnt(rset.getInt("BOARD_COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBoardStatus(rset.getString("BOARD_STATUS"));
				b.setLikeCnt(rset.getInt("LIKE_COUNT"));


				list.add(b);
//	            System.out.println("dao list : " + list);
//				System.out.println("dao b : " + b);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
//		System.out.println("dao list : " + list);
		return list;
	}

	public int insertThBoard(Connection conn, Board b, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;

//		System.out.println("dao: " + userId + b);

//		INSERT INTO BOARD
//		VALUES (SEQ_BOARD_NO.NEXTVAL, BOARD_TITLE, BOARD_CONTENT,
//	    BOARD_STATUS, BOARD_COUNT,CREATE_DATE, LIKE_COUNT, STATUS,
//		CATEGORY_NO, USER_ID, BOARDTYPE_NO, PRICE)

//		INSERT INTO BOARD
//		VALUES (SEQ_BOARD_NO.NEXTVAL, ?, ?,
//	    ?, DEFAULT, SYSDATE, DEFAULT, DEFAULT, 
//		? , ? , 1, ?)

//		BOARD_TITLE
//		BOARD_CONTENT
//		BOARD_STATUS
//		CATEGORY_NO
//		USER_ID
//		PRICE

		String sql = prop.getProperty("insertThBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardStatus());
			pstmt.setInt(4, b.getCategory());
			pstmt.setString(5, b.getUserId());
			pstmt.setInt(6, b.getPrice());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int insertThAttachment(Connection conn, ArrayList<Attachment> fileList) {
		int result = 0;
		PreparedStatement pstmt = null;

//		INSERT INTO ATTACHMENT
//		VALUES (SEQ_FILE_NO.NEXTVAL, 'ORIGIN_NAME','CHANGE_NAME','FILE_PATH', UPLOAD_DATE, STATUS, BOARD_NO, BOARDTYPE_NO);

//		INSERT INTO ATTACHMENT
//		VALUES (SEQ_FILE_NO.NEXTVAL, ?, ?, ?, SYSDATE, DEFAULT, SEQ_BOARD_NO.CURRVAL);

//		ORIGIN_NAME
//		CHANGE_NAME
//		FILE_PATH

		String sql = prop.getProperty("insertAttachment");
		try {

			for (int i = 0; i < fileList.size(); i++) {

				Attachment at = fileList.get(i);
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, at.getOriginName());
				pstmt.setString(2, at.getChangeName());
				pstmt.setString(3, at.getFilePath());

				result += pstmt.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteBoard(Connection conn, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		// UPDATE BOARD SET STATUS='N' WHERE BOARD_NO=?
		String sql = prop.getProperty("deleteBoard");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteAttachment(Connection conn, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		// UPDATE ATTACHMENT SET STATUS='N' WHERE BOARD_NO=?
		String sql = prop.getProperty("deleteAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Reply> selectRList(Connection conn, int bNo) {
		ArrayList<Reply> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

//	      SELECT R.REPLY_NO, R.REPLY_CONTENT, R.USER_ID, R.CREATE_DATE FROM REPLY R JOIN MEMBER M ON(R.USER_ID = M.USER_ID) 
//	      WHERE R.BOARD_NO=? AND R.REPLY_STATUS='Y' ORDER BY R.REPLY_NO DESC
		String sql = prop.getProperty("selectRlist");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			while (rset.next()) {// M.NICKNAME ?
				list.add(new Reply(rset.getInt("REPLY_NO"), rset.getString("REPLY_CONTENT"), rset.getString("USER_ID"),
						rset.getDate("CREATE_DATE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertReply(Connection conn, Reply r) {
		int result = 0;
		PreparedStatement pstmt = null;

		// INSERT INTO REPLY VALUES(SEQ_REPLY_NO.NEXTVAL, ?, SYSDATE, DEFAULT, ? , ?)
		String sql = prop.getProperty("insertReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, r.getReplyContent());
			pstmt.setInt(2, r.getRefBoardId());
			pstmt.setString(3, r.getReplyWriter());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateBoard");
		System.out.println("updateBoard dao:" + b);
		System.out.println("updateBoard sql:" + sql);


//		UPDATE BOARD SET BOARD_TITLE=?, BOARD_CONTENT=?, 
//				BOARD_STATUS=?, CATEGORY_NO=?, PRICE=? 
//				WHERE BOARD_NO=?


//		BOARD_TITLE
//		BOARD_CONTENT
//		BOARD_STATUS
//		CATEGORY_NO
//		PRICE
//		BOARD_NO
		
		System.out.println("b.getBoardTitle()"+ b.getBoardNo());
		System.out.println("b.getBoardContent()"+b.getBoardContent()) ;
		System.out.println("b.getBoardStatus()"+b.getBoardStatus());
		System.out.println("b.getCategory()"+b.getCategory());
		System.out.println("b.getPrice()"+b.getPrice());
		System.out.println("b.getBoardNo()"+b.getBoardNo());
		

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getBoardStatus());
			pstmt.setInt(4, b.getCategory());
			pstmt.setInt(5, b.getPrice());
			pstmt.setInt(6, b.getBoardNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("updateBoard result:" + result);
		return result;
	}

	public int updateAttachment(Connection conn, Attachment at) {
		int result = 0;
		PreparedStatement pstmt = null;
		// UPDATE ATTACHMENT SET CHANGE_NAME=?, ORIGIN_NAME=? WHERE
		// BOARD_NO=?

		String sql = prop.getProperty("updateAttachment");

		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, at.getChangeName());
			pstmt.setString(2, at.getOriginName());
			pstmt.setInt(3, at.getRefBoardNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Attachment selectAttachment(Connection conn, int bNo) {
		Attachment at = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectAttachment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			rset = pstmt.executeQuery();

			if (rset.next()) { // bNo로 딱 1개만 조회해서 while 안 써도 됨
				at = new Attachment();
				at.setFileNo(rset.getInt("FILE_NO"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return at;
	}

	public ArrayList<Board> selectCList(Connection conn, int category) {
		ArrayList<Board> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

//		SELECT B.BOARD_NO, B.BOARD_TITLE, B.USER_ID, B.BOARD_COUNT, A.CHANGE_NAME, B.BOARDTYPE_NO, C.CATEGORY_NAME, B.BOARD_STATUS
//		FROM BOARD B JOIN CATEGORY C  ON (B.CATEGORY_NO=C.CATEGORY_NO)
//		JOIN (SELECT * FROM ATTACHMENT 
//		WHERE FILE_NO IN(SELECT MIN(FILE_NO) FILE_NO FROM ATTACHMENT WHERE STATUS='Y' GROUP BY BOARD_NO)) A  ON (B.BOARD_NO = A.BOARD_NO)
//		WHERE B.STATUS='Y' AND B.BOARDTYPE_NO=1 AND CATEGORY_NO = ? ORDER BY B.BOARD_NO DESC;

		String sql = prop.getProperty("selectCList");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, category);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				// 생성자 없어서 건건이 add 해서 객체 생성
				Board b = new Board();
				b.setBoardNo(rset.getInt("BOARD_NO"));
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setUserId(rset.getString("USER_ID"));
				b.setbCnt(rset.getInt("BOARD_COUNT"));
				b.setTitleImg(rset.getString("CHANGE_NAME"));
				b.setCategoryName(rset.getString("CATEGORY_NAME"));
				b.setBoardStatus(rset.getString("BOARD_STATUS"));

				list.add(b);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return list;
	}

	public int insertThumbsUp(Connection conn, ThumbsUp thumbsUp) {
		int result = 0;
		PreparedStatement pstmt = null;

		// INSERT INTO THUMBSUP VALUES(SEQ_LIKE_NO.NEXTVAL, 'Y', ?, ?)
		String sql = prop.getProperty("insertThumbsUp");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thumbsUp.getUserId());
			pstmt.setInt(2, thumbsUp.getBoardNo());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int plusThumbsUp(Connection conn, int bNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		// UPDATE BOARD SET LIKE_COUNT=LIKE_COUNT+1 WHERE BOARD_NO=?
		String sql = prop.getProperty("plusThumbsUp");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int deleteReply(Connection conn, int rNo) {
		int result = 0;
		PreparedStatement pstmt = null;

		// UPDATE REPLY SET REPLY_STATUS='N' WHERE REPLY_NO=?
		String sql = prop.getProperty("deleteReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNo);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

}

