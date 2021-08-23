package com.kh.team3.Notice.model.dao;

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

	public int insertBoard(Connection conn, Board b2) {
		  int result = 0;
	      PreparedStatement pstmt = null;
	      
	      String sql = prop.getProperty("insertBoard");
	      try {
	         pstmt = conn.prepareStatement(sql);
	         
	         pstmt.setString(1, b2.getBoardTitle());
	         pstmt.setString(2, b2.getBoardContent());
	         pstmt.setString(3, b2.getUserId());
	         
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
