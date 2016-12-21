package com.andy.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.apache.log4j.Level;
/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(test.class);
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 ServletContext context = this.getServletContext();
         String log4jConfigFile = context.getInitParameter("log4j-config-location");
         String fullPath = context.getRealPath("");
         
         response.getWriter().print(fullPath);
         
         response.getWriter().print("config:" + (getServletConfig() == null));
         
         String strParamNames = "";
         Enumeration<String> enumParamNames = this.getServletConfig().getInitParameterNames();//getServletConfig().getInitParameterNames();
         while(enumParamNames.hasMoreElements())
         {
         	strParamNames += enumParamNames.nextElement();
         }
         
         response.getWriter().print("ParamNames : " + strParamNames);
         
         System.out.println(this.getServletContext().getRealPath("/WEB-INF/web.xml"));
 		 
         strParamNames = "";
         enumParamNames = this.getServletContext().getInitParameterNames();//getServletConfig().getInitParameterNames();
         while(enumParamNames.hasMoreElements())
         {
         	strParamNames += enumParamNames.nextElement() + System.lineSeparator();
         }
          
         log.error("ParamNames : " + strParamNames);
         
         String strPath = "";
         for(String str : this.getServletContext().getResourcePaths("/"))
         {
         	strPath += str + System.lineSeparator();
         	
         }
         
         log.error("Path:" + strPath);

	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
