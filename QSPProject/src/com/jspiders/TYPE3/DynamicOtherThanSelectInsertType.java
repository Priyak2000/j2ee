package com.jspiders.TYPE3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicOtherThanSelectInsertType {
public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter agent code :");
		String agent_code=scan.next();
		System.out.println("Enter agent name :");
		String agent_name=scan.next();
		System.out.println("Enter agent location :");
		String agent_loc=scan.next();
		System.out.println("Enter agent salary :");
		double agent_sal=scan.nextDouble();
		System.out.println("Enter agent Phone no :");
		long agent_phno=scan.nextLong();
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");//loading driver
		String dburl="jdbc:mysql://localhost:3307/spy?user=root&password=root";
		Connection con=DriverManager.getConnection(dburl);//create connection
		String query="INSERT INTO AGENT(AGENT_CODE,AGENT_NAME,AGENT_LOC,AGENT_AMT,AGENT_PHNO)"
					+"VALUES(?,?,?,?,?)";//issue the query
		PreparedStatement pstmt=con.prepareStatement(query);//create statement
		
		//setting the values for placeholders
		pstmt.setString(1, agent_code);
		pstmt.setString(2, agent_name);
		pstmt.setString(3, agent_loc);
		pstmt.setDouble(4, agent_sal);
		pstmt.setLong(5, agent_phno);
		
		int count =pstmt.executeUpdate();//execute the query
		
		if(count!=0) //process the query
			System.out.println("Data inserted..");
		else
			System.out.println("failed...");
		con.close();
		
		
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
}
}
