package com.jspiders.webApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		Date date=new Date();
		out.print("<h2 style='color:red;' align='center'>"+date+"</h2");
		resp.setHeader("refresh","1");
	}
}
