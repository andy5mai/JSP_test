package com.andy.controller.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andy.model.system.UsersModel;
import com.andy.system.modelObj.User;
import com.andy.system.util.SessionObj;

/**
 * Servlet implementation class test
 */
@WebServlet("/login")
public class Login extends BaseServlet {
	
	private static Logger log = LoggerFactory.getLogger(Login.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() throws Exception{
        super();
        // TODO Auto-generated constructor stub
        
        //PropertyConfigurator.configure("C:\\Users\\ANDY\\workspace\\test\\WebContent\\WEB-INF\\log4j.properties");
    }
    
    protected boolean getRole(String strEmail, String strPassword) {
		
		boolean result = true;
		
		if (this.role == null && !new UsersModel().checkUser(strEmail, strPassword)) {
			result = false;
		}
		
		return result;
	}


	@Override
	protected void afterGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.error("login afterGet...");
		
		if (this.role == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		SessionObj.setRole(request.getSession(), this.role);
		SessionObj.setTargetPage(request.getSession(), "index.jsp");
		
		log.error("login afterGet...2");
		response.sendRedirect("index");
	}

	@Override
	protected void afterPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String strEmail = request.getParameter("email");
		String strPassword = request.getParameter("password");
		

		log.error("login afterPost...");
		
		if (strEmail == null || strPassword == null) {
			
			request.setAttribute(BaseServlet.errorMsgAttrName, "Email or Password is not correct!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		if (!this.getRole(strEmail, strPassword)) {
			request.setAttribute(BaseServlet.errorMsgAttrName, "Login Failed!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		SessionObj.setRole(request.getSession(), new User(strEmail));
		SessionObj.setTargetPage(request.getSession(), "index.jsp");
		
//		response.sendRedirect("wholePage.jsp");
		response.sendRedirect("index");
	}

}
