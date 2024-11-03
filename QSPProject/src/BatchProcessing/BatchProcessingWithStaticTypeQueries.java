package BatchProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchProcessingWithStaticTypeQueries {
	public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");//loading driver
		String dburl="jdbc:mysql://localhost:3307/spy?user=root&password=root";
		Connection con = DriverManager.getConnection(dburl);//establish connection
		String query1="INSERT INTO AGENT(AGENT_CODE,AGENT_NAME,AGENT_LOC,AGENT_AMT,AGENT_PHNO)"
						+"VALUES('A12','kavi','KOCHI',120000,9187653421)";
		String query2="UPDATE AGENT SET AGENT_LOC='TRIVANDRUM' WHERE AGENT_CODE='152'";
		String query3="DELETE FROM AGENT WHERE AGENT_CODE='A78'";
		String query4="SELECT * FROM AGENT WHERE AGENT_CODE='123'";
		Statement stmt=con.createStatement();
		stmt.addBatch(query1);
		stmt.addBatch(query2);
		stmt.addBatch(query3);
		int [] count=stmt.executeBatch();
		for(int arr: count) {
			System.out.println(arr);
		}
		ResultSet rs=stmt.executeQuery(query4);
		System.out.println("Code  Name   Loc  Sal  Phone");
		System.out.println("-----------------------------");
		if(rs.next()) {
			String code=rs.getString(1);
			String name=rs.getString(2);
			String loc=rs.getString(3);
			double amt=rs.getDouble(4);
			long phone=rs.getLong(5);
		System.out.println(code +"\t" +name + "\t" + "\t" + loc + "\t" + amt + "\t"+ phone);	
			
		}
		else {
			System.out.println("Agent code is invalid!");
		}
	
	con.close();	
	} catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
}
}
