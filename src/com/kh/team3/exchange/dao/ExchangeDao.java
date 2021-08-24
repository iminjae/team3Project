package com.kh.team3.exchange.dao;

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

import com.kh.team3.exchange.vo.Exchange;
import com.kh.team3.sellBoard.model.dao.BoardDao;
import com.kh.team3.sellBoard.model.vo.Board;

public class ExchangeDao {
	
	private Properties prop = new Properties();

	public ExchangeDao() {
		String fileName = BoardDao.class.getResource("/sql/exchange/exchage-query.properties").getPath();
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

	public ArrayList<Exchange> exchangeList(Connection conn) {
		ArrayList<Exchange> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("List");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				
				
				
				Exchange b = new Exchange();
				b.setBoardTitle(rset.getString("BOARD_TITLE"));
				b.setBoardContent(rset.getInt("BOARD_CONTENT"));
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
	
}
