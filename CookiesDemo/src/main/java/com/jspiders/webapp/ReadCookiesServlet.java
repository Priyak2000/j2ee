package com.jspiders.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/read")
public class ReadCookiesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		//reading cookies
		Cookie [] cookie=req.getCookies();
		if(cookie!=null) {
			for(Cookie ac: cookie) {
				out.print("<h2 style='color:red;'>Name->"+ac.getName()+"value->" + ac.getValue()+"</h2>");
			}
		}
		else {
			out.print("<h2 style='color:blue;'>cookies are not present</h2>");
		}
	}

}
