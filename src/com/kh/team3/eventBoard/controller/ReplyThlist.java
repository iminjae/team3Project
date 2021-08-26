package com.kh.team3.eventBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.eventBoard.model.service.EventBoardService;
import com.kh.team3.eventBoard.model.vo.Attachment;
import com.kh.team3.eventBoard.model.vo.Board;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/detailtwo.bo")
public class ReplyThlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyThlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int bno = Integer.parseInt(request.getParameter("bno"));

		
		Board b = new EventBoardService().selectBoard(bno);

		
		if(b != null) {
			Attachment fileList = new EventBoardService().selectThumnail(bno);
			
			request.setAttribute("b", b);
			request.setAttribute("fileList",fileList);
	
			request.getRequestDispatcher("views/member/thumbnailDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "게시판 상세조회에 실패했습니다");
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
