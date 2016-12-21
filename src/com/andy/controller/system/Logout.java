package com.andy.controller.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class test
 */
@WebServlet("/logout")
public class Logout extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() throws Exception {
        super();
        
    }

	@Override
	protected void afterGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.afterPost(request, response);
		
	}

	@Override
	protected void afterPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		this.role = null;
		
		response.sendRedirect("login.jsp");
	}

}
