package com.kh.team3.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.member.model.vo.Member;
import com.kh.team3.report.model.vo.Report;
import com.kh.team3.report.service.ReportService;


/**
 * Servlet implementation class ReportInsertServlet
 */
@WebServlet("/ReportInsertServlet")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String reportUserId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		String reportNickName = request.getParameter("reportNickName");
		String reportCategory= request.getParameter("reportCategory");
		String reportContent = request.getParameter("reportContent");
		
		
		Report r = new Report();
		
		r.setReportWriter(reportUserId);
		r.setReportNick(reportNickName);
		r.setReportCategory(reportCategory);
		r.setReportContent(reportContent);
		
		
		int result = new ReportService().insert(r);
		
		if(result > 0) {
			request.getSession().setAttribute("msg", "제출 성공");
			response.sendRedirect("views/common/mainPage.jsp");  
		}else {
			request.setAttribute("msg", "제출실패");
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
