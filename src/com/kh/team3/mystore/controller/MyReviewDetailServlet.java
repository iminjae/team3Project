package com.kh.team3.mystore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.mystore.model.service.ReviewService;
import com.kh.team3.mystore.model.vo.Review;

/**
 * Servlet implementation class MyReviewDetailServlet
 */
@WebServlet("/myreviewdetail.ms")
public class MyReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				int nno = Integer.parseInt(request.getParameter("nno"));
				
				System.out.println("nno" + nno);
				
				Review reviewdetail = new ReviewService().selectReview(nno);
				
				String view ="";
				
				if(reviewdetail != null) {
					request.setAttribute("reviewdetail", reviewdetail);
					view = "views/mystore/ReviewDetailView.jsp";
					
				}else {
					request.setAttribute("msg", "리뷰 조회에 실패하였습니다");
					view = "views/common/errorPage.jsp";
				}
				
				request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
