package com.kh.team3.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.member.model.service.MemberService;
import com.kh.team3.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
				
		String userId = request.getParameter("id");
		String userPwd = request.getParameter("pw");
		String userName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		String address = request.getParameter("address");
		int gory = Integer.parseInt(request.getParameter("gory"));

		
		
		Member mem = new Member(userId, userPwd, userName , phone , nickname, gory , address);
		
		int result = new MemberService().insertMember(mem);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "회원가입성공");
			response.sendRedirect("index.jsp");  // 메인 화면 아예 새로 띄우기 맨
		}else {
			request.setAttribute("msg", "회원가입실패");
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
