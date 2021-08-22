package com.kh.team3.chat.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.team3.chat.service.ChatService;

/**
 * Servlet implementation class ChatSubmitServlet
 */
@WebServlet("/ChatSubmitServlet")
public class ChatSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String chatName = request.getParameter("chatName");
		String chatContent = request.getParameter("chatContent");
		
		
		
		if(chatName == null || chatContent == null || chatContent.equals("")) {
			response.getWriter().write("오류");

			
		}else {
			response.getWriter().write(new ChatService().submit(chatName,chatContent) + "");
			System.out.println("서블릿 통과!~!~!~!");
		}
		
	}
	
}
