package com.kh.team3.exchange.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.exchange.dao.ExchangeDao;
import com.kh.team3.exchange.vo.Exchange;
import com.kh.team3.sellBoard.model.dao.BoardDao;
import com.kh.team3.sellBoard.model.vo.Board;



	public class ExchangeService {
		
		
		
		public ArrayList<Exchange> exchangeList() {
			Connection conn = getConnection();
			ArrayList<Exchange> list = new ExchangeDao().exchangeList(conn); // 카테고리 번호 전달
			close(conn);
	
			return list;
		}
}
