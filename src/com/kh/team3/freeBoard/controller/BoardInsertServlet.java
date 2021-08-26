package com.kh.team3.freeBoard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.team3.common.MyFileRenamePolicy;
import com.kh.team3.freeBoard.model.service.BoardService;
import com.kh.team3.freeBoard.model.vo.Board;
import com.kh.team3.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;
// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy; // 기본파일 rename해보고
// common에 추상클래스 만들어서 MyFileRenamePolicy 구현해보기

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/write.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");
		
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String categoryNo = request.getParameter("categoryNo");
			String user = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
	
			Board b = new Board();
			
		
			b.setBoardTitle(title);
			b.setBoardContent(content);
			b.setCategoryNo(Integer.parseInt(categoryNo));
			b.setUserId(user);
			
			
			
			
			int result = new BoardService().insertBoard(b);
			if(result > 0) {
				request.getSession().setAttribute("msg", "게시물 등록 성공");
				
				
				request.getRequestDispatcher("list.bo").forward(request, response);
			}else {
				request.setAttribute("msg", "게시판 등록에 실패했습니다");
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
