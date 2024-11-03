package com.jspiders.image;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadImageFromDatabase {
	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3307/language?user=root&password=root";
			con = DriverManager.getConnection(dburl);
			String query="SELECT * FROM IMAGE";
			pstmt = con.prepareStatement(query);
			rs=pstmt.executeQuery();
			System.out.println("Id         Name          Logo");
			System.out.println("-----------------------------");
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString("name");
				Blob image=rs.getBlob(3);
				System.out.println(id+"\t"+name+"\t\t\t"+image);
			}
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					System.out.println("Connection is closed!!");
				}
				
			}
			if(pstmt!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("PreparedStatment is closed!!");
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					System.out.println("ResultSet is closed!!");
				}
			}
		}
	}

}
