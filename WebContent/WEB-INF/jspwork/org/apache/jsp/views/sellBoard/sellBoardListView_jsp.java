/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-08-25 14:12:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.sellBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.team3.sellBoard.model.vo.Board;
import java.util.ArrayList;
import com.kh.team3.member.model.vo.Member;

public final class sellBoardListView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/sellBoard/../common/menubar.jsp", Long.valueOf(1629818111407L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.team3.member.model.vo.Member");
    _jspx_imports_classes.add("com.kh.team3.sellBoard.model.vo.Board");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("\r\n");

ArrayList<Board> list = (ArrayList<Board>) request.getAttribute("list");
String userId = ((Member) request.getSession().getAttribute("loginUser")).getUserId();
String one = "1";
String two = "2";
String three = "3";
String four = "4";
String five = "5";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\" />\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\"\r\n");
      out.write("	integrity=\"sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1\"\r\n");
      out.write("	crossorigin=\"anonymous\" />\r\n");
      out.write("<style>\r\n");
      out.write(".card {\r\n");
      out.write("	margin-bottom: 10px;\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".listArea {\r\n");
      out.write("	width: 760px;\r\n");
      out.write("	height: 550px;\r\n");
      out.write("	margin: auto;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbnail {\r\n");
      out.write("	display: inline-block;\r\n");
      out.write("	width: 220px;\r\n");
      out.write("	border: 1px solid blue;\r\n");
      out.write("	margin: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbnail:hover {\r\n");
      out.write("	opacity: 0.7;\r\n");
      out.write("	cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<title>Product_list</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	<!-- ????????? -->\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("  ");
  
    String path = (String)request.getSession().getAttribute("path");

      out.write("\r\n");
      out.write("  ");
   
  	
   String contextPath = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<link href=\"resources\\css\\common.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<link href=\"resources\\css\\main.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources\\css\\common.css\">\r\n");
      out.write("<script src=\"resources\\js\\jquery.js\"></script>\r\n");
      out.write("<script src=\"resources\\js\\common.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"header-wrap\">\r\n");
      out.write("\r\n");
      out.write("      <header class=\"header-inner\">\r\n");
      out.write("         <h1>\r\n");
      out.write("            <a href=\"#\">\r\n");
      out.write("            <picture>\r\n");
      out.write("                        <source media=\"(max-width:800px)\" srcset=\"resources\\images\\common\\logo-white.png\">\r\n");
      out.write("                        <img src=\"resources\\images\\common\\logo.jpg\" alt=\"????????????\">\r\n");
      out.write("            </picture>\r\n");
      out.write("            </a>\r\n");
      out.write("         </h1>\r\n");
      out.write("         <p class=\"mobile-menu-open\">\r\n");
      out.write("            <button>\r\n");
      out.write("                        <span class=\"blind\">?????? ??????</span>\r\n");
      out.write("                        <span></span>\r\n");
      out.write("                        <span></span>\r\n");
      out.write("                        <span></span>\r\n");
      out.write("            </button>\r\n");
      out.write("         </p>\r\n");
      out.write("         <div class=\"mobile-menu-wrap\">\r\n");
      out.write("            <div class=\"mobile-menu-scroll\">\r\n");
      out.write("               <ul class=\"site-choice\">\r\n");
      out.write("            \r\n");
      out.write("               </ul>\r\n");
      out.write("               <ul class=\"util-menu\">\r\n");
      out.write("                  <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/main.me\">Home</a></li>\r\n");
      out.write("                  <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/MyPageMove.me\">?????? ?????????</a></li>\r\n");
      out.write("                  <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mystore.ms\">??? ??????</a></li>\r\n");
      out.write("                  <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.me\">????????????</a></li>\r\n");
      out.write("              	    <li>  <img src=\"");
      out.print(contextPath);
      out.write("/resources/board_upfiles/");
      out.print( path );
      out.write("\" width=\"30px\" height=\"30px\"> </li>\r\n");
      out.write("               </ul>\r\n");
      out.write("               <nav id=\"gnb\">\r\n");
      out.write("                  <h2 class=\"blind\">????????????</h2>\r\n");
      out.write("                  <ul>\r\n");
      out.write("                     <li class=\"m1\">\r\n");
      out.write("                     	<a href=\"");
      out.print(request.getContextPath());
      out.write("/Notice_Manager.NM\">????????????</a>\r\n");
      out.write("                     </li>\r\n");
      out.write("                     <li class=\"m2\">\r\n");
      out.write("                        <a href=\"#\">????????????</a>\r\n");
      out.write("                        <ul >\r\n");
      out.write("                           <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/exchangeServlet.es\">???????????? ?????????</a></li>\r\n");
      out.write("                           <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/sellList.bo\">?????? ?????????</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                     </li>\r\n");
      out.write("                     <li class=\"m3\">\r\n");
      out.write("                        <a href=\"#\">????????????</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                           <li><a href=\"#\">????????????</a></li>\r\n");
      out.write("                           <li><a href=\"list.bo\">?????? ?????????</a></li>\r\n");
      out.write("                        \r\n");
      out.write("                        </ul>\r\n");
      out.write("                     </li>\r\n");
      out.write("                     <li class=\"m4 no-sub\">\r\n");
      out.write("                                 <a href=\"#\">??????</a>\r\n");
      out.write("                                 <ul>\r\n");
      out.write("                                     <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/event.bo\">?????????</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">??????/??????</a></li>                    \r\n");
      out.write("                                 </ul>\r\n");
      out.write("                     </li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("               </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p class=\"mobile-menu-close\">\r\n");
      out.write("               <button>\r\n");
      out.write("                  <span class=\"blind\">????????????</span>\r\n");
      out.write("                  <span></span>\r\n");
      out.write("                  <span></span>\r\n");
      out.write("               </button>\r\n");
      out.write("            </p>\r\n");
      out.write("         </div>\r\n");
      out.write("      </header>\r\n");
      out.write("   </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- ?????? -->\r\n");
      out.write("	<div class=\"container\">\r\n");
      out.write("		<h2 class=\"text-center\">?????? ?????????</h2>\r\n");
      out.write("\r\n");
      out.write("		<!-- ?????????????????? ????????? ????????? ?????? -->\r\n");
      out.write("		<div align=\"right\">\r\n");
      out.write("			");
if (userId != null) {
      out.write("\r\n");
      out.write("			<button\r\n");
      out.write("				onclick=\"location.href='");
      out.print(request.getContextPath());
      out.write("/sellInsertForm.bo'\">????????????</button>\r\n");
      out.write("			");
}
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("		<br>\r\n");
      out.write("\r\n");
      out.write("		<main class=\"mt-3\"><!-- margin -->\r\n");
      out.write("			<div class=\"container\">\r\n");
      out.write("				<div class=\"row mb-2\">\r\n");
      out.write("					<div class=\"col-12\"><!-- ??????????????? -->						\r\n");
      out.write("							<select class=\"form-select\" onchange=\"location.href=this.value\">\r\n");
      out.write("								<option selected>???????????? ??????</option>\r\n");
      out.write("								<option value=\"");
      out.print(request.getContextPath());
      out.write("/sellCategoryList.bo?category=");
      out.print(one );
      out.write("\">?????????</option>								\r\n");
      out.write("								<option value=\"");
      out.print(request.getContextPath());
      out.write("/sellCategoryList.bo?category=");
      out.print(two );
      out.write("\">????????????</option>\r\n");
      out.write("								<option value=\"");
      out.print(request.getContextPath());
      out.write("/sellCategoryList.bo?category=");
      out.print(three );
      out.write("\">?????????</option>\r\n");
      out.write("								<option value=\"");
      out.print(request.getContextPath());
      out.write("/sellCategoryList.bo?category=");
      out.print(four );
      out.write("\">?????????</option>\r\n");
      out.write("								<option value=\"");
      out.print(request.getContextPath());
      out.write("/sellCategoryList.bo?category=");
      out.print(five );
      out.write("\">??????</option>\r\n");
      out.write("							</select>							\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"row g-3\">\r\n");
      out.write("					<div class=\"col-xl-3 col-lg-4 col-md-6\"><!-- container ????????? ???????????? ?????? ?????? -->\r\n");
      out.write("						");

						for (Board b : list) {
						
      out.write("\r\n");
      out.write("						<div class=\"thumbnail\" align=\"center\">\r\n");
      out.write("							<input type=\"hidden\" value=\"");
      out.print(b.getBoardNo());
      out.write("\">\r\n");
      out.write("							<div class=\"card\" style=\"width: 220px;\">\r\n");
      out.write("								<img\r\n");
      out.write("									src=\"");
      out.print(request.getContextPath());
      out.write("/resources/board_upfiles/");
      out.print(b.getTitleImg());
      out.write("\"\r\n");
      out.write("									width=\"200px\" height=\"150px\" class=\"card-img-top\" />\r\n");
      out.write("\r\n");
      out.write("								<div class=\"card-body\">\r\n");
      out.write("									<p class=\"card-text\">\r\n");
      out.write("									<h4>\r\n");
      out.write("										<span class=\"badge bg-secondary\">");
      out.print(b.getCategoryName());
      out.write("</span>\r\n");
      out.write("										");
if (b.getBoardStatus().equals("?????????")) {
      out.write("\r\n");
      out.write("										<span class=\"badge bg-primary\">?????????</span>\r\n");
      out.write("\r\n");
      out.write("										");
} else if (b.getBoardStatus().equals("?????????")) {
      out.write("\r\n");
      out.write("										<span class=\"badge bg-success\">?????????</span>\r\n");
      out.write("\r\n");
      out.write("										");
} else if (b.getBoardStatus().equals("????????????")) {
      out.write("\r\n");
      out.write("										<span class=\"badge bg-warning\">????????????</span>\r\n");
      out.write("										");
}
      out.write("\r\n");
      out.write("										<span>");
      out.print(b.getUserId());
      out.write("</span>\r\n");
      out.write("									</h4>\r\n");
      out.write("									<br>\r\n");
      out.write("									<h5 class=\"card-title\">\r\n");
      out.write("										");
      out.print(b.getBoardTitle());
      out.write("\r\n");
      out.write("									</h5>\r\n");
      out.write("									<div class=\"d-flex justify-content-between align-items-center\">\r\n");
      out.write("										<!--?????????, ?????????, ??????????-->\r\n");
      out.write("\r\n");
      out.write("										<!-- ?????? ????????? ??????-->\r\n");
      out.write("										<!-- <div class=\"btn-group\" role=\"group\">\r\n");
      out.write("                         			 <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">??????1</button>\r\n");
      out.write("                          			 <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">??????2</button>\r\n");
      out.write("                        			</div> -->\r\n");
      out.write("										<small class=\"text-dark\">????????? ");
      out.print(b.getbCnt());
      out.write("</small> <small\r\n");
      out.write("											class=\"text-dark\" align=\"right\">????????? ");
      out.print(b.getLikeCnt());
      out.write("</small>\r\n");
      out.write("									</div>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("						");
}
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</main>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js\"\r\n");
      out.write("		integrity=\"sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW\"\r\n");
      out.write("		crossorigin=\"anonymous\">\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("	<script>\r\n");
      out.write("		\r\n");
      out.write("			$(function(){\r\n");
      out.write("				$(\".thumbnail\").click(function(){\r\n");
      out.write("					var bNo = $(this).children().eq(0).val();\r\n");
      out.write("					location.href=\"");
      out.print(request.getContextPath());
      out.write("/sellDetail.bo?bNo=\"+ bNo; });\r\n");
      out.write("			});\r\n");
      out.write("			\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
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
