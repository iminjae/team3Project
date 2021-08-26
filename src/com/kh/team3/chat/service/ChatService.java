package com.kh.team3.chat.service;


import static com.kh.team3.common.JDBCTemplate.close;
import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.chat.dao.ChatDao;
import com.kh.team3.chat.vo.Chat;



public class ChatService {

	
	public int submit(String chatName, String chatContent, int cha) {
		
		Connection conn = getConnection();
		System.out.println("서비스 도착");
		System.out.println(conn);
		
		System.out.println(chatName);
		System.out.println(chatContent);
		
		
		int result = new ChatDao().submit(conn,chatName,chatContent, cha);
		
		System.out.println(conn);
		
		
		
		System.out.println(result);
		
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}

	public static  ArrayList<Chat> getChatList() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Chat> list = new ChatDao().getChatList(conn);
		close(conn);
		
		return list;
	}

	public static ArrayList<Chat> getChatListByRecent(String chatNo) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ArrayList<Chat> list = new ChatDao().getChatListByRecent(conn, chatNo);
		close(conn);
		
		return list;
	}
	
	
	
	
	


}
