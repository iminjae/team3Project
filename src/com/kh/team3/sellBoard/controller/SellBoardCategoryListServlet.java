package com.kh.team3.sellBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.Board;

/**
 * Servlet implementation class SellBoardCategoryListServlet
 */
@WebServlet("/sellCategoryList.bo")
public class SellBoardCategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellBoardCategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 조회해올 카테고리번호 넘겨주기
		int category = Integer.parseInt(request.getParameter("category"));
		System.out.println("SellBoardCategoryListServlet :" + category);
		
		ArrayList<Board> list = new BoardService().selectCList(category); //카테고리 번호 같이 넘겨주기
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/sellBoard/sellBoardListView.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
