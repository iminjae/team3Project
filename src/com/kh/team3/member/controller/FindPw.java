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
 * Servlet implementation class FindId
 */
@WebServlet("/findpw.me")
public class FindPw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		
		Member list = new MemberService().findallmempw(id, phone);
			if(list.getUserId() !=null) {
				System.out.println("asdasfsejgwlgjaldf" + list.getUserId());
				String idd = list.getUserId();
				request.setAttribute("idd", idd);
				RequestDispatcher view = request.getRequestDispatcher("views/member/findid4.jsp");
				view.forward(request, response);
			
			}else {
				
				list.setUserId("회원정보가 존재하지 않습니다(pw).");
				request.setAttribute("list", list);
				RequestDispatcher view = request.getRequestDispatcher("views/member/findid2.jsp");
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
