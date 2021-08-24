package com.kh.team3.mystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.member.model.vo.Member;
import com.kh.team3.mystore.model.service.ReviewService;
import com.kh.team3.mystore.model.vo.Jjim;

/**
 * Servlet implementation class JjimInsertServlet
 */
@WebServlet("/jjimInsert.ms")
public class JjimInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JjimInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");

		
		 	String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			int bNo = Integer.parseInt(request.getParameter("jno"));			
			System.out.println("찜 인서트서블릿 게시글번호 : " + bNo);
	      
	      Jjim Jjim = new Jjim(userId, bNo);
	      int result = 0;
	     result = new ReviewService().insertJjim(Jjim);

	      
	      if(result > 0) {
				request.getSession().setAttribute("msg", "찜 등록 성공");
				request.getSession().setAttribute("result", result);
				response.sendRedirect("sellDetail.bo?bNo="+bNo);
			}else {
				request.setAttribute("msg", "찜 등록 실패했습니다");
				
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
