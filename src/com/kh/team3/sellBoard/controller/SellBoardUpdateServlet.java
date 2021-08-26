package com.kh.team3.sellBoard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.common.MyFileRenamePolicy;
import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class SellBoardUpdateServlet
 */
@WebServlet("/sellUpdate.bo")
public class SellBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellBoardUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 10 * 1024 * 1024;
		String resources = request.getSession().getServletContext().getRealPath("/resources");
		String savePath = resources + "\\board_upfiles\\";

		
		// MultipartRequest 객체 생성 하기 ( 즉 파일 서버에 업로드하기)
		// MultipartRequest multiRequest = new MultipartRequest(request, savePath,
		// maxSize, "UTF-8" , new DefaultFileRenamePolicy());
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		Board b = new Board();
		int bNo = Integer.parseInt(multiRequest.getParameter("bNo"));
		String title = multiRequest.getParameter("title"); //제목
		int price = Integer.parseInt(multiRequest.getParameter("price")); //판매가격
		int category = Integer.parseInt(multiRequest.getParameter("category"));//판매 카테고리
		String boardStatus = multiRequest.getParameter("boardStatus"); //게시글 상태(판매중, 예약중, 판매완료)
		String content = multiRequest.getParameter("content");//판매물품 설명

		System.out.println("판매게시판 bNo" + bNo);
		System.out.println("SellBoardUpdateServlet: title" + title);
		System.out.println("SellBoardUpdateServlet: price" +price);
		System.out.println("SellBoardUpdateServlet: category" + category);
		System.out.println("SellBoardUpdateServlet: boardStatus" +boardStatus );
		System.out.println("SellBoardUpdateServlet: content" +content );
		
		b.setBoardNo(bNo);
		b.setBoardTitle(title);
		b.setPrice(price);
		b.setCategory(category);
		b.setBoardStatus(boardStatus);
		b.setBoardContent(content);
		
		Attachment at = new Attachment();

		String name = "file" + 1;

		if (multiRequest.getOriginalFileName(name) != null) {
			String originName = multiRequest.getOriginalFileName(name);
			String changeName = multiRequest.getFilesystemName(name);

			at.setFilePath(savePath);
			at.setOriginName(originName);
			at.setChangeName(changeName);
			at.setRefBoardNo(bNo);
	
		}


		int result = new BoardService().updateBoard(b, at);
		
		
		if (result > 0) {
			response.sendRedirect("sellDetail.bo?bNo=" +bNo);
		} else {

			File failedFile = new File(savePath + at.getChangeName());
			failedFile.delete();

			request.setAttribute("msg", "등록 실패");
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
