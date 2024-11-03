package com.jspiders.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateCookieServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		//create cookie
		Cookie ck=new Cookie("c1", "100"); //name->c1, value->100
		ck.setMaxAge(60*60*24); //optional
		Cookie ck1=new Cookie("c2", "200"); //name->c2, value->200
		ck1.setMaxAge(60 * 60 * 24); //optional
		Cookie ck2=new Cookie("c3", "300"); //name->c3, value->300
		
		//add the cookie
		resp.addCookie(ck);
		resp.addCookie(ck1);
		resp.addCookie(ck2);
		
		out.print("<h2 style='color:green;'>Cookie are created</h2>");
		
	}

}
