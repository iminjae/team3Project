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
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/update.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");
		String phone = request.getParameter("phone");
		String nickName = request.getParameter("nick");
		String address = request.getParameter("addr");
	
		
		
		Member member =  new Member(userId, userName,phone,nickName,address);
		
		Member updatemem = new MemberService().updateMember(member);
		
		if(updatemem !=null) {
			request.getSession().setAttribute("msg", "회원정보를 수정하였습니다");
			request.getSession().setAttribute("loginUser", updatemem);
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage_up.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("msg", "회원정보수정에 실패하였습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
			view.forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
