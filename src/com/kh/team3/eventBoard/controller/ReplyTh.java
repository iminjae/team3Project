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
 * Servlet implementation class ReplyTh
 */
@WebServlet("/ReplyDel.bo")
public class ReplyTh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyTh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	      int rno = Integer.parseInt(request.getParameter("rno"));
	      int bno = Integer.parseInt(request.getParameter("bno"));
	      
	      System.out.println(rno);
	      System.out.println(bno);
	      
	      int result = new EventBoardService().replyDelete(rno);
	      if(result > 0) {
	    		request.setAttribute(String.valueOf(rno), "rno");  
				request.setAttribute(String.valueOf(bno), "bno");
			
	         request.getRequestDispatcher("ddetail.bo").forward(request, response);
	         
	      }else {
	         request.setAttribute("msg", "댓글 삭제에 실패했습니다");
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
