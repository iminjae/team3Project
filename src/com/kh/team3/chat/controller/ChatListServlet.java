package com.kh.team3.chat.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.chat.dao.ChatDao;
import com.kh.team3.chat.service.ChatService;
import com.kh.team3.chat.vo.Chat;

/**
 * Servlet implementation class ChatSubmitServlet
 */
@WebServlet("/ChatListServlet")
public class ChatListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		String listType = request.getParameter("listType");
		if(listType == null || listType.equals(""))response.getWriter().write("비어있음");
		else if(listType.equals("today")) response.getWriter().write(getToday());
		else {
			try {
				Integer.parseInt(listType);
				response.getWriter().write(getNo(listType));
			}catch(Exception e) {
				response.getWriter().write("숫자아님");
			}
		}
	}
	
	public String getToday() {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");   
		ChatDao chatDao = new ChatDao();
		ArrayList<Chat>  chatList = ChatService.getChatList();     //new SimpleDateFormat("yyyy-MM-dd").format(new Date())
		for(int i = 0; i < chatList.size(); i++) {
			result.append("[{\"value\":\"" + chatList.get(i).getChatName() + "\"},");
			result.append("{\"value\":\"" + chatList.get(i).getChatContent() + "\"},");
			result.append("{\"value\":\"" + chatList.get(i).getChatTime() + "\"}]");
			if(i != chatList.size() - 1) result.append(",");
			
		}
		
		
		
		result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatNo() + "\"}");
		
		System.out.println(result);
		return result.toString();
		
		
		
	}
	public String getNo(String chatNo) {
		StringBuffer result = new StringBuffer("");
		result.append("{\"result\":[");   
		ChatDao chatDao = new ChatDao();
		ArrayList<Chat>  chatList = ChatService.getChatListByRecent(chatNo);     //new SimpleDateFormat("yyyy-MM-dd").format(new Date())
		for(int i = 0; i < chatList.size(); i++) {
			result.append("[{\"value\":\"" + chatList.get(i).getChatName() + "\"},");
			result.append("{\"value\":\"" + chatList.get(i).getChatContent() + "\"},");
			result.append("{\"value\":\"" + chatList.get(i).getChatTime() + "\"}]");
			if(i != chatList.size() - 1) result.append(",");
			
		}
		
		
			
		result.append("], \"last\":\"" + chatList.get(chatList.size() - 1).getChatNo() + "\"}");
		
		System.out.println(result);
		return result.toString();
		
		
		
	}
	
}
