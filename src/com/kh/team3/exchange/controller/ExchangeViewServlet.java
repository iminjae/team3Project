package com.kh.team3.exchange.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.team3.exchange.service.ExchangeService;
import com.kh.team3.exchange.vo.Exchange;
import com.kh.team3.sellBoard.model.service.BoardService;
import com.kh.team3.sellBoard.model.vo.Board;

/**
 * Servlet implementation class ExchangeViewServlet
 */
@WebServlet("/ExchangeViewServlet.ev")
public class ExchangeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExchangeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Exchange> list = new ExchangeService().exchangeList(); 
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("views/exchange/exchangeView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
