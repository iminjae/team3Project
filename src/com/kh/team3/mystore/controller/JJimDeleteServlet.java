package com.kh.team3.mystore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.mystore.model.service.ReviewService;

/**
 * Servlet implementation class JJimDeleteServlet
 */
@WebServlet("/deleteJjim.ms")
public class JJimDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JJimDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jno = Integer.parseInt(request.getParameter("jno"));
		
		System.out.println("찜삭제 게시글번호 : " + jno);
		int result = new ReviewService().deleteJjim(jno);
		
		
		if(result > 0) {
			response.sendRedirect("like.ms");
		}else {
			request.setAttribute("msg", "찜 삭제에 실패했습니다");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
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
