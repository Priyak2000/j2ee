
package com.jspiders.TYPE3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicOtherThabSelectDeleteType {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	
	System.out.println("Enter the agent code :");
	String agent_code=scan.next();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dburl="jdbc:mysql://localhost:3307/spy?user=root&password=root";
		Connection con=DriverManager.getConnection(dburl);
		String query="DELETE FROM AGENT WHERE AGENT_CODE=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		
		
		pstmt.setString(1, agent_code);
		int count=pstmt.executeUpdate();
		if(count!=0)
			System.out.println("DELETE done...");
		else
			System.out.println("DELETE failed");
		
		con.close();
	} catch (ClassNotFoundException |SQLException e) {
		
		e.printStackTrace();
	}
	
}
}

