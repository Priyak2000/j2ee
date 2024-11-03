package storedprocedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.CallableStatement;

public class ProceduresWithInputParameters {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the agent code :");
		String code=scan.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3307/spy?user=root&password=root";
			Connection con = DriverManager.getConnection(dburl);
			String plsql = "CALL `spy`.`getAgentInfo`(?)";
			CallableStatement cstmt = con.prepareCall(plsql);
			// placeholder is--> input parameter
			cstmt.setString(1, code);
			ResultSet rs = cstmt.executeQuery();
			if(rs.next()) {
				String code1= rs.getString(1);
				String name = rs.getString(2);
				String loc= rs.getString(3);
				double salary = rs.getDouble(4);
				long phone = rs.getLong(5);
				System.out.println(code1 +"\t" +name + "\t" + "\t" + loc + "\t" + salary + "\t"+ phone);
				
			}
			else {
				System.out.println("Agent code invalid !");
			}

		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}

}
