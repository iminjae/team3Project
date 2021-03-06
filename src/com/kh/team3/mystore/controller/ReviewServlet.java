package com.kh.team3.mystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/review.rv")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rno = request.getParameter("rno");	
		String userId = request.getParameter("userId");	
		System.out.println("리뷰서블릿 게시판번호" + rno);
		
		request.setAttribute("rno", rno);
		request.setAttribute("userId", userId);
		
		RequestDispatcher view  = request.getRequestDispatcher("views/mystore/ReviewList.jsp");
		view.forward(request, response);
		

		
		System.out.println("리뷰서블릿 화면전환 ----");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
