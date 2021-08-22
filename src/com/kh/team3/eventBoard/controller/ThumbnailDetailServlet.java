package com.kh.team3.eventBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.eventBoard.model.service.EventBoardService;
import com.kh.team3.eventBoard.model.vo.Attachment;
import com.kh.team3.eventBoard.model.vo.Board;

/**
 * Servlet implementation class ThumbnailDetailServlet
 */
@WebServlet("/detail.th")
public class ThumbnailDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bid = Integer.parseInt(request.getParameter("bId"));
		System.out.println("상세조회 섭블릿 입장 및 board 정보 불러오기");
		Board b = new EventBoardService().selectBoard(bid);
		
		System.out.println("파일 정보 불러오기");
		Attachment fileList = new EventBoardService().selectThumnail(bid);
		System.out.println("전체 조회끝");
		if(b!=null) {
			request.setAttribute("b", b);
			request.setAttribute("fileList", fileList);
			
			request.getRequestDispatcher("views/member/thumbnailDetailView.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "사진게시판 상세보기 실패");
			
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
