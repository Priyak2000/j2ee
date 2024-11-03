package bankapplication;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Accounts 
{
     private Connection connection;
     private Scanner scanner;
     public Accounts(Connection connection,Scanner scanner) 
     {
    	 this.connection =connection;
    	 this.scanner = scanner;
    	 
     }
//     method for create account
     public long open_account(String email)
     {
    	 if(!account_exist(email))
    	 {
    		 String query = "INSERT INTO ACCOUNTS(ACCOUNT_NUMBER,FULL_NAME,EMAIL,BALANCE,SECURITY_PIN) VALUES(?,?,?,?,?)";
    		 scanner.nextLine();
    		 System.out.println("ENTER YOUR FULL NAME");
    		 String full_name = scanner.nextLine();
    		 System.out.println("ENTER INITIAL BALANCE;");
    		 double balance = scanner.nextDouble();
    		 scanner.nextLine();
    		 System.out.println("ENTER YOUR SECURITY PIN");
    		 String pin = scanner.nextLine();
    		 try
    		 {
    			 long account_number = generateAccountNumber();
    			PreparedStatement psmt = connection.prepareStatement(query);
                psmt.setLong(1, account_number);
                psmt.setString(2, full_name);
                psmt.setString(3, email);
                psmt.setDouble(4, balance);
                psmt.setString(5, pin);
                int count = psmt.executeUpdate();
                if(count>0)
                {
                	return account_number;
                }
                else
                {
                	throw new RuntimeException("ACCOUNT CREATION FAILED");
                }
    		 }
    		 catch(Exception e)
    		 {
    			 e.printStackTrace();
    		 }
    		 throw new RuntimeException("ACCOUNT ALREADY EXIST");
    	 }
    	 return 0;
     }
//     method for getting account number
     public long getAccount_number(String email)
     {
    	 String query = "SELECT ACCOUNT_NUMBER FROM ACCOUNTS WHERE EMAIL = ?";
    	 try
    	 {
    		PreparedStatement psmt = connection.prepareStatement(query);
    		psmt.setString(1, email);
    		ResultSet rs = psmt.executeQuery();
    		if(rs.next())
    		{
    			return rs.getLong("account_number");
    		}
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 throw new RuntimeException("ACCOUNT DOESNOT EXIST");
    	 
     }
// method for generate account number
     public long generateAccountNumber()
     { 
    	 try
    	 {
    		 String query = "SELECT ACCOUNT_NUMBER FROM ACCOUNTS ORDER BY ACCOUNT_NUMBER DESC LIMIT 1";
    		Statement stmt = connection.createStatement();
    		ResultSet rs = stmt.executeQuery(query);
    		if(rs.next())
    		{
    			long last_account_number = rs.getLong("account_number");
    			return last_account_number;
    			
    		}
    		else
    		{
    			return 100000100;
    			
    		}
    	 }
    	 catch(Exception e)
    	 {
    		 e.printStackTrace();
    	 }
    	 return 100000100;
     }
     
//     method for checking account is exist or not
     public boolean account_exist(String email)
     {
    	 String query = "SELECT ACCOUNT_NUMBER FROM ACCOUNTS WHERE EMAIL =?";
    	 try
    	 {
    		 PreparedStatement psmt = connection.prepareStatement(query);
    		 psmt.setString(1, email);
    		 ResultSet rs = psmt.executeQuery();
    		 if(rs.next())
    		 {
    			 return true;
    		 }
    		 else
    		 {
    			 return false; 			 
    		 }
         }
    	 catch(Exception e)	 
		 {
			 e.printStackTrace();
		 }
    	 return false;
     }
   
}
