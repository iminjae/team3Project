package com.kh.team3.eventBoard.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.common.MyFileRenamePolicy;
import com.kh.team3.eventBoard.model.service.EventBoardService;
import com.kh.team3.eventBoard.model.vo.Attachment;
import com.kh.team3.eventBoard.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ThumbnailUpdate
 */
@WebServlet("/update.bo")
public class ThumbnailUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int maxSize = 10 * 1024 * 1024;
		
		//1-2 전달된 파일을 저장할 서버의 폴더 경로 알아내기
		String resources = request.getSession().getServletContext().getRealPath("/resources");
		
		String savePath = resources + "\\board_upfiles\\";
		
		System.out.println("savePath" + savePath);
		System.out.println("resources " +resources );
		System.out.println("업데이트 서블맀!!");
		//MultipartRequest 객체 생성 하기 ( 즉  파일 서버에 업로드하기)
		//MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8" , new DefaultFileRenamePolicy());
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8" , new MyFileRenamePolicy());
		System.out.println("업데이트 서블릿 이름 변경!");
		Board b = new Board();
		int bno = Integer.parseInt(multiRequest.getParameter("bno"));
		String title = multiRequest.getParameter("title");
		String content = multiRequest.getParameter("content");
		String evt =  multiRequest.getParameter("evt");
		
		b.setBoardNo(bno);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setBoardStatus(evt);
		
		
		Attachment at = new Attachment();
			
			String name = "file"+1;
			
			
			if(multiRequest.getOriginalFileName(name) !=null) {
				String originName = multiRequest.getOriginalFileName(name);
				String changeName = multiRequest.getFilesystemName(name);
				System.out.println("###!"+originName);
				System.out.println(changeName);
				System.out.println(savePath);
				
				at.setFilePath(savePath);
				at.setOriginName(originName);
				at.setChangeName(changeName);
				at.setRefBoardNo(bno);
				
			
			
		}
			
		System.out.println("서비스 진입 직전 at :" +at);
		int result = new EventBoardService().updateBoard(b, at);
		System.out.println("서블릿 완료");
		if(result > 0) {
			response.sendRedirect("list.th");
		
		}else {
			
				File failedFile = new File(savePath +at.getChangeName());
				failedFile.delete();
			
			request.setAttribute("msg", "사진 게시글 등록 실패");
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
