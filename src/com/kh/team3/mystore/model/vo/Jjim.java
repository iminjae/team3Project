package com.kh.team3.mystore.model.vo;

import java.util.Date;

public class Jjim {
	
	private String jjimNo; 
	private String jjimCheck; 
	private int boardNo;
	private String boardTitle;
	private String boardCount; 
	private int likeCnt;
	private String userId;
	private String changeName;
	
	public Jjim() {
		// TODO Auto-generated constructor stub
	}

	public Jjim(String jjimNo, String jjimCheck, int boardNo, String boardTitle, String boardCount, int likeCnt, String userId,  String changeName) {
		super();
		this.jjimNo = jjimNo;
		this.jjimCheck = jjimCheck;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardCount = boardCount;
		this.likeCnt = likeCnt;
		this.userId = userId;
		this.changeName = changeName;
	}
	
	//조회 찜
	public Jjim(int boardNo, String userId, String boardTitle, String boardCount, int likeCnt, String jjimCheck, String changeName) {
		super();
		this.boardNo = boardNo;
		this.userId = userId;
		this.boardTitle = boardTitle;
		this.boardCount = boardCount;
		this.likeCnt = likeCnt;
		this.jjimCheck = jjimCheck;
		this.changeName = changeName;
	}
	
	//찜 하나 조회
		public Jjim(String userId, int boardNo, String jjimCheck) {
			super();
			this.userId = userId;
			this.boardNo = boardNo;
			this.jjimCheck = jjimCheck;
		}
		
     //인서트 찜
		public Jjim(String userId, int boardNo) {
			super();
			this.userId = userId;
			this.boardNo = boardNo;
		}
		
	
	
	public String getJjimNo() {
		return jjimNo;
	}

	public void setJjimNo(String jjimNo) {
		this.jjimNo = jjimNo;
	}

	public String getJjimCheck() {
		return jjimCheck;
	}

	public void setJjimCheck(String jjimCheck) {
		this.jjimCheck = jjimCheck;
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

	public String getBoardCount() {
		return boardCount;
	}

	public void setBoardCount(String boardCount) {
		this.boardCount = boardCount;
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
	
	

	public String getChangeName() {
		return changeName;
	}

	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}

	@Override
	public String toString() {
		return "Jjim [jjimNo=" + jjimNo + ", jjimCheck=" + jjimCheck + ", boardNo=" + boardNo + ", boardTitle="
				+ boardTitle + ", boardCount=" + boardCount + ", likeCnt=" + likeCnt + ", userId=" + userId
				+ ", changeName=" + changeName + "]";
	}

	
	


}
