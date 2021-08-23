package com.kh.team3.mystore.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.member.model.vo.Member;
import com.kh.team3.mystore.model.service.ReviewService;
import com.kh.team3.mystore.model.vo.Review;

/**
 * Servlet implementation class MyBoardServlet
 */
@WebServlet("/myboard.ms")
public class MyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginuserId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		

		ArrayList<Review> myboard = new ReviewService().selectMyBoardList(loginuserId);
		request.setAttribute("myboard", myboard);
		
		RequestDispatcher view =request.getRequestDispatcher("views/mystore/MyBoard.jsp");
	    view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
