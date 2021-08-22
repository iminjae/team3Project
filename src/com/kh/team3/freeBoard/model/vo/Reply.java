package com.kh.team3.freeBoard.model.vo;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private String replyContent;
	private Date createDate;
	private String replyStatus;
	private int boardNo;
	private String userId;
	
	public Reply() {}
	
	
	
	

	public Reply(int replyNo, String replyContent, Date createDate, int boardNo, String userId) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.boardNo = boardNo;
		this.userId = userId;
	}





	public Reply(int replyNo, String replyContent, Date createDate, String replyStatus, int boardNo, String userId) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.createDate = createDate;
		this.replyStatus = replyStatus;
		this.boardNo = boardNo;
		this.userId = userId;
	}

	


	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getReplyStatus() {
		return replyStatus;
	}

	public void setReplyStatus(String replyStatus) {
		this.replyStatus = replyStatus;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
