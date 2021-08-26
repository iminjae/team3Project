package com.kh.team3.chat.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.team3.chat.vo.Chat;

public class ChatDao {
	
	
	private Properties prop = new Properties();
	
	public ChatDao() {
		
		String fileName =ChatDao.class.getResource("/sql/chat/chat-query.properties").getPath();
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
	
	public ArrayList<Chat> getChatList(Connection conn){
		
		
		ArrayList<Chat> chatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("getChatList");
		
		
		
		try {
		pstmt = conn.prepareStatement(sql);
		//pstmt.setString(1, nowTime);
		rs = pstmt.executeQuery();
		chatList = new ArrayList<Chat>();
		
		
		
		while(rs.next()) {
			Chat chat = new Chat();
			
			chat.setChatNo(rs.getInt("CHAT_NO"));
			chat.setChatName(rs.getString("NICKNAME"));
			chat.setChatContent(rs.getString("MESSAGE").replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
			chat.setChatTime(rs.getString("CHAT_DATE"));
			chatList.add(chat);
			
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(chatList);
		
		return chatList;
		
	}
	
	
	
public ArrayList<Chat> getChatListByRecent(Connection conn, String chatNo){
		
		
		ArrayList<Chat> chatList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("getChatListByRecent");
		
		
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(chatNo));
		rs = pstmt.executeQuery();
		chatList = new ArrayList<Chat>();
		
		
		
		while(rs.next()) {
			Chat chat = new Chat();
			
			chat.setChatNo(rs.getInt("CHAT_NO"));
			chat.setChatName(rs.getString("NICKNAME"));
			chat.setChatContent(rs.getString("MESSAGE").replaceAll(" ","&nbsp;").replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br>"));
			chat.setChatTime(rs.getString("CHAT_DATE"));
			chatList.add(chat);
			
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(chatList);
		
		return chatList;
		
	}
	


	
		

	public int submit(Connection conn, String chatName, String chatContent, int cha) {
		
		int result =0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("submit");
		System.out.println(chatName);
		System.out.println(chatContent);
		
		
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, chatName);
		pstmt.setString(2, chatContent);
		pstmt.setInt(3, cha);
		result = pstmt.executeUpdate();
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
}
