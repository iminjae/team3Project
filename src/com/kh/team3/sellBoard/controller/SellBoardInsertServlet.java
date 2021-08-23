package com.kh.team3.sellBoard.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.team3.common.MyFileRenamePolicy;
import com.kh.team3.member.model.vo.Member;
import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.Attachment;
import com.kh.team3.sellBoard.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;


/**
 * Servlet implementation class SellBoardInsertServlet
 */
@WebServlet("/sellInsert.bo")
public class SellBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellBoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("서블릿 타는중");
		if(ServletFileUpload.isMultipartContent(request)) { // enctype이 multipart/form-data로 전송된 경우 (true)
			
			int maxSize = 10 * 1024 * 1024; //(10메가바이트)
			// 1_2. 전달된 파일을 저장할 서버의 폴더 경로 알아내기
			String resources = request.getSession().getServletContext().getRealPath("/resources"); // 절대경로
			
			String savePath = resources + "\\board_upfiles\\";
			
			System.out.println("savePath : " + savePath);
			
			// 2. 서버에 업로드할 MultipartRequest 객체 생성하기(즉, 파일서버에 업로드하기)
			MultipartRequest multiRequest = new MultipartRequest(request,savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			Board b = new Board();
			String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId(); //작성자
			//String writer = multiRequest.getParameter("writer");
			String title = multiRequest.getParameter("title"); //제목
			int price = Integer.parseInt(multiRequest.getParameter("price")); //판매가격
			int category = Integer.parseInt(multiRequest.getParameter("category"));//판매 카테고리
			System.out.println("SellBoardInsertServlet: " + category);
			String content = multiRequest.getParameter("content");//판매물품 설명
			
			
			b.setUserId(userId);
			b.setBoardTitle(title);
			b.setPrice(price);
			b.setCategory(category);
			b.setBoardContent(content);
				
			ArrayList<Attachment> fileList = new ArrayList<>();
			
			//파일이 하나가 아니라서 for문
			for(int i = 1; i <=4; i ++) {
				String name = "file" + i; //file 이름이 file1, file2, file3, file4라서
				
				if(multiRequest.getOriginalFileName(name) != null) {
					String originName = multiRequest.getOriginalFileName(name);
					String changeName = multiRequest.getFilesystemName(name);
					
					Attachment at = new Attachment();
					at.setFilePath(savePath);
					at.setOriginName(originName);
					at.setChangeName(changeName);
					//담고 리스트에 추가
					fileList.add(at);
				}
			}
			System.out.println("servlet: " + userId + b+ fileList);
			
			int result = new BoardService().insertThumbnail(userId ,b, fileList);
			
			if(result > 0) {
				response.sendRedirect("sellList.bo");
			}else {
				for(int i = 0; i < fileList.size(); i ++) {
					File failedFile = new File(savePath + fileList.get(i).getChangeName());
					failedFile.delete();
				}
				request.setAttribute("msg", "게시판 등록에 실패했습니다");
				RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
				view.forward(request, response);
			}
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
