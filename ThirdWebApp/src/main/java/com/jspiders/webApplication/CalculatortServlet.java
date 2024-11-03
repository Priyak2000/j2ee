package com.jspiders.webApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatortServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		resp.setContentType(getServletInfo());
		PrintWriter out = resp.getWriter();
		int a=10;
		int b=5;
		out.print("<h2 style='color:blue;>Addition of two number : "+ a +"+" + b + "=" + (a+b)+"</h2></br>");
		out.print("<h2 style='color:yellow;>Substraction of two number : "+ a +"+" + b + "=" + (a-b)+"</h2></br>");
		out.print("<h2 style='color:green;>Multiplication of two number : "+ a +"+" + b + "=" + (a*b)+"</h2></br>");
		out.print("<h2 style='color:pink;>Division of two number : "+ a +"+" + b + "=" + (a/b)+"</h2></br>");
	}

}
