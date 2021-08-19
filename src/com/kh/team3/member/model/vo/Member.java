package com.kh.team3.member.model.vo;

public class Member {

	private String userId;
	private String userPwd;
	private String userName;
	private String phone;
	private String nickname;
	private double startpoint;
	private int categoryno;
	private String address;
	private String status;
	

	public Member() {
	}
	

	public Member(String userId, String userPwd, String userName, String phone, String nickname, int categoryno,
			String address) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.nickname = nickname;
		this.categoryno = categoryno;
		this.address = address;
	}


	

	public Member(String userId, String userPwd, String userName, String phone, String nickname, double startpoint,
			int categoryno, String address, String status) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.phone = phone;
		this.nickname = nickname;
		this.startpoint = startpoint;
		this.categoryno = categoryno;
		this.address = address;
		this.status = status;
	}




	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", phone=" + phone
				+ ", nickname=" + nickname + ", startpoint=" + startpoint + ", categoryno=" + categoryno + ", address="
				+ address + ", status=" + status + "]";
	}




	public Member(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}




	public String getUserId() {
		return userId;
	}




	public void setUserId(String userId) {
		this.userId = userId;
	}




	public String getUserPwd() {
		return userPwd;
	}




	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}




	public String getUserName() {
		return userName;
	}




	public void setUserName(String userName) {
		this.userName = userName;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public double getStartpoint() {
		return startpoint;
	}




	public void setStartpoint(double startpoint) {
		this.startpoint = startpoint;
	}




	public int getCategoryno() {
		return categoryno;
	}




	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}


	
}
