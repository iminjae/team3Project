package com.kh.team3.review.model.vo;

public class Review {

	private String reviewNo; 
	private String userId; 
	private int boardNo;
	private String content; 
	private String radio; 
	
	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(String reviewNo, String userId, int boardNo, String content, String radio) {
		super();
		this.reviewNo = reviewNo;
		this.userId = userId;
		this.boardNo = boardNo;
		this.content = content;
		this.radio = radio;
	}
	
	public Review(String userId, String content, String radio) {
		super();
		this.userId = userId;
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
	
	

}
