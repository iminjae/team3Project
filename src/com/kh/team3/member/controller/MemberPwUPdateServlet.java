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
 * Servlet implementation class MemberPwUPdateServlet
 */
@WebServlet("/pwupdate.me")
public class MemberPwUPdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPwUPdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
		
	
		String userId = request.getParameter("id");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		String pw3 = request.getParameter("pw3");
		Member updatemem = null;
		if(pw2.equals(pw3)) {
			
		
		
		
		updatemem = new MemberService().updatepwMember(userId , pw2);
		}
		
		if(updatemem !=null) {
			request.getSession().setAttribute("msg", "회원정보를 수정하였습니다");
			request.getSession().setAttribute("loginUser", updatemem);
			RequestDispatcher view = request.getRequestDispatcher("views/member/myPage_pw.jsp");
			view.forward(request, response);
		}else {
			request.setAttribute("msg", "회원정보수정에 실패하였습니다.");
			
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
