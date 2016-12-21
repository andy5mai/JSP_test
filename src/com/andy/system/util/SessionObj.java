package com.andy.system.util;

import javax.servlet.http.HttpSession;

public class SessionObj {
	
	public static Object getRole(HttpSession httpSession) {
		return httpSession.getAttribute("role");
	}
	
	public static void setRole(HttpSession httpSession, String str) {
		httpSession.setAttribute("role", str);
	}

}
