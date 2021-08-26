package com.kh.team3.shareBoard.controller;

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
import com.kh.team3.shareBoard.model.service.BoardService;
import com.kh.team3.shareBoard.model.vo.Board;
import com.kh.team3.member.model.vo.Member;
import com.kh.team3.shareBoard.model.vo.Attachment;
import com.oreilly.servlet.MultipartRequest;
// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy; // 기본파일 rename해보고
// common에 추상클래스 만들어서 MyFileRenamePolicy 구현해보기

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/write.sbo")
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
			if(ServletFileUpload.isMultipartContent(request)) {
				int maxSize = 10 * 1024 * 1024; 
				
				String resources = request.getSession().getServletContext().getRealPath("/resources"); // 절대경로
				
				String savePath = resources + "\\board_upfiles\\";
				
				
				
				MultipartRequest multiRequest = new MultipartRequest(request,savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
				Board b = new Board();
				
				String title = multiRequest.getParameter("title");
				String content = multiRequest.getParameter("content");
				String categoryNo = multiRequest.getParameter("categoryNo");
				String user = ((Member)request.getSession().getAttribute("loginUser")).getUserId();

				
				b.setUserId(user);
				b.setBoardTitle(title);
				b.setCategoryNo(Integer.parseInt(categoryNo));
				b.setBoardContent(content);
					
				ArrayList<Attachment> fileList = new ArrayList<>();
				
				//파일이 하나가 아니라서 for문
				for(int i = 1; i <=2; i ++) {
					String name = "Sfile" + i;
					
					if(multiRequest.getOriginalFileName(name) != null) {
						String originName = multiRequest.getOriginalFileName(name);
						String changeName = multiRequest.getFilesystemName(name);
						
						Attachment at = new Attachment();
						at.setFilePath(savePath);
						at.setOriginName(originName);
						at.setChangeName(changeName);

						fileList.add(at);
					}
				}
				int result = new BoardService().insertSBoard(user ,b, fileList);
				System.out.println("insert 확인 : "+result);
				if(result > 0) {
					request.getRequestDispatcher("list.sbo").forward(request, response);
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
