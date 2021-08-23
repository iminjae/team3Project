package com.kh.team3.Notice.model.vo;

import java.sql.Date;

public class NoticeBoard {
	
	private int noticeNo;// 공지사항 번호
	private String noticeTitle; // 제목
	private String noticeContent;// 내용
	private Date createDate;// 작성일
	private String status;// 상태
	
	public NoticeBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public NoticeBoard(String noticeTitle, String noticeContent) {
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public NoticeBoard(int noticeNo, String noticeTitle, Date createDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.createDate = createDate;
	}
	
	public NoticeBoard(int noticeNo, String noticeTitle, String noticeContent, Date createDate) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.createDate = createDate;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NoticeBoard [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeContent=" + noticeContent
				+ ", createDate=" + createDate + ", status=" + status + "]";
	}
	
	
}
