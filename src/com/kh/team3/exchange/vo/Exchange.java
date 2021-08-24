package com.kh.team3.exchange.vo;

import java.sql.Date;

public class Exchange {
	

	private int boardNo;			//게시물번호
	private int boardType;			//게시글 타입
	private String boardTitle;		//게시글제목
	private String boardContent;	//게시글 내용
	private String boardWriter;		//게시글 쓴사람
	private int count;				// 조회수
	private Date createDate;		//게시글 생성일
	private String status;			// 게시글상태 y n
	
	private String titleImg;	 //게시글 사진
	
	
	
	public Exchange() {
		// TODO Auto-generated constructor stub
	}

	
	
	


	public Exchange(int boardNo, int boardType, String boardTitle, String boardContent,
			String boardWriter, int count, Date createDate, String status, String titleImg) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.count = count;
		this.createDate = createDate;
		this.status = status;
		this.titleImg = titleImg;
	}






	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}



	public int getBoardType() {
		return boardType;
	}



	public void setBoardType(int boardType) {
		this.boardType = boardType;
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



	public String getBoardWriter() {
		return boardWriter;
	}



	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
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



	public String getTitleImg() {
		return titleImg;
	}



	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}
	
	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardType=" + boardType + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardWriter=" + boardWriter + ", count=" + count
				+ ", createDate=" + createDate + ", status=" + status + ", titleImg=" + titleImg + "]";
	}
	
	
}
