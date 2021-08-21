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
import com.kh.team3.mystore.model.vo.Review;


/**
 * Servlet implementation class ReviewFormServlet
 */
@WebServlet("/reviewform.rv")
public class ReviewFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
		
		 System.out.println("서블릿은 돌아갑니까?");
		
		  String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		  String content = request.getParameter("content");
	      String[] review = request.getParameterValues("review");
	      System.out.println("리뷰서블릿"+ content);
	      System.out.println("리뷰서블릿"+ review);
	      
	      String reviews = String.join(",", review);
	      
	      System.out.println("리뷰서블릿 :" + userId);
	      System.out.println("리뷰서블릿 :" + content);
	      System.out.println("리뷰서블릿 :" + reviews);
	    
	      
	      Review rv = new Review(userId, content, reviews);
	      
	      int result = new ReviewService().insertReview(userId, rv);
	      
	      if(result > 0) {
				request.getSession().setAttribute("msg", "리뷰 등록 성공");
			}else {
				request.setAttribute("msg", "리뷰 등록 실패했습니다");
				
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
