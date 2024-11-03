package com.jspiders.loadingdriver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadingDriverWay1 {
	public static void main(String[] args) {
		try {
		java.sql.Driver driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		System.out.println("Loading Driver done successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
