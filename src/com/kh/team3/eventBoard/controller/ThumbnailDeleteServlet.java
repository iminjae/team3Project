package com.kh.team3.eventBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.eventBoard.model.service.EventBoardService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/deleteB.bo")
public class ThumbnailDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("삭제 진입@@@@@@@@@@@@@@@");
		
		int bid = Integer.parseInt(request.getParameter("bno"));
		System.out.println(bid);
		int result = new EventBoardService().deleteBoard(bid);
		System.out.println("삭제 완료 !@@@@@@@@@@@@@@@@@@");
		if(result >  0 ) {
			response.sendRedirect("list.th");
			
		}else {
			request.setAttribute("msg", "게시글 삭제 실패 ");
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
