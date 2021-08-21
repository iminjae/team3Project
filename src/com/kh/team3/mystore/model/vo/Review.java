package com.kh.team3.mystore.model.vo;

import java.util.Date;

public class Review {

	private String reviewNo; 
	private String userId; 
	private int boardNo;
	private String content; 
	private String radio;
	private int category;
	private String boardTitle;
	private Date createDate;
	private int likeCnt;
	private int count;
	private String categoryName;
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String reviewNo, String userId, int boardNo, String content, String radio, int category,
			String boardTitle, Date createDate, int likeCnt, int count, String categoryName) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.boardNo = boardNo;
		this.content = content;
		this.radio = radio;
		this.category = category;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.likeCnt = likeCnt;
		this.count = count;
		this.categoryName = categoryName;
	}


	public Review(String userId, String content, String radio) {
		super();
		this.userId = userId;
		this.content = content;
		this.radio = radio;
	}
	
	//리스트생성자
	public Review( int boardNo, String categoryName, String boardTitle, String userId, Date createDate,  int count, int likeCnt, 
			String content, String radio ) {
		super();
		this.boardNo = boardNo;
		this.categoryName = categoryName;
		this.boardTitle = boardTitle;
		this.userId = userId;
		this.createDate = createDate;	
		this.count = count;
		this.likeCnt = likeCnt;
		this.content = content;
		this.radio = radio;

	}

	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", userId=" + userId + ", boardNo=" + boardNo + ", content=" + content
				+ ", radio=" + radio + ", category=" + category + ", boardTitle=" + boardTitle + ", createDate="
				+ createDate + ", likeCnt=" + likeCnt + ", count=" + count + ", categoryName=" + categoryName + "]";
	}



	

}
