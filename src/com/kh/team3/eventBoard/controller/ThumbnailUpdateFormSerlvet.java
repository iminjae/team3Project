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
 * Servlet implementation class BoardUpdateFormSerlvet
 */
@WebServlet("/updateForm.bo")
public class ThumbnailUpdateFormSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailUpdateFormSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Board board = new EventBoardService().selectUpdateBoard(bno);
		Attachment at  = new EventBoardService().selectAttachment(bno);
		
		if(board !=null) {
			request.setAttribute("board", board);
			request.setAttribute("at", at);
			request.getRequestDispatcher("views/member/boardUpdateForm.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "수정할 게시글을불러오는데 실패");
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
