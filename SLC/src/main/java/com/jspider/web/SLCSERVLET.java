package com.jspider.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SLCSERVLET  implements Servlet{
	@Override
	public  void init(ServletConfig config) throws ServletException{
		System.out.println("servlet object will be initialized by invoking init() method");
		
	}
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		out.print("<h2 style='color:GreenYellow;'>client request will be handled by using service()</h2>");
		out.print("<h3 style='color:aqua;'>Invokes multiple time when client gives request</h3>");
	}
	@Override
	public void destroy() {
		System.out.println("clean up code will be done by ivking destroy() method after the server shutdown");
		System.out.println("invokes only once in life cycle");
	}
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}