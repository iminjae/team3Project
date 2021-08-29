package com.kh.team3.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.team3.eventBoard.model.service.EventBoardService;
import com.kh.team3.eventBoard.model.vo.Board;
import com.kh.team3.member.model.vo.Member;

/**
 * Servlet implementation class MyPageMove
 */
@WebServlet("/main.me")
public class MainMove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainMove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member loginUser = (Member)request.getAttribute("loginUser");
		
		System.out.println("===========세션유지확인===============");
		System.out.println(loginUser);
		
		System.out.println("session = " + session);
		
		ArrayList<Board> listtwo = new EventBoardService().selectThListtwo();
		String [] countb = new EventBoardService().selectCount();
		String [] countr = new EventBoardService().selectCountr();
		
		
		System.out.println("*************************" + countb[0]);
		request.setAttribute("listtwo", listtwo);
		request.setAttribute("countb", countb);
		request.setAttribute("countr", countr);
		
		request.setAttribute("listtwo", listtwo);
		
	
		RequestDispatcher view = request.getRequestDispatcher("views/common/mainPage.jsp");
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
