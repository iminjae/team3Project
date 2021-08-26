package com.kh.team3.report.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.chat.dao.ChatDao;
import com.kh.team3.chat.vo.Chat;
import com.kh.team3.report.dao.ReportDao;
import com.kh.team3.report.model.vo.Report;

public class ReportService {

	public  ArrayList<Report> reportList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Report> list = new ReportDao().reportList(conn);
		close(conn);
		
		return list;
	}


}
