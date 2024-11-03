package crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateOperation {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3307/clg";
			String name="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,name,pass);
			
			String sql="Update student set course=? where id=?";
			PreparedStatement psi=con.prepareStatement(sql);
			psi.setString(1,"python fullstack");
			psi.setInt(2, 123);
			psi.executeUpdate();
			System.out.println("Record updated");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
