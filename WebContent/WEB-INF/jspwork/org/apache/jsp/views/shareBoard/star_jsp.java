/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.69
 * Generated at: 2021-08-25 09:12:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.shareBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class star_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write(".wrap{\r\n");
      out.write("    max-width: 480px;\r\n");
      out.write("    margin: 0 auto; /* 화면 가운데로 */\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    padding: 20px;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write(".reviewform textarea{\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write(".rating .rate_radio {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    z-index: 20;\r\n");
      out.write("    opacity: 0.001;\r\n");
      out.write("    width: 60px;\r\n");
      out.write("    height: 60px;\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    vertical-align: top;\r\n");
      out.write("    display: none;\r\n");
      out.write("}\r\n");
      out.write(".rating .rate_radio + label {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    margin-left: -4px;\r\n");
      out.write("    z-index: 10;\r\n");
      out.write("    width: 60px;\r\n");
      out.write("    height: 60px;\r\n");
      out.write("    background-image: url('../../resources/images/star/star.png');\r\n");
      out.write("    background-repeat: no-repeat;\r\n");
      out.write("    background-size: 60px 60px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write(".rating .rate_radio:checked + label {\r\n");
      out.write("    background-image: url('../../resources/images/star/star2.png');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".warning_msg {\r\n");
      out.write("    display: none;\r\n");
      out.write("    position: relative;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    background: #ffffff;\r\n");
      out.write("    line-height: 26px;\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    color: red;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    border: 1px solid #e0e0e0;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("<div class=\"wrap\">\r\n");
      out.write(" \r\n");
      out.write("    <form name=\"reviewform\" id= \"reviewform\" class=\"reviewform\" method=\"post\" action=\"\">\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"review_rating\">\r\n");
      out.write("            <div class=\"rating\">\r\n");
      out.write("                <!-- 해당 별점을 클릭하면 해당 별과 그 왼쪽의 모든 별의 체크박스에 checked 적용 -->\r\n");
      out.write("                <input type=\"checkbox\" name=\"rating\" id=\"rating1\" value=\"1\" class=\"rate_radio\" title=\"1점\">\r\n");
      out.write("                <label for=\"rating1\"></label>\r\n");
      out.write("                <input type=\"checkbox\" name=\"rating\" id=\"rating2\" value=\"2\" class=\"rate_radio\" title=\"2점\">\r\n");
      out.write("                <label for=\"rating2\"></label>\r\n");
      out.write("                <input type=\"checkbox\" name=\"rating\" id=\"rating3\" value=\"3\" class=\"rate_radio\" title=\"3점\" >\r\n");
      out.write("                <label for=\"rating3\"></label>\r\n");
      out.write("                <input type=\"checkbox\" name=\"rating\" id=\"rating4\" value=\"4\" class=\"rate_radio\" title=\"4점\">\r\n");
      out.write("                <label for=\"rating4\"></label>\r\n");
      out.write("                <input type=\"checkbox\" name=\"rating\" id=\"rating5\" value=\"5\" class=\"rate_radio\" title=\"5점\">\r\n");
      out.write("                <label for=\"rating5\"></label>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      \r\n");
      out.write("           	<input type=hidden name=\"rate\" id=\"rate\" value=\"0\"/>\r\n");
      out.write("           	<input type=\"checkbox\" id=\"chk_info\">불친절\r\n");
      out.write("            <button type=\"button\" onclick=\"star();\">별점주기</button>\r\n");
      out.write("        \r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("  //별점 마킹 모듈 프로토타입으로 생성\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("	    \r\n");
      out.write("	    \r\n");
      out.write("  function Rating(){};\r\n");
      out.write("    \r\n");
      out.write("    Rating.prototype.rate = 0;\r\n");
      out.write("    Rating.prototype.setRate = function(newrate){\r\n");
      out.write("        //별점 마킹 - 클릭한 별 이하 모든 별 체크 처리\r\n");
      out.write("        this.rate = newrate;\r\n");
      out.write("        let items = document.querySelectorAll('.rate_radio');\r\n");
      out.write("        items.forEach(function(item, idx){\r\n");
      out.write("            if(idx < newrate){\r\n");
      out.write("                item.checked = true;\r\n");
      out.write("            }else{\r\n");
      out.write("                item.checked = false;\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("    let rating = new Rating();//별점 인스턴스 생성\r\n");
      out.write("    \r\n");
      out.write("    document.addEventListener('DOMContentLoaded', function(){\r\n");
      out.write("        //별점선택 이벤트 리스너\r\n");
      out.write("        document.querySelector('.rating').addEventListener('click',function(e){\r\n");
      out.write("            let elem = e.target;\r\n");
      out.write("            if(elem.classList.contains('rate_radio')){\r\n");
      out.write("               \r\n");
      out.write("                if ($(\"input:checkbox[id='chk_info']\").is(\":checked\")){\r\n");
      out.write("                		\r\n");
      out.write("                	$('#rate').val(parseInt(\"-\"+elem.value));\r\n");
      out.write("                	\r\n");
      out.write("                	\r\n");
      out.write("                }else{\r\n");
      out.write("                	 $('#rate').val(elem.value);\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                rating.setRate(parseInt(elem.value));\r\n");
      out.write("              \r\n");
      out.write("              \r\n");
      out.write("\r\n");
      out.write("            		   \r\n");
      out.write("            }\r\n");
      out.write("        })\r\n");
      out.write("    });\r\n");
      out.write("    \r\n");
      out.write("    function star(){\r\n");
      out.write("		$('#reviewform').each(function(){\r\n");
      out.write("		    console.log(\"실행되니?\");\r\n");
      out.write("		    $(\"#reviewform\").attr(\"action\", \"");
      out.print(request.getContextPath());
      out.write("/Star.bo\");\r\n");
      out.write("			$(\"#reviewform\").submit();\r\n");
      out.write("		    \r\n");
      out.write("		});\r\n");
      out.write("		 \r\n");
      out.write("		\r\n");
      out.write("	}\r\n");
      out.write("    </script>\r\n");
      out.write("</div>\r\n");
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
