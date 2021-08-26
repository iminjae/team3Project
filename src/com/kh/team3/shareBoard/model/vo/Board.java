package com.kh.team3.shareBoard.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo;			
	private String boardTitle;		
	private String boardContent;	
	private String boardStatus;
	private int boardCount;
	private Date createDate;
	private int likeCount;
	private String status;		
	private int categoryNo;
	private String userId;
	private int boardType;
	private String categoryName;
	
	
	
	public Board() {
		
	}

	

	public Board(int boardNo, String boardTitle, String boardContent, String userId) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userId = userId;
	}



	public Board(int boardNo, String boardTitle, String boardContent, int boardCount, Date createDate, int likeCount,
			 String userId,String categoryName) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCount = boardCount;
		this.createDate = createDate;
		this.likeCount = likeCount;
		this.userId = userId;
		this.categoryName = categoryName;
	}


	public Board(int boardNo, String boardTitle, String boardContent, int boardCount, Date createDate, int likeCount,
			int categoryNo, String userId,String categoryName) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardCount = boardCount;
		this.createDate = createDate;
		this.likeCount = likeCount;
		this.categoryNo = categoryNo;
		this.userId = userId;
		this.categoryName = categoryName;
	}


	public Board(int boardNo, String boardTitle, String boardContent, String boardStatus, int boardCount,
			Date createDate, int likeCount, String status, int categoryNo, String userId, int boardType) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardStatus = boardStatus;
		this.boardCount = boardCount;
		this.createDate = createDate;
		this.likeCount = likeCount;
		this.status = status;
		this.categoryNo = categoryNo;
		this.userId = userId;
		this.boardType = boardType;
	}




	public Board(int boardNo, String boardTitle, int boardCount, Date createDate, int categoryNo, String userId) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardCount = boardCount;
		this.createDate = createDate;
		this.categoryNo = categoryNo;
		this.userId = userId;
	}



	public int getBoardNo() {
		return boardNo;
	}




	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public String getBoardTitle() {
		return boardTitle;
	}



	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}



	public String getBoardContent() {
		return boardContent;
	}



	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}



	public String getBoardStatus() {
		return boardStatus;
	}



	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
	}



	public int getBoardCount() {
		return boardCount;
	}



	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public int getLikeCount() {
		return likeCount;
	}



	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getCategoryNo() {
		return categoryNo;
	}



	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public int getBoardType() {
		return boardType;
	}



	public void setBoardType(int boardType) {
		this.boardType = boardType;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardStatus=" + boardStatus + ", boardCount=" + boardCount + ", createDate=" + createDate
				+ ", likeCount=" + likeCount + ", status=" + status + ", categoryNo=" + categoryNo + ", userId="
				+ userId + ", boardType=" + boardType + "]";
	}






	


	
	
	

}
