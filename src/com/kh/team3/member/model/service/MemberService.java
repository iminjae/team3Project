package com.kh.team3.member.model.service;

import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.eventBoard.model.vo.Board;
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
		close(conn);
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
	public Member updateMember(Member member) {

		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MemberDao().updateMember(conn, member);
		System.out.println("통과!");
		System.out.println(result);
		if (result > 0) {
			commit(conn);
			System.out.println("통과!@");
			updateMem = new MemberDao().selectMember(conn, member.getUserId());

		} else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}
	public Member updatepwMember(String userId, String pw2) {
		Connection conn = getConnection();
		Member updateMem = null;
		int result = new MemberDao().updatepwMember(conn, userId, pw2);
		System.out.println("통과!");
		System.out.println(result);
		if (result > 0) {
			commit(conn);
			System.out.println("통과!@");
			updateMem = new MemberDao().selectMember(conn, userId);

		} else {
			rollback(conn);
		}
		close(conn);
		return updateMem;
	}
	public ArrayList<Member> selectMember() {
		
		Connection conn = getConnection();
		ArrayList<Member> list = new ArrayList<>();
		
		list = new MemberDao().selectMember(conn);
		
		close(conn);

		return list;
	}

 public Member findallmem(String name, String phone) {

		Connection conn = getConnection();
		Member list = new Member();
		System.out.println("서비스시작");
		list = new MemberDao().findMembertwo(conn,name,phone);
		System.out.println("서비스끝");
		
		close(conn);

		return list;
	}
public Member findallmempw(String id, String phone) {
	Connection conn = getConnection();
	Member list = new Member();
	System.out.println("서비스시작");
	list = new MemberDao().findMemberthree(conn,id,phone);
	System.out.println("서비스끝");
	
	close(conn);

	return list;
}
public int updateMemberpw(String id , String pw  ) {
	Connection conn = getConnection();
	Member updateMem = null;
	int result = new MemberDao().updateMemberpw(conn, id,pw);
	System.out.println("서비스 re " + result);
	if (result > 0) {
		commit(conn);

	} else {
		rollback(conn);
	}
	close(conn);
	return result;
}
	}
	
	



