package crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateOperation {
	public static void main(String[] args) {
		try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database credentials
            String url = "jdbc:mysql://localhost:3307/clg";
            String user = "root";
            String password = "root";

            // Establish the connection
            Connection con = DriverManager.getConnection(url, user, password);

            // SQL query
            String query = "Insert into student (id,name,email,phone_number,course) values(?,?,?,?,?)";

            // Create a statement
            PreparedStatement psi = con.prepareStatement(query);

            // Execute the query
           psi.setInt(1,125);
           psi.setString(2, "Vibin");
           psi.setString(3, "vibi123@gmail.com");
           psi.setDouble(4, 999456732);
           psi.setString(5, "Java fulstack");
           psi.executeUpdate();
           System.out.println("Record created."); 
            
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
