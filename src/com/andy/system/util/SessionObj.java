package com.andy.system.util;

import javax.servlet.http.HttpSession;

import com.andy.system.modelObj.IRole;

public class SessionObj {
	
	public static IRole getRole(HttpSession httpSession) {
		return (IRole)httpSession.getAttribute("role");
	}
	
	public static void setRole(HttpSession httpSession, IRole role) {
		httpSession.setAttribute("role", role);
	}
	
	public static void setTargetPage(HttpSession httpSession, String strTargetPage) {
		httpSession.setAttribute("targetPage", strTargetPage);
	}
	
	public static String getTargetPage(HttpSession httpSession) {
		return (String) httpSession.getAttribute("targetPage");
	}

}
