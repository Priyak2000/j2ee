package com.jspider.TYPE2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class StaticOtherThanSelectInsertType {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Loading the driver
			String dburl="jdbc:mysql://localhost:3307/spy?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl); //create the connection 
			String query="INSERT INTO AGENT(AGENT_CODE,AGENT_NAME,AGENT_LOC,AGENT_AMT,AGENT_PHNO)"
							+"VALUES('A270','Kavi','Tvm',50000,999757809)";
			Statement stmt=con.createStatement();//create statement
			int count =stmt.executeUpdate(query);//excute query
			if(count!=0) //process the query
			{
				System.out.println("Data inserted successfully");
			}
			else {
				System.out.println("Try again");
			}
			con.close(); //close the connection
			
		} catch (ClassNotFoundException | SQLException e ) {
			
			e.printStackTrace();
		}
	}

}
