package com.jspiders.webApplication;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatortServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        
        int a = 10;
        int b = 5;
        
        out.print("<html><body>");
        out.print("<h2 style='color:blue;'>Addition of two numbers: " + a + " + " + b + " = " + (a + b) + "</h2><br>");
        out.print("<h2 style='color:yellow;'>Subtraction of two numbers: " + a + " - " + b + " = " + (a - b) + "</h2><br>");
        out.print("<h2 style='color:green;'>Multiplication of two numbers: " + a + " * " + b + " = " + (a * b) + "</h2><br>");
        out.print("<h2 style='color:pink;'>Division of two numbers: " + a + " / " + b + " = " + (a / b) + "</h2><br>");
        out.print("</body></html>");
    }
}

