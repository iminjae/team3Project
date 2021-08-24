package com.kh.team3.mystore.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ThumbsUpNoServlet
 */
@WebServlet("/like.ms")
public class JjimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JjimServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String loginuserId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
			ArrayList<Jjim> jjimList = new ReviewService().selectJjimList(loginuserId);
			request.setAttribute("jjimList", jjimList);
		
		RequestDispatcher view =request.getRequestDispatcher("views/mystore/Jjim.jsp");
	    view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
