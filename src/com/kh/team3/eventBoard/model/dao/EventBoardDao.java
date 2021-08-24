package com.kh.team3.eventBoard.model.dao;

import static com.kh.team3.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.eventBoard.model.vo.Attachment;
import com.kh.team3.eventBoard.model.vo.Board;

public class EventBoardDao {
   

   private Properties prop = new Properties();

   public EventBoardDao() {
      String fileName = EventBoardDao.class.getResource("/sql/eventBoard/eventBoard-query.properties").getPath();
      System.out.println("fileName   " + fileName);
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

public int insertThBoard(Connection conn,Board b) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("insertBoard");
	//insertBoard=INSERT INTO BOARD VALUES(SEQ_BNO.NEXTVAL,?, ?, NULL, 0, SYSDATE, 0, DEFAULT , NULL , ? , 10)
	System.out.println("정보 입력" + b.getBoardTitle() +b.getBoardContent() + b.getUserId());
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, b.getBoardTitle());
		pstmt.setString(2, b.getBoardContent());
		pstmt.setString(3, b.getUserId());
		
		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
		}
	System.out.println("정보입력 끝");
	return result;
}


public int insertAttachment(Connection conn, Attachment at) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("insertAttachment");
	//insertAttachment=INSERT INTO ATTACHMENT VALUES(SEQ_FNO.NEXTVAL,?,?,?,SYSDATE,DEFAULT, 2)
	System.out.println("파일 입력" + at.getOriginName() + at.getChangeName() + at.getFilePath() );
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, at.getOriginName());
		pstmt.setString(2, at.getChangeName());
		pstmt.setString(3, at.getFilePath());

		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return result;
}

public ArrayList<Board> selectThList(Connection conn) {
	ArrayList<Board> list = new ArrayList<>();

	PreparedStatement pstmt = null;
	ResultSet rset = null;

	String sql = prop.getProperty("selectThList");

	try {
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while (rset.next()) {
			Board b = new Board();
			b.setBoardNo(rset.getInt("BOARD_NO"));
			b.setBoardTitle(rset.getString("BOARD_TITLE"));
			b.setBoardCount(rset.getInt("BOARD_COUNT"));
			b.setTitleImg(rset.getString("CHANGE_NAME"));

			list.add(b);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return list;

}
public ArrayList<Board> selectThListtwo(Connection conn) {
	ArrayList<Board> list = new ArrayList<>();

	PreparedStatement pstmt = null;
	ResultSet rset = null;

	String sql = prop.getProperty("selectThListtwo");

	try {
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while (rset.next()) {
			Board b = new Board();
			b.setBoardNo(rset.getInt("BOARD_NO"));
			b.setBoardTitle(rset.getString("BOARD_TITLE"));
			b.setBoardContent(rset.getString("BOARD_CONTENT"));
			b.setTitleImg(rset.getString("CHANGE_NAME"));

			list.add(b);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return list;

}

public int increaseCount(Connection conn, int bno) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("increaseCount");

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);

		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return result;
}
public Board selectBoard(Connection conn, int bno) {
	Board b = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("selectBoard");
	System.out.println("보드 상세조회 입장");

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);

		rset = pstmt.executeQuery();
		if (rset.next()) {
			b = new Board(rset.getInt("BOARD_NO"), rset.getString("BOARD_TITLE"), rset.getString("BOARD_CONTENT"),
					rset.getInt("BOARD_COUNT"),	rset.getDate("CREATE_DATE") , rset.getString("USER_ID"));
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(rset);

		close(pstmt);
	}

	return b;
}
public Attachment selectThumnail(Connection conn, int bid) {
	Attachment at = new Attachment();
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	System.out.println("파일 조회 입장");
	System.out.println(bid);
	String sql = prop.getProperty("selectAttachment");
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);
		
		rset = pstmt.executeQuery();
		
		if(rset.next()) {
			
			at.setFileNo(rset.getInt("FILE_NO"));	
			at.setOriginName(rset.getString("ORIGIN_NAME"));
			at.setChangeName(rset.getString("CHANGE_NAME"));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	finally {
		close(rset);
		close(pstmt);
	}
	System.out.println("파일 조회 퇴장전");
	return at;
}
public int deleteBoard(Connection conn, int bid) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("deleteBoard");

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);

		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return result;
}

public int deleteAttachment(Connection conn, int bid) {
	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("deleteAtachment");

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bid);

		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	return result;
}

public Attachment selectAttachment(Connection conn, int bno) {

	Attachment at = null;
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	String sql = prop.getProperty("selectAttachment");

	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);

		rset = pstmt.executeQuery();
		if (rset.next()) {
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

public Board selectBoardtwo(Connection conn, int bno) {
	Board b = new Board();

	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("selectThListtwo");
	System.out.println("se;ectBoardtwo sql 실행전 : " + bno);
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		rset = pstmt.executeQuery();
		if (rset.next()) {
			
			b.setBoardNo(rset.getInt("BOARD_NO"));
			b.setBoardTitle(rset.getString("BOARD_TITLE"));
			b.setBoardContent(rset.getString("BOARD_CONTENT"));
			b.setTitleImg(rset.getString("CHANGE_NAME"));
			
			System.out.println(rset.getInt("BOARD_NO"));
			System.out.println(rset.getString("BOARD_TITLE"));
			System.out.println(rset.getString("BOARD_CONTENT"));
			System.out.println(rset.getString("CHANGE_NAME"));
			
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return b;

}


public int updateBoard(Connection conn, Board b) {
	int result = 0;
	PreparedStatement pstmt = null;

	String sql = prop.getProperty("updateBoard");

	try {
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, b.getBoardTitle());
		pstmt.setString(2, b.getBoardContent());
		pstmt.setInt(3, b.getBoardNo());
		result = pstmt.executeUpdate();
		System.out.println("보드업데이트 리슐" +result);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return result;
}


public int updateAttachment(Connection conn, Attachment at) {
	int result = 0;
	PreparedStatement pstmt = null;
	System.out.println("파일 업데이트 다오 입장 : " + at);
	String sql = prop.getProperty("updateAttachment");
	//UPDATE ATTACHMENT SET ORIGIN_NAME=? , CHANGE_NAME=?, UPLOAD_DATE=SYSDATE WHERE BOARD_NO=?
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, at.getOriginName());
		pstmt.setString(2, at.getChangeName());
		pstmt.setInt(3, at.getRefBoardNo());
		
		result = pstmt.executeUpdate();
		System.out.println("다오 리슐:" +result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	System.out.println("파일 업데이트 다오 리턴전");
	return result;
}

public int selectpic(Connection conn,String userId) {
	int result = 0;
	
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("picpic");
	System.out.println("se;ectBoardtwo sql 실행전 : " + userId);
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		rset = pstmt.executeQuery();
		if (rset.next()) {
			
			result = 1;
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	
	
	
	return result;
}

public int insertpic(Connection conn, Attachment at, String userId) {

	int result = 0;
	PreparedStatement pstmt = null;
	String sql = prop.getProperty("insertpic");
	System.out.println("파일 입력" + at.getOriginName() + at.getChangeName() + at.getFilePath() );
	
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, at.getOriginName());
		pstmt.setString(2, at.getChangeName());
		pstmt.setString(3, at.getFilePath());
		pstmt.setString(4, userId);

		result = pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	return result;
}

public int updatepic(Connection conn, Attachment at, String userId) {
	int result = 0;
	PreparedStatement pstmt = null;
	System.out.println("파일 업데이트 다오 입장 : " + at);
	String sql = prop.getProperty("uppic");
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, at.getOriginName());
		pstmt.setString(2, at.getChangeName());
		pstmt.setString(3, userId);
		result = pstmt.executeUpdate();
		System.out.println("다오 리슐:" +result);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}
	System.out.println("파일 업데이트 다오 리턴전");
	return result;

}

public String selectpicp(Connection conn, String userId) {
String result = null;
	
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	
	String sql = prop.getProperty("picpic");
	System.out.println("se;ectBoardtwo sql 실행전 : " + userId);
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		rset = pstmt.executeQuery();
		if (rset.next()) {
			
			result = rset.getString("CHANGE_NAME");
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		close(pstmt);
	}

	
	
	
	return result;
}



}