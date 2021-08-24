package com.kh.team3.Notice.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.kh.team3.Notice.model.service.NoticeService;
import com.kh.team3.Notice.model.vo.NoticeBoard;

/**
 * Servlet implementation class Notice_BoardDetailServlet
 */
@WebServlet("/Detail.do")
public class Notice_BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Notice_BoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nno = Integer.parseInt(request.getParameter("nno"));
		NoticeBoard no = new NoticeService().selectNotice(nno);
		
		String view = "";
		if(no != null) {
			request.setAttribute("notice", no);
			view = "views/notice/Notice_BoardDetailView.jsp";
		}else {
			request.setAttribute("msg", "공지사항 조회에 실패했습니다");
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
