package com.andy.controller.system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;

import com.andy.system.modelObj.IRole;
import com.andy.system.util.MySQL;
import com.andy.system.util.SessionObj;

public abstract class BaseServlet extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(BaseServlet.class);

	protected static String errorMsgAttrName = "errorMsg";
	protected static String contentType_Text = "text/html;charset=UTF-8";
	
	protected IRole role = null;
	protected Connection conn;
	protected String contentType;
	
	public BaseServlet() throws Exception{
		super();
		
		this.contentType = BaseServlet.contentType_Text;
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.conn = MySQL.setDBConnection(this.getServletContext().getInitParameter("mysql-connection"));
	}
		
	protected boolean validateRole(HttpSession httpSession) {
		this.role = null;
		
		if ((this.role = SessionObj.getRole(httpSession)) != null) {
			return true;
		}
		
		return false;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(this.contentType);
		
		if (!this.validateRole(request.getSession()) && this.getClass() != Login.class) {
			response.sendRedirect("login");
			return;
		}
		log.error("doGet validate role...");
		
		this.afterGet(request, response);
	}
	
	protected abstract void afterGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(this.contentType);
		
		if (!this.validateRole(request.getSession()) && this.getClass() != Login.class) {
			response.sendRedirect("login");
			return;
		}
		log.error("doPost validate role success!");
		
		this.afterPost(request, response);
	}
	
	protected abstract void afterPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
