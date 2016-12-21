package com.andy.system.util;

import javax.servlet.http.HttpServletRequest;

public class Common {
	
	public static String getStr(HttpServletRequest request, String strParamName, String strEncodeNameOld, String strEncodeNameNew) throws Exception {
		return new String(request.getParameter(strParamName).getBytes(strEncodeNameOld), strEncodeNameNew);
	}
}
