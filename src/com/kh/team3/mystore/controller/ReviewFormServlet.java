package com.kh.team3.mystore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.freeBoard.model.service.BoardService;
import com.kh.team3.member.model.vo.Member;
import com.kh.team3.mystore.model.service.ReviewService;
import com.kh.team3.mystore.model.vo.Review;
import com.kh.team3.sellBoard.model.vo.Board;


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
	      
	      
	      
		int rno = Integer.parseInt(request.getParameter("rno"));			
		System.out.println("리뷰폼 서블릿 게시글번호 : " + rno);
	      
	      request.setAttribute("reviewjoin", review);
	      System.out.println("리뷰서블릿"+ content);
	      System.out.println("리뷰서블릿"+ review);
	      
	      String reviews = String.join(",", review);
	      
	      System.out.println("리뷰서블릿 :" + userId);
	      System.out.println("리뷰서블릿 :" + content);
	      System.out.println("리뷰서블릿 :" + reviews);
	      
	    
		    //명선님 파트
		  	String rate=request.getParameter("rate");
			String userIdstar=request.getParameter("userId");
			Member m = new Member();
			m.setUserId(userIdstar);
			
			int result = new BoardService().updateStar(m,rate);
		

	      
	    
	      
	      Review rv = new Review(userId, rno, content, reviews);
	      
	      int resultreview= new ReviewService().insertReview(userId, rv);
	      
	      if(resultreview * result  > 0) {
	    	  	request.getSession().setAttribute("msg", "게시물 등록 성공");
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
