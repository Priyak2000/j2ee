package crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteOperation {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3307/clg";
			String name="root";
			String pass="root";
			Connection con=DriverManager.getConnection(url,name,pass);
			
			String sql="Delete from student where id=?";
			PreparedStatement psi=con.prepareStatement(sql);
			psi.setInt(1, 123);
			int rowAffected= psi.executeUpdate();
			if(rowAffected>0) {
			System.out.println("Record Deleted");
			}
			else {
				System.out.println("User not found");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
