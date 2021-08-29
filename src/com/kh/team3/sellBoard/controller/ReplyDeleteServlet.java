package com.kh.team3.sellBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.sellBoard.model.service.BoardService;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/rDelete.bo")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReplyDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int rNo = Integer.parseInt(request.getParameter("rNo"));
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		System.out.println(rNo);

		int result = new BoardService().deleteReply(rNo);
		if (result > 0) {
			request.setAttribute(String.valueOf(rNo), "rNo");
			request.setAttribute(String.valueOf(bNo), "bNo");

			request.getRequestDispatcher("sellDetail.bo").forward(request, response);

		} else {
			request.setAttribute("msg", "댓글 삭제에 실패했습니다");
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
