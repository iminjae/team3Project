package com.kh.team3.sellBoard.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class SellBoardDetailServlet
 */
@WebServlet("/sellDetail.bo")
public class SellBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellBoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("디테일서블릿도는중");
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		System.out.println("SellBoardDetailServlet :" + bNo);
		
		Board b = new BoardService().selectBoard(bNo);

		System.out.println("SellBoardDetailServlet :" + b);
		
		ArrayList<Attachment> fileList = new BoardService().selectThumbnail(bNo);
		System.out.println("SellBoardDetailServlet :" + fileList);		

	
		if(b != null) {
			request.setAttribute("b", b);
			request.setAttribute("fileList", fileList);
			request.getRequestDispatcher("views/sellBoard/sellBoardDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "게시글 상세보기에 실패했습니다");
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
