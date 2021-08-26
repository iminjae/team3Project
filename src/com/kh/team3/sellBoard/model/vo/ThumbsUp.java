package com.kh.team3.sellBoard.model.vo;

public class ThumbsUp {
	private int thumbsUp; 
	private String thumbsUpCk; 
	private int boardNo;
	private int likeCnt;
	private String userId;

	public ThumbsUp() {
		// TODO Auto-generated constructor stub
	}

	public ThumbsUp(int thumbsUp, String thumbsUpCk, int boardNo, int likeCnt, String userId) {
		super();
		this.thumbsUp = thumbsUp;
		this.thumbsUpCk = thumbsUpCk;
		this.boardNo = boardNo;
		this.likeCnt = likeCnt;
		this.userId = userId;
	}

	public ThumbsUp(int boardNo, String userId) {
		super();
		this.boardNo = boardNo;
		this.userId = userId;
	}

	public int getThumbsUp() {
		return thumbsUp;
	}

	public void setThumbsUp(int thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	public String getThumbsUpCk() {
		return thumbsUpCk;
	}

	public void setThumbsUpCk(String thumbsUpCk) {
		this.thumbsUpCk = thumbsUpCk;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}

