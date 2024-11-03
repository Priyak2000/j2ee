package qspproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	public static void main(String[] args) {
		
		Connection con=null;
		//step1
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded sucessfully");
			String url="jdbc:mysql://localhost:3307";
			String username="root";
			String password="root";
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Database connected sucessfully");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
