package com.jspiders.image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImageIntoDatabase 
{
	public static void main(String[] args) 
	{
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3307/language?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			String query="INSERT INTO IMAGE(ID,NAME,LOGO) VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, 1);
			pstmt.setString(2, "Java");
			FileInputStream fis=new FileInputStream("C:\\Users\\priya\\OneDrive\\Pictures\\img\\java2.png");
			pstmt.setBinaryStream(3, fis);
			pstmt.addBatch();
			pstmt.setInt(1, 2);
			pstmt.setString(2,"SpringBoot");
			FileInputStream fis1=new FileInputStream("C:\\Users\\priya\\OneDrive\\Pictures\\img\\springBoot.png");
			pstmt.setBinaryStream(3, fis1);
			pstmt.addBatch();
			pstmt.setInt(1, 3);
			pstmt.setString(2,"Python");
			FileInputStream fis2=new FileInputStream("C:\\Users\\priya\\OneDrive\\Pictures\\img\\python.jpg");
			pstmt.setBinaryStream(3, fis2);
			pstmt.addBatch();
			pstmt.setInt(1, 4);
			pstmt.setString(2,"Sql");
			FileInputStream fis3=new FileInputStream("C:\\Users\\priya\\OneDrive\\Pictures\\img\\sql2.png");
			pstmt.setBinaryStream(3, fis3);
			pstmt.addBatch(); 
			int [] count=pstmt.executeBatch();
			for(int arr:count) {
				System.out.println(arr);
			}
		}
		catch(ClassNotFoundException | SQLException | FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
