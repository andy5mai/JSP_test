package com.andy.controller.system;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.avro.data.Json;

@WebServlet("/json/api")
public class JsonApi extends BaseServlet {
	public JsonApi() throws Exception{
        super();
        this.needValid = false;
    }

	@Override
	protected void afterGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		list.add("test5");
		
		response.getWriter().print(Json.toString(list));
	}

	@Override
	protected void afterPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
}
