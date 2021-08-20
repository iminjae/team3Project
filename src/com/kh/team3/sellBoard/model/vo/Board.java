package com.kh.team3.sellBoard.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo;			// 게시글 고유 번호
	private int boardType;			// 게시글 타입번호(1.판매게시판)
	private String boardTypeName;   // 게시글 타입이름(1.판매게시판)
	private String category;		// 판매물품 분류(1~5)
	private String boardTitle;		// 게시글 제목
	private String boardContent;	// 게시글 내용
	private int price;				// 판매물품 가격
	private String boardWriter;		// 게시글 작성자 (번호 또는 이름)
	private int bCnt;				// 게시글 조회수
	private int likeCnt;			// 게시글 좋아요 수
	private Date createDate;		// 게시글 작성일
	private String boardStatus;		// 게시글 상태(판매중|판매완료)
	private String status;			// 게시글 상태값(Y,삭제시N)
	private String titleImg;		// 게시글의 타이틀 이미지 (실제 서버에 업로드되어있는 이름)
	
	public Board() {
		
	}

	public Board(int boardNo, int boardType, String boardTypeName, String category, String boardTitle,
			String boardContent, int price, String boardWriter, int bCnt, int likeCnt, Date createDate,
			String boardStatus, String status, String titleImg) {
		super();
		this.boardNo = boardNo;
		this.boardType = boardType;
		this.boardTypeName = boardTypeName;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.price = price;
		this.boardWriter = boardWriter;
		this.bCnt = bCnt;
		this.likeCnt = likeCnt;
		this.createDate = createDate;
		this.boardStatus = boardStatus;
		this.status = status;
		this.titleImg = titleImg;
	}

	// selectBoard
	public Board(int boardNo, String category, String boardTitle, String boardContent, String boardWriter, int bCnt,
			Date createDate, int likeCnt, String status, int price) {
		super();
		this.boardNo = boardNo;
		this.category = category;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.bCnt = bCnt;
		this.boardWriter = boardWriter;
		this.bCnt = bCnt;
		this.createDate = createDate;
		this.likeCnt = likeCnt;
		this.status = status;
		this.price = price;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getCount() {
		return bCnt;
	}

	public void setCount(int bCnt) {
		this.bCnt = bCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getBoardStatus() {
		return boardStatus;
	}

	public void setBoardStatus(String boardStatus) {
		this.boardStatus = boardStatus;
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
		return "Board [boardNo=" + boardNo + ", boardType=" + boardType + ", boardTypeName=" + boardTypeName
				+ ", category=" + category + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", price=" + price + ", boardWriter=" + boardWriter + ", bCnt=" + bCnt + ", likeCnt=" + likeCnt
				+ ", createDate=" + createDate + ", boardStatus=" + boardStatus + ", status=" + status + ", titleImg="
				+ titleImg + "]";
	}

	
		

}
