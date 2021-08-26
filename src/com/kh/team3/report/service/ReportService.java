package com.kh.team3.report.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.eventBoard.model.dao.EventBoardDao;
import com.kh.team3.mystore.model.dao.ReviewDao;
import com.kh.team3.mystore.model.vo.Review;
import com.kh.team3.report.dao.ReportDao;
import com.kh.team3.report.model.vo.Report;
import com.kh.team3.sellBoard.model.dao.BoardDao;
import com.kh.team3.sellBoard.model.vo.Attachment;

public class ReportService {

	public  ArrayList<Report> reportList(String loginuserId) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Report> list = new ReportDao().reportList(conn, loginuserId);
		close(conn);
		
		return list;
	}

	public int insert(Report r) {
		Connection conn = getConnection();
		
		int result = new ReportDao().insert(conn,r);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public Report selectReport(int re) {
		
		Connection conn = getConnection();
		System.out.println("22222222222222222");
		Report rp = new ReportDao().selectReport(conn, re);
		System.out.println("444444444444444444");
		close(conn);
		
		return rp;
	}

	
	

}
