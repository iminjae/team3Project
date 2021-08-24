package com.kh.team3.report.model.vo;

public class Report {
	
	
	private int reportNo;
	private String reportNick;
	private String reportContent;
	private String reportWriter;
	private int reportCategoryNo;
	private String reportDate;
	

	
	
	
	public Report() {
		// TODO Auto-generated constructor stub
	}





	public Report(int reportNo, String reportNick, String reportContent, String reportWriter, int reportCategoryNo,
			String reportDate) {
		super();
		this.reportNo = reportNo;
		this.reportNick = reportNick;
		this.reportContent = reportContent;
		this.reportWriter = reportWriter;
		this.reportCategoryNo = reportCategoryNo;
		this.reportDate = reportDate;
	}





	public int getReportNo() {
		return reportNo;
	}





	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}





	public String getReportNick() {
		return reportNick;
	}





	public void setReportNick(String reportNick) {
		this.reportNick = reportNick;
	}





	public String getReportContent() {
		return reportContent;
	}





	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}





	public String getReportWriter() {
		return reportWriter;
	}





	public void setReportWriter(String reportWriter) {
		this.reportWriter = reportWriter;
	}





	public int getReportCategoryNo() {
		return reportCategoryNo;
	}





	public void setReportCategoryNo(int reportCategoryNo) {
		this.reportCategoryNo = reportCategoryNo;
	}





	public String getReportDate() {
		return reportDate;
	}





	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}





	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reportNick=" + reportNick + ", reportContent=" + reportContent
				+ ", reportWriter=" + reportWriter + ", reportCategoryNo=" + reportCategoryNo + ", reportDate="
				+ reportDate + "]";
	}
	
	
	
	
}
