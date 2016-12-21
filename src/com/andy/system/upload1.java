package com.andy.system;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
@WebServlet("/upload1")
public class upload1 extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(upload1.class);
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public upload1() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	 ServletContext context = this.getServletContext();
//         String log4jConfigFile = context.getInitParameter("log4j-config-location");
//         String fullPath = context.getRealPath("");
//         
//         response.getWriter().print(fullPath);
//         
//         response.getWriter().print("config:" + (getServletConfig() == null));
//         
//         String strParamNames = "";
//         Enumeration<String> enumParamNames = this.getServletConfig().getInitParameterNames();//getServletConfig().getInitParameterNames();
//         while(enumParamNames.hasMoreElements())
//         {
//         	strParamNames += enumParamNames.nextElement();
//         }
//         
//         response.getWriter().print("ParamNames : " + strParamNames);
//         
//         System.out.println(this.getServletContext().getRealPath("/WEB-INF/web.xml"));
// 		 
//         strParamNames = "";
//         enumParamNames = this.getServletContext().getInitParameterNames();//getServletConfig().getInitParameterNames();
//         while(enumParamNames.hasMoreElements())
//         {
//         	strParamNames += enumParamNames.nextElement() + System.lineSeparator();
//         }
//          
//         log.error("ParamNames : " + strParamNames);
//         
//         String strPath = "";
//         for(String str : this.getServletContext().getResourcePaths("/"))
//         {
//         	strPath += str + System.lineSeparator();
//         	
//         }
//         
//         log.error("Path:" + strPath);

	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		byte[] body = readBody(request);
		
		String textBody = new String(body, "ISO-8859-1");
		
		String filename = getFilename(textBody);
		
		Position p = getFilePosition(request, textBody);
		
		writeTo(filename, body, p);
	}
    
    class Position {
    	int begin;
    	int end;
    	Position(int begin, int end) {
    		this.begin = begin;
    		this.end = end;
    	}
    }
    
    private byte[] readBody(HttpServletRequest request) throws IOException {
    	int formDataLength = request.getContentLength();
    	DataInputStream dataStream = new DataInputStream(request.getInputStream());
    	
    	byte body[] = new byte[formDataLength];
    	int totalBytes = 0;
    	while(totalBytes < formDataLength) {
    		int bytes = dataStream.read(body, totalBytes, formDataLength);
    		totalBytes += bytes;
    	}
    	return body;
    }

    private Position getFilePosition(HttpServletRequest request, String textBody) throws IOException {
    	String contentType = request.getContentType();
    	String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
    	
    	int pos = textBody.indexOf("filename=\"");
    	pos = textBody.indexOf("\n", pos) + 1;
    	pos = textBody.indexOf("\n", pos) + 1;
    	pos = textBody.indexOf("\n", pos) + 1;
    	int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
    	int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
    	int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;
    	
    	return new Position(begin, end);
    }
    
    private String getFilename(String reqBody) {
    	String filename = reqBody.substring(reqBody.indexOf("filename=\"") + 10);
    	filename = filename.substring(0, filename.indexOf("\n"));
    	filename = filename.substring(filename.lastIndexOf("\\") + 1, filename.indexOf("\""));
    	
    	return filename;
    }
    
    private void writeTo(String filename, byte[] body, Position p) throws FileNotFoundException, IOException {
    	FileOutputStream fileOutputStream = new FileOutputStream(filename);
    	fileOutputStream.write(body, p.begin, (p.end - p.begin));
    	fileOutputStream.flush();
    	fileOutputStream.close();
    }
}
