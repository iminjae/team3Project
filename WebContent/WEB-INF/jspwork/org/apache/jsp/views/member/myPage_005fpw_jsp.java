/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-08-25 12:08:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.team3.member.model.vo.Member;

public final class myPage_005fpw_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/member/../common/menubar.jsp", Long.valueOf(1629818111407L));
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
      out.write("    \r\n");


String userPwd = ((Member)request.getSession().getAttribute("loginUser")).getUserPwd();
String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();


      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <!-- Required meta tags -->\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap CSS -->\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We\" crossorigin=\"anonymous\">\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <title>마이 페이지</title>	\r\n");
      out.write("  </head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("  .list-group{\r\n");
      out.write("    float: left;\r\n");
      out.write("    margin-left: 30px;\r\n");
      out.write("    width: 400px;\r\n");
      out.write("    height: 300px;\r\n");
      out.write("    \r\n");
      out.write("  }\r\n");
      out.write("  #one{\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    font-size: large;\r\n");
      out.write("    background-color: blueviolet;\r\n");
      out.write("    color: white;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .del{\r\n");
      out.write("    margin-left: 100px;\r\n");
      out.write("    float: left;\r\n");
      out.write("    display: block;\r\n");
      out.write("    width: 600px;\r\n");
      out.write("    height: 300px;\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  .form-control{\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("\r\n");
      out.write("  #xkfxhl{\r\n");
      out.write("    width: 100px;\r\n");
      out.write("    height: 50px;\r\n");
      out.write("    background-color: blueviolet;\r\n");
      out.write("    color: white;\r\n");
      out.write("    margin-top : 30px;\r\n");
      out.write("    margin-left: 500px;\r\n");
      out.write("\r\n");
      out.write("	#exampleInputEmail1{\r\n");
      out.write("		margin-top : 30px;\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("</style>  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <body>\r\n");
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
      out.write("                        <img src=\"resources\\images\\common\\logo.jpg\" alt=\"사구팔구\">\r\n");
      out.write("            </picture>\r\n");
      out.write("            </a>\r\n");
      out.write("         </h1>\r\n");
      out.write("         <p class=\"mobile-menu-open\">\r\n");
      out.write("            <button>\r\n");
      out.write("                        <span class=\"blind\">메뉴 열기</span>\r\n");
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
      out.write("/MyPageMove.me\">마이 페이지</a></li>\r\n");
      out.write("                  <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/mystore.ms\">내 상점</a></li>\r\n");
      out.write("                  <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/logout.me\">로그아웃</a></li>\r\n");
      out.write("              	    <li>  <img src=\"");
      out.print(contextPath);
      out.write("/resources/board_upfiles/");
      out.print( path );
      out.write("\" width=\"30px\" height=\"30px\"> </li>\r\n");
      out.write("               </ul>\r\n");
      out.write("               <nav id=\"gnb\">\r\n");
      out.write("                  <h2 class=\"blind\">메인메뉴</h2>\r\n");
      out.write("                  <ul>\r\n");
      out.write("                     <li class=\"m1\">\r\n");
      out.write("                     	<a href=\"");
      out.print(request.getContextPath());
      out.write("/Notice_Manager.NM\">공지사항</a>\r\n");
      out.write("                     </li>\r\n");
      out.write("                     <li class=\"m2\">\r\n");
      out.write("                        <a href=\"#\">거래장터</a>\r\n");
      out.write("                        <ul >\r\n");
      out.write("                           <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/exchangeServlet.es\">물물교환 게시판</a></li>\r\n");
      out.write("                           <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/sellList.bo\">판매 게시판</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                     </li>\r\n");
      out.write("                     <li class=\"m3\">\r\n");
      out.write("                        <a href=\"#\">커뮤니티</a>\r\n");
      out.write("                        <ul>\r\n");
      out.write("                           <li><a href=\"#\">무료나눔</a></li>\r\n");
      out.write("                           <li><a href=\"list.bo\">자유 게시판</a></li>\r\n");
      out.write("                        \r\n");
      out.write("                        </ul>\r\n");
      out.write("                     </li>\r\n");
      out.write("                     <li class=\"m4 no-sub\">\r\n");
      out.write("                                 <a href=\"#\">기타</a>\r\n");
      out.write("                                 <ul>\r\n");
      out.write("                                     <li><a href=\"");
      out.print(request.getContextPath());
      out.write("/event.bo\">이벤트</a></li>\r\n");
      out.write("                                    <li><a href=\"#\">신고/문의</a></li>                    \r\n");
      out.write("                                 </ul>\r\n");
      out.write("                     </li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("               </nav>\r\n");
      out.write("            </div>\r\n");
      out.write("            <p class=\"mobile-menu-close\">\r\n");
      out.write("               <button>\r\n");
      out.write("                  <span class=\"blind\">메뉴닫기</span>\r\n");
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
      out.write("    <div id=\"header-wrap\">\r\n");
      out.write("  \r\n");
      out.write("   <div class=\"menu\">\r\n");
      out.write("   <div class=\"list-group\">\r\n");
      out.write("    <button type=\"button\" id =\"one\" class=\"list-group-item list-group-item-action\" aria-current=\"true\">\r\n");
      out.write("      MyPage Menu\r\n");
      out.write("    </button> \r\n");
      out.write("   <form action=\"");
      out.print(request.getContextPath());
      out.write("/MyPageUpdateMove.me\" method=\"post\">\r\n");
      out.write("   <input type=\"submit\" class=\"list-group-item list-group-item-action\" value=\"탈퇴하기\" name=\"one\"></button>\r\n");
      out.write("   <input type=\"submit\" class=\"list-group-item list-group-item-action\" value=\"회원정보수정\" name=\"two\"></button>\r\n");
      out.write("    <input type=\"submit\" class=\"list-group-item list-group-item-action\" value=\"비밀번호 변경\" name=\"four\">\r\n");
      out.write("   <input type=\"submit\" class=\"list-group-item list-group-item-action\" value=\"회원사진 설정\" name=\"five\">  \r\n");
      out.write("	<input type=\"submit\" id=\"ch\" class=\"list-group-item list-group-item-action\" value=\"관리자 게시판\" name=\"three\"></button> \r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write(" <div class=\"del\">\r\n");
      out.write(" \r\n");
      out.write("		<form id=\"updatepw\" method=\"post\"  action=\"");
      out.print(request.getContextPath() );
      out.write("/pwupdate.me\">\r\n");
      out.write("\r\n");
      out.write("  <div class=\"form-group\">\r\n");
      out.write("  \r\n");
      out.write("    <input type=\"hidden\" class=\"form-control\" name=\"id\" id=\"exampleInputEmail1\" value=\"");
      out.print(userId);
      out.write("\">\r\n");
      out.write("  \r\n");
      out.write("    <label for=\"exampleInputEmail1\">기존 패스워드</label>\r\n");
      out.write("    <input type=\"password\" class=\"form-control\" name=\"pw1\" id=\"exampleInputEmail1\">\r\n");
      out.write("    \r\n");
      out.write("    <label for=\"exampleInputEmail1\">변경 패스워드</label>\r\n");
      out.write("    <input type=\"password\" class=\"form-control\"  name=\"pw2\" id=\"exampleInputEmail1\">\r\n");
      out.write("    \r\n");
      out.write("    <label for=\"exampleInputEmail1\">확인 패스워드</label>\r\n");
      out.write("    <input type=\"password\" class=\"form-control\"  name=\"pw3\" id=\"exampleInputEmail1\">\r\n");
      out.write("  </div>\r\n");
      out.write("  \r\n");
      out.write("	\r\n");
      out.write("      <input type=\"submit\" value=\"변경하기\" id=\"xkfxhl\" onclick=\"uppw();\">\r\n");
      out.write("</form>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		function uppw(){\r\n");
      out.write("			\r\n");
      out.write("			var pwd = $('input[name=\"pw\"]').val();\r\n");
      out.write("			console.log(pwd);\r\n");
      out.write("			if(\"");
      out.print( userPwd );
      out.write("\" == pwd){\r\n");
      out.write("				var val = confirm(\"정말로 변경하시겠습니까?);\r\n");
      out.write("				\r\n");
      out.write("				if(val){\r\n");
      out.write("					$(\"#updatepw\").attr(\"action\",\"");
      out.print( request.getContextPath());
      out.write("/updatepw.me\");\r\n");
      out.write("					$(\"#updatepw\").submit();\r\n");
      out.write("				}else{\r\n");
      out.write("					alert(\"취소하였습니다.\");\r\n");
      out.write("				}\r\n");
      out.write("			}else{\r\n");
      out.write("				alert(\"비밀번호를 잘못입력하였습니다.\");\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" 	\r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("    <!-- Optional JavaScript; choose one of the two! -->\r\n");
      out.write("\r\n");
      out.write("    <!-- Option 1: Bootstrap Bundle with Popper -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Option 2: Separate Popper and Bootstrap JS -->\r\n");
      out.write("    <!--\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js\" integrity=\"sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("    -->\r\n");
      out.write("  </body>\r\n");
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