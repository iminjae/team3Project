package com.kh.team3.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.Notice.model.service.NoticeService;
import com.kh.team3.Notice.model.vo.NoticeBoard;
import com.kh.team3.eventBoard.model.service.EventBoardService;
import com.kh.team3.mystore.model.service.ReviewService;
import com.kh.team3.mystore.model.vo.Review;
import com.kh.team3.report.model.vo.Report;
import com.kh.team3.report.service.ReportService;
import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;

/**
 * Servlet implementation class ReportViewDetailServlet
 */
@WebServlet("/ReportViewDetailServlet")
public class ReportViewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportViewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int re = Integer.parseInt(request.getParameter("re"));
		
		System.out.println("1111111111111");
		
		Report reportView = new ReportService().selectReport(re);
		System.out.println("reportView" + reportView);
		
		System.out.println("5555555555555555");
		String view ="";
		
		if(reportView != null) {
			request.setAttribute("reportView", reportView);
			
			view = "views/Report/ReportDetailView.jsp";
			
		}else {
			request.setAttribute("msg", "신고 조회에 실패하였습니다");
			view = "views/common/errorPage.jsp";
		}
		
		request.getRequestDispatcher(view).forward(request, response);
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
