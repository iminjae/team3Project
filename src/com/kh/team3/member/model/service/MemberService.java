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


}
