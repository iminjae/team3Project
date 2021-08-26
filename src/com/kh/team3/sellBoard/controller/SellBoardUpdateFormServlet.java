package com.kh.team3.sellBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;



/**
 * Servlet implementation class SellBoardUpdateFormServlet
 */
@WebServlet("/sellUpdateForm.bo")
public class SellBoardUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellBoardUpdateFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		
		System.out.println("SellBoardUpdateFormServlet : " + bNo);
		
		Board b = new BoardService().selectUpdateBoard(bNo);
		Attachment at = new BoardService().selectAttachment(bNo);
		
		if(b != null) {
			request.setAttribute("board", b);
			request.setAttribute("at", at);
			request.getRequestDispatcher("views/sellBoard/sellBoardUpdateForm.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "수정할 게시글을 불러오는 데 실패했습니다");
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
