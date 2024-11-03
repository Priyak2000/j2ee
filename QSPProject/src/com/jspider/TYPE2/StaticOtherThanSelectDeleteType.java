package com.jspider.TYPE2; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class StaticOtherThanSelectDeleteType {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3307/spy?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			String query="DELETE FROM AGENT WHERE AGENT_CODE='A55'";
			
			Statement stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			if(count!=0) {
				System.out.println("Delete done..");
			}
			else {
				System.out.println("Try again");
			}
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
