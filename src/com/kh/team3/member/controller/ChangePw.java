package com.kh.team3.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.member.model.service.MemberService;

/**
 * Servlet implementation class ChangePw
 */
@WebServlet("/changepw.me")
public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String pw = request.getParameter("pww");
		String id = request.getParameter("idd");
		System.out.println("서블릿 아이디디디@@@@@@@@" + id);
		
		int result = new MemberService().updateMemberpw(id ,pw);
		System.out.println("서블릿 re"  +result);
		if(result > 0) {
			String hi = "패스워드 변경 완료";
			request.setAttribute("hi", hi);
		
			RequestDispatcher view = request.getRequestDispatcher("views/member/findid5.jsp");
			view.forward(request, response);
		
		}else {
			String hi = "패스워드 변경 실패";
			request.setAttribute("hi", hi);
			RequestDispatcher view = request.getRequestDispatcher("views/member/findid5.jsp");
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
