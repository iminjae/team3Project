package com.kh.team3.chat.vo;

public class Chat {
	
	
	private int chatNo;
	private String chatName;
	private String chatContent;
	private String chatTime;
	private int BoardNo;
	
	
	public Chat() {
		// TODO Auto-generated constructor stub-
	}
	

	public int getBoardNo() {
		return BoardNo;
	}




	public void setBoardNo(int boardNo) {
		BoardNo = boardNo;
	}




	public int getChatNo() {
		return chatNo;
	}



	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}



	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getChatTime() {
		return chatTime;
	}

	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}
	
	
}
