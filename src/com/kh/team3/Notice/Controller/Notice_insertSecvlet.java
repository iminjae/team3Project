package com.kh.team3.Notice.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.Notice.model.service.NoticeService;
import com.kh.team3.eventBoard.model.vo.Board;
import com.kh.team3.member.model.vo.Member;

/**
 * Servlet implementation class Notice_insertSecvlet
 */
@WebServlet("/insert.io")
public class Notice_insertSecvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice_insertSecvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String attachments = request.getParameter("attachments");
		String writer = String.valueOf(((Member)request.getSession().getAttribute("loginUser")).getUserId());
		
		Board b2 = new Board();

		b2.setBoardTitle(title);
		b2.setBoardContent(content);
		b2.setUserId(writer);
	
		int result = new NoticeService().NoticeBoard(b2);
		if(result > 0) {
			request.getSession().setAttribute("mag", "등록 성공");
			
			request.getRequestDispatcher("Notice_USER.NU").forward(request, response);
		}else {
			request.setAttribute("msg", "공지사항 등록에 실패했습니다.");
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
