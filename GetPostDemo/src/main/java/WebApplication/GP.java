package WebApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GP extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();

		//Read data From query String in order to login
		
		String u=req.getParameter("user");
		String p=req.getParameter("password");
		
		if (u.equals("java@gmail.com")&& p.equals("java@123")) 
		{
			out.print("<h2 style='color:green;'>Login Done Successfully</h2>");
		}
		else {
			out.print("<h2 style='color:green;'>Login failed due to invalid Username and password</h1>");
		}
	}
}
