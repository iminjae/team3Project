package com.kh.team3.report.dao;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.eventBoard.model.dao.EventBoardDao;
import com.kh.team3.mystore.model.vo.Review;
import com.kh.team3.report.model.vo.Report;
import com.kh.team3.sellBoard.model.dao.BoardDao;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;

public class ReportDao {

	private Properties prop = new Properties();

	public ReportDao() {
		String fileName = ReportDao.class.getResource("/sql/report/report-query.properties").getPath();
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

	public ArrayList<Report> reportList(Connection conn, String loginuserId) {
		ArrayList<Report> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;



		String sql = prop.getProperty("selectList");

		try {
			pstmt = conn.prepareStatement(sql);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				// 생성자 없어서 건건이 add 해서 객체 생성
				Report r = new Report();
				r.setReportNo(rset.getInt("REPORT_NO"));
				r.setReportCategory(rset.getString("REPORT_CATEGORY"));
				r.setReportWriter(rset.getString("USER_ID"));
				r.setReportNick(rset.getString("REPORT_NICKNAME"));
				r.setReportDate(rset.getString("REPORT_CREATEDATE"));

				

				list.add(r);


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

	public int insert(Connection conn, Report r) {
		
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReport");
		
		System.out.println(r.getReportNick());
		System.out.println(r.getReportContent());
		System.out.println(r.getReportWriter());
		System.out.println(r.getReportCategory());
		
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, r.getReportNick());
			pstmt.setString(2, r.getReportContent());
			pstmt.setString(3, r.getReportWriter());
			pstmt.setString(4, r.getReportCategory());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
		
		
	}

	public Report selectReport(Connection conn, int re) {
		Report rp =null;
	    PreparedStatement pstmt = null;
	    ResultSet rset = null; 
        String sql = prop.getProperty("selectReviewDetail");
        System.out.println("3333333333333333333");
        try {
	         pstmt = conn.prepareStatement(sql);
	      
	         pstmt.setInt(1, re);
	 
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	        	 rp = new Report(rset.getInt("REPORT_NO"),
									rset.getString("REPORT_NICKNAME"),
									rset.getString("REPORT_CONTENT"),
									rset.getString("USER_ID"),
									rset.getString("REPORT_CREATEDATE"),
									rset.getString("REPORT_CATEGORY")
								
							);
	         }
	         
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(pstmt);
	         close(rset);
	      }

	      System.out.println("rp 다오 : "+rp);
	      return rp;
	}

	
	

}
