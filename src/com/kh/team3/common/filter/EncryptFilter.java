package com.kh.team3.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.kh.common.wrapper.EncryptWrapper;

/**
 * Servlet Filter implementation class EncryptFilter
 */
// 인서트, 로그인, 비번 바꿀때도 암호화 해서 들어가야하니깐 url 주소를 적어줌
// 필트를 두개를 걸기 때문에 이렇게 안하고 web.xml 우선순위 정해서 할거임
//@WebFilter(filterName = "encryptFilter", urlPatterns = {"/insert.me", "/login.me", "updatepwd.me"})
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setAttribute("originPwd", request.getParameter("userPwd")); //서블릿보다 먼저 동작하니깐 변경되기전임
		System.out.println("변경전 ---->" + request.getParameter("userPwd"));
		
		EncryptWrapper encRequest = new EncryptWrapper((HttpServletRequest)request);
		// EncryptWrapper 갔다온 것 찍고 필터로 넘겨주기
		System.out.println("변경후 ---->" + encRequest.getParameter("userPwd"));
		chain.doFilter(encRequest, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
