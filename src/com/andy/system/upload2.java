package com.andy.system;

import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.jdbc.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import org.apache.log4j.Level;
/**
 * Servlet implementation class test
 */

@MultipartConfig(location=".")
@WebServlet("/upload2")
public class upload2 extends HttpServlet {
	
	private static Logger log = LoggerFactory.getLogger(upload2.class);
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public upload2() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	
		Part part = request.getPart("photo");
		String filename = getFilename(part);
		writeTo(filename, part);
		//直接寫檔
//		part.write(filename);
		
		//multi file upload
//		for(Part part : request.getParts()) {
//			if (part.getName().startsWith("file")) {
//				String filename = getFilename(part);
//				part.write(filename);
//			}
//		}
	}
    
    private String getFilename(Part part) {
    	String header = part.getHeader("Content-Disposition");
    	String filename = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
    	
    	return filename;
    }
    
    private void writeTo(String filename, Part part) throws FileNotFoundException, IOException {
    	InputStream in = part.getInputStream();
    	OutputStream out = new FileOutputStream(filename);
    	
    	byte[] buffer = new byte[1024];
    	int length = -1;
    	while((length = in.read(buffer)) != -1) {
    		out.write(buffer, 0, length);
    	}
    	
    	in.close();
    	out.close();
    }
}
