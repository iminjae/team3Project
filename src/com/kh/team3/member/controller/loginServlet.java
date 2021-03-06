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
import com.kh.team3.member.model.dao.MemberDao;
import com.kh.team3.member.model.service.MemberService;
import com.kh.team3.member.model.vo.Member;

/**
 * Servlet implementation class loginnServlet
 */
@WebServlet("/login.me")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.전달된 값이 한글인 있을 경우에 인코딩 처리를해야함
		request.setCharacterEncoding("UTF-8");
	
		//2. 전달된 값을 꺼내서 변수 도는 객체에 기록하기
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pw");
		System.out.println(userId);
		System.out.println(userPwd);
		
		String originPwd = request.getParameter("pw");
		
		Member loginUser = new MemberService().loginMember(userId, userPwd);
		
		System.out.println("loginUser : " + loginUser);
		if(loginUser !=null) {  //로그인 성공
			HttpSession session = request.getSession();
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%");
			session.setAttribute("userId", userId);
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("originPwd", originPwd);
			Member test = (Member)request.getAttribute("loginUser");
			System.out.println(loginUser);
			System.out.println("session" + session);
			
			ArrayList<Board> list = new EventBoardService().selectThList();
			
			//프로필 사진 가져오기
			String changeName = new EventBoardService().selectpic(userId);
			
			//이벤트 게시물 가져오기
			ArrayList<Board> listtwo = new EventBoardService().selectThListtwo();
			
			String [] countb = new EventBoardService().selectCount();
			String [] countr = new EventBoardService().selectCountr();
			
			
			System.out.println("*************************" + countb[0]);
			request.setAttribute("listtwo", listtwo);
			request.setAttribute("countb", countb);
			request.setAttribute("countr", countr);
			
			request.setAttribute("list", list);
			request.getSession().setAttribute("path", changeName);
				
			RequestDispatcher view = request.getRequestDispatcher("views/common/mainPage.jsp");
			view.forward(request, response);
			//response.sendRedirect("views/common/mainPage.jsp");
			
		}else {
			request.setAttribute("msg", "true");
			
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
