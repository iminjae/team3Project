package com.kh.team3.shareBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.freeBoard.model.service.BoardService;
import com.kh.team3.freeBoard.model.vo.Board;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/update.sbo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
			int bno = Integer.parseInt(request.getParameter("bno"));
			
			int category = Integer.parseInt(request.getParameter("categoryNo"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			
			
			Board b = new Board();
			b.setCategoryNo(category);
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setBoardNo(bno);

			
			
			
			int result = new BoardService().updateBoard(b);
			if(result > 0) { //성공하면 바로 상세페이지로 보내고
				request.setAttribute(String.valueOf(bno), "bno");
				request.getRequestDispatcher("detail.bo").forward(request, response);	
			}else {
				request.setAttribute("msg", "게시판 수정에 실패했습니다");
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
