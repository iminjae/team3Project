package com.kh.team3.member.model.dao;

import static com.kh.team3.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.eventBoard.model.vo.Board;
import com.kh.team3.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();
	

	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		System.out.println("fileName   " + fileName);
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Member loginMember(Connection conn, String userId, String userPwd) {

		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("loginMember");
		System.out.println(sql);
		System.out.println("!" + userId);
		System.out.println("!" + userPwd);
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rset = pstmt.executeQuery();
			System.out.println(rset);
			if (rset.next()) {
				loginUser = new Member(

						 rset.getString("USER_ID"), rset.getString("USER_PWD"),
						rset.getString("USER_NAME"), rset.getString("PHONE"), rset.getString("NICKNAME"),
						rset.getDouble("STARPOINT"), rset.getInt("CATEGORY_NO"), rset.getString("ADDRESS"), rset.getString("STATUS")
					
				);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return loginUser;

	}

	public int insertMember(Connection conn, Member mem) {
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
	
		System.out.println(mem.getUserId());
		System.out.println(mem.getUserPwd());
		System.out.println(mem.getUserName());
		System.out.println(mem.getPhone());
		System.out.println(mem.getNickname());
		System.out.println(mem.getAddress());
		System.out.println(mem.getCategoryno());
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getUserId());
			pstmt.setString(2, mem.getUserPwd());
			pstmt.setString(3, mem.getUserName());
			pstmt.setString(4, mem.getPhone());
			pstmt.setString(5, mem.getNickname());
			pstmt.setInt(6, mem.getCategoryno());
			pstmt.setString(7, mem.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		
		return result;
	}

	public int idCheck(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("idCheck");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				result = rset.getInt(1);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updateMember");
		System.out.println(m);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getNickname());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
		
			System.out.println("!@#!@#!@#");
				result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	public Member selectMember(Connection conn, String userId) {
		Member mem = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("!!!!!!!!!!!!!");
		String sql = prop.getProperty("selectMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				mem = new Member(

						 rset.getString("USER_ID"), rset.getString("USER_PWD"),
							rset.getString("USER_NAME"), rset.getString("PHONE"), rset.getString("NICKNAME"),
							rset.getDouble("STARPOINT"), rset.getInt("CATEGORY_NO"), rset.getString("ADDRESS"), rset.getString("STATUS")
						
				);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return mem;

	}

	public int updatepwMember(Connection conn, String userId, String pw2) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("updatePwd");
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw2);
			pstmt.setString(2, userId);
			
		
			System.out.println("!@#!@#!@#");
				result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Member> selectMember(Connection conn) {
		ArrayList<Member> list = new ArrayList<>();

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("selectThList");

		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Member m = new Member();
				m.setUserId(rset.getString("USER_ID"));
				list.add(m);
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return list;

	
	}

}
	





