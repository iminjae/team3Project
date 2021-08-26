package com.kh.team3.sellBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.member.model.vo.Member;

import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.ThumbsUp;

/**
 * Servlet implementation class ThumbsUpInsertServlet
 */
@WebServlet("/thumbsUp.ck")
public class ThumbsUpChecktServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThumbsUpChecktServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();

		System.out.println("ThumbsUpInsertServlet : " + bNo);
		System.out.println("ThumbsUpInsertServlet : " + userId);

		ThumbsUp thumbsUp = new ThumbsUp(bNo, userId);
		int result = 0;
		
		result = new BoardService().insertThumbsUp(thumbsUp);

		if (result > 0) {
			response.sendRedirect("sellDetail.bo?bNo=" + bNo);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
