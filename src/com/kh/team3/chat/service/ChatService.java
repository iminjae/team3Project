package com.kh.team3.chat.service;


import static com.kh.team3.common.JDBCTemplate.commit;
import static com.kh.team3.common.JDBCTemplate.getConnection;
import static com.kh.team3.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.team3.chat.dao.ChatDao;
import com.kh.team3.chat.vo.Chat;



public class ChatService {

	
	public int submit(String chatName, String chatContent) {
		
		Connection conn = getConnection();
		System.out.println("서비스 도착");
		System.out.println(conn);
		
		System.out.println(chatName);
		System.out.println(chatContent);
		
		
		int result = new ChatDao().submit(conn,chatName,chatContent);
		
		System.out.println(conn);
		
		
		
		System.out.println(result);
		
		
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		return result;
		
		
	}
	
	public ArrayList<Chat> ChatList(String nowTime) {
		
		Connection conn = getConnection();
		
		ArrayList<Chat> result = new ChatDao().ChatList(conn,nowTime);
		
		
		return result;
		
		
	}


}
