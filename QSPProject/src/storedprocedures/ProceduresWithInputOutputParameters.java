package storedprocedures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
import java.sql.CallableStatement;

public class ProceduresWithInputOutputParameters {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the agent code :");
		String code=scan.next();
		scan.close();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl="jdbc:mysql://localhost:3307/spy?user=root&password=root";
			Connection con=DriverManager.getConnection(dburl);
			String plsql="CALL `spy`.`getAgentName`(?,?)";
			CallableStatement cstmt=con.prepareCall(plsql);
			cstmt.setString(1, code);
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.executeQuery();
		
			System.out.println("---Stored Procedure with IN and OUT parameter");
			String name=cstmt.getString(2);
			System.out.println("Agent name :" + name );
			
			
			
			con.close();
		}
		catch(ClassNotFoundException | SQLException e) {
			
		}
	}

}
