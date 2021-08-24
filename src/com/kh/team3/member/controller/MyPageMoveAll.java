package com.kh.team3.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPageUpdateMove
 */
@WebServlet("/MyPageUpdateMove.me")
public class MyPageMoveAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageMoveAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("one") != null) {
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage_del.jsp");
			view.forward(request, response);
		}else if(request.getParameter("two") !=null) {
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage_up.jsp");
			view.forward(request, response);
		}else if(request.getParameter("three") !=null) {
			RequestDispatcher view = request.getRequestDispatcher("/list.th");
			view.forward(request, response);
		}else if(request.getParameter("four") !=null) {
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage_pw.jsp");
			view.forward(request, response);
		}else if(request.getParameter("five") !=null) {
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage_pic.jsp");
			view.forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
