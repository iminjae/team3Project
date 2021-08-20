package com.kh.team3.member.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.team3.member.model.dao.MemberDao;
import com.kh.team3.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {

		Connection conn = getConnection();

		Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);
		close(conn);

		return loginUser;
	}
	public int insertMember(Member mem) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn,mem);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	public int idCheck(String userId) {
		Connection conn = getConnection();
		
		int result = new MemberDao().idCheck(conn,userId);
		
		close(conn);
		
		return result;
	
	}
	public int deleteMember(String userId) {
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, userId);
		if (result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


}
