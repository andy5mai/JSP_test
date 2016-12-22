package com.andy.controller.system;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class test
 */
@WebServlet("/index")
public class Index extends BaseServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() throws Exception {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void afterGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("wholePage.jsp").forward(request, response);
	}

	@Override
	protected void afterPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("wholePage.jsp").forward(request, response);
	}
}
