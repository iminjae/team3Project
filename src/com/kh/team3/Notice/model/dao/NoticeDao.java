package com.kh.team3.Notice.model.dao;


import static com.kh.team3.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.Notice.model.dao.NoticeDao;
import com.kh.team3.Notice.model.vo.NoticeBoard;
import com.kh.team3.eventBoard.model.vo.Board;

public class NoticeDao {
	
	private Properties prop = new Properties();
	
	public NoticeDao() {
	      String fileName = NoticeDao.class.getResource("/sql/notice/notice-query.properties").getPath();
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
	
	
	public ArrayList<NoticeBoard> selectList(Connection conn) {
		ArrayList<NoticeBoard> list = new ArrayList<NoticeBoard>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new NoticeBoard(rset.getInt("NOTICE_NO"),
										rset.getString("NOTICE_TITLE"),
										rset.getString("NOTICE_CONTENT"),
										rset.getDate("CREATE_DATE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	

	public int insertNotice(Connection conn, NoticeBoard b2 ,String userId) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertNotice");
		System.out.println("dao@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+b2);
		System.out.println("sql@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+sql);
		try {
			// 쿼리문에 컬럼 없기 때문에 테이블의 순서대로 넣어줌
			//insertNotice=INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL, ?, ?, SYSDATE, ?)
			//INSERT INTO NOTICE VALUES(SEQ_NOTICE_NO.NEXTVAL, 'title', 'content', SYSDATE, 'admin');
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b2.getNoticeTitle());
			pstmt.setString(2, b2.getNoticeContent());
			pstmt.setString(3, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public int increaseCount(Connection conn, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("increaseCount");
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	
	public NoticeBoard selectNotice(Connection conn, int nno) {
		NoticeBoard n = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new NoticeBoard(rset.getInt("NOTICE_NO"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getDate("CREATE_DATE"));											
									
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return n;
	}

	
	public int deleteNotice(Connection conn, int nno) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("deleteNotice");
		try {
			// 쿼리문에 컬럼 없기 때문에 테이블의 순서대로 넣어줌
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateNotice(Connection conn, NoticeBoard n) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public NoticeBoard selectBoard(Connection conn, int bno) {
		NoticeBoard b = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectBoard");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,bno);

	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) { // bno로 딱 1개만 조회해서 while 안 써도 됨
	            b = new NoticeBoard(rset.getInt("NOTICE_NO"),
				                    rset.getString("NOTICE_TITLE"),
				                    rset.getString("NOTICE_CONTENT"),
				                    rset.getDate("CREATE_DATE"));              
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

}
