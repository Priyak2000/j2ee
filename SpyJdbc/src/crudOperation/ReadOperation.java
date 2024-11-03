package crudOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadOperation {
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
	            String query = "SELECT * FROM STUDENT";

	            // Create a statement
	            Statement st = con.createStatement();

	            // Execute the query
	            ResultSet rs = st.executeQuery(query);

	            // Process the result set
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String email = rs.getString("email");
	                double phn_number = rs.getDouble("phone_number");
	                String course = rs.getString("course");
	                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Mobile: " + phn_number + ", Course: " + course);
	                
	            }
	            System.out.println("Sucessefully retrieve the data");

	            // Close the resources
	            rs.close();
	            st.close();
	            con.close();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	}

}
