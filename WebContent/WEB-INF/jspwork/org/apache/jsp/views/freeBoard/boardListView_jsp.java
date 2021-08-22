/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-08-22 09:11:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.freeBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import com.kh.team3.freeBoard.model.vo.*;
import com.kh.team3.freeBoard.model.dao.*;
import com.kh.team3.freeBoard.model.service.*;

public final class boardListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("com.kh.team3.freeBoard.model.vo");
    _jspx_imports_packages.add("com.kh.team3.freeBoard.model.service");
    _jspx_imports_packages.add("com.kh.team3.freeBoard.model.dao");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");

	
	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	

	int listCount = pi.getListCount();
	int currentPage = pi.getCurrentPage();
	int maxPage = pi.getMaxPage();
	int startPage = pi.getStartPage();
	int endPage = pi.getEndPage();


      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("	.box{\r\n");
      out.write("		width:800px;\r\n");
      out.write("		height:500px;\r\n");
      out.write("		margin:auto;\r\n");
      out.write("		margin-top:50px;\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	.board{\r\n");
      out.write("		border:1px solid white;\r\n");
      out.write("		text-align:center;\r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.board>tbody>tr:hover{\r\n");
      out.write("		cursor:pointer\r\n");
      out.write("	}\r\n");
      out.write("	table {\r\n");
      out.write("    	width: 100%;\r\n");
      out.write("    	border-top: 1px solid #444444;\r\n");
      out.write("    	border-collapse: collapse;\r\n");
      out.write("  	}\r\n");
      out.write("  	th, td {\r\n");
      out.write("    	border-bottom: 1px solid #444444;\r\n");
      out.write("    	padding: 10px;\r\n");
      out.write("    	font-size:11px;\r\n");
      out.write("  	}\r\n");
      out.write("  	</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<div class=\"box\">\r\n");
      out.write("		<br>\r\n");
      out.write("		\r\n");
      out.write("		<h3>자유 게시판</h3>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<table class=\"board\"  align=\"center\">\r\n");
      out.write("			<thead>\r\n");
      out.write("				<tr>\r\n");
      out.write("					<th  width=\"7%\">글번호</th>\r\n");
      out.write("					<th width=\"6%\">분류</th>\r\n");
      out.write("					<th width=\"55%\">글제목</th>\r\n");
      out.write("					<th width=\"10%\">작성자</th>\r\n");
      out.write("					<th width=\"7%\">조회수</th>\r\n");
      out.write("					<th width=\"15%\">작성일</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			<thead>\r\n");
      out.write("	\r\n");
      out.write("			<tbody>\r\n");
      out.write("				");
if(list.isEmpty()){ 
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td colspan=\"6\">조회된 리스트가 없습니다.</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");
}else{ 
      out.write("\r\n");
      out.write("				");
 for(Board b : list){ 
      out.write("\r\n");
      out.write("				<tr>\r\n");
      out.write("					<td>");
      out.print( b.getBoardNo() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( b.getCategoryNo() );
      out.write("</td>\r\n");
      out.write("					<td class=\"link\">");
      out.print( b.getBoardTitle() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( b.getUserId() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( b.getBoardCount() );
      out.write("</td>\r\n");
      out.write("					<td>");
      out.print( b.getCreateDate() );
      out.write("</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("			</tbody>\r\n");
      out.write("		</table>\r\n");
      out.write("		\r\n");
      out.write("		<br>\r\n");
      out.write("		<div align=\"right\">\r\n");
      out.write("	\r\n");
      out.write("		<button onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/insertForm.bo'\">작성하기</button>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<!-- 페이징바 만들기 -->\r\n");
      out.write("		<div class=\"pagingArea\" align=\"center\">\r\n");
      out.write("			<!-- 맨 처음으로 (<<) -->\r\n");
      out.write("			<button onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/list.bo?currentPage=1'\"> &lt;&lt; </button>\r\n");
      out.write("		\r\n");
      out.write("			<!-- 이전페이지로(<) -->\r\n");
      out.write("			");
if(currentPage == 1){ 
      out.write("\r\n");
      out.write("			<button disabled> &lt; </button>\r\n");
      out.write("			");
}else{ 
      out.write("\r\n");
      out.write("			<button onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.bo?currentPage=");
      out.print( currentPage-1 );
      out.write("'\"> &lt; </button>\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("			\r\n");
      out.write("			<!-- 페이지 목록 -->\r\n");
      out.write("			");
for(int p=startPage; p<=endPage; p++){ 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("				");
if(p == currentPage){ 
      out.write("\r\n");
      out.write("				<button disabled> ");
      out.print( p );
      out.write(" </button>\r\n");
      out.write("				");
}else{ 
      out.write("\r\n");
      out.write("				<button onclick=\"location.href='");
      out.print(request.getContextPath() );
      out.write("/list.bo?currentPage=");
      out.print( p );
      out.write("'\"> ");
      out.print( p );
      out.write(" </button>\r\n");
      out.write("				");
} 
      out.write("\r\n");
      out.write("				\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("			\r\n");
      out.write("			<!-- 다음페이지로(>) -->\r\n");
      out.write("			");
if(currentPage == maxPage){ 
      out.write("\r\n");
      out.write("			<button disabled> &gt; </button>\r\n");
      out.write("			");
}else { 
      out.write("\r\n");
      out.write("			<button onclick=\"location.href='");
      out.print( request.getContextPath() );
      out.write("/list.bo?currentPage=");
      out.print( currentPage+1 );
      out.write("'\"> &gt; </button>\r\n");
      out.write("			");
} 
      out.write("\r\n");
      out.write("		\r\n");
      out.write("			<!-- 맨 끝으로 (>>) -->\r\n");
      out.write("			<button onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/list.bo?currentPage=");
      out.print(maxPage);
      out.write("'\"> &gt;&gt; </button>\r\n");
      out.write("		</div> \r\n");
      out.write("\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<DIV class='aside_menu'>\r\n");
      out.write("  <FORM name='frm' method='GET' action='./list.jsp'>\r\n");
      out.write("    <ASIDE align = 'center'>\r\n");
      out.write("      <SELECT name='col'> \r\n");
      out.write("        <OPTION value='userId'>이름</OPTION>\r\n");
      out.write("        <OPTION value='BoardTitle'>제목</OPTION>\r\n");
      out.write("      </SELECT>\r\n");
      out.write("      <input type='text' name='word'>\r\n");
      out.write("      <button type='submit'>검색</button>    \r\n");
      out.write("\r\n");
      out.write("    </ASIDE> \r\n");
      out.write("  </FORM>\r\n");
      out.write("  <DIV class='menu_line' style='clear: both;'></DIV>\r\n");
      out.write("</DIV>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("		\r\n");
      out.write("			$(function(){\r\n");
      out.write("				console.log('외않되');\r\n");
      out.write("				$(\".board>tbody>tr\").click(function(){\r\n");
      out.write("					\r\n");
      out.write("					var bno = $(this).children().eq(0).text();\r\n");
      out.write("					location.href = \"");
      out.print(request.getContextPath());
      out.write("/detail.bo?bno=\"+bno;\r\n");
      out.write("				})\r\n");
      out.write("			})\r\n");
      out.write("		\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}