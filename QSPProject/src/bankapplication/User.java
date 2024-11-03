package bankapplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class User
{
    private Connection connection;
    private Scanner scanner;
    public User(Connection connection,Scanner scanner)
    {
    	this.connection = connection;
    	this.scanner = scanner;  	
    }
//    method for user registration
    public void register()
    {
    	scanner.nextLine();
    	System.out.println("ENTER FULL NAME");
    	String full_name = scanner.nextLine();
    	System.out.println("ENTER EMAIL");
    	String email = scanner.nextLine();
    	System.out.println("ENTER PASSWORD:");
    	String password = scanner.nextLine();
    	if(user_exist(email))
    	{
    		System.out.println("USER ALREADY EXIST'S FOR THIS EMAIL ADDRESS!");
    		return;
    	}
    	String query = "INSERT INTO USER(FULL_NAME,EMAIL,PASSWORD) VALUES(?,?,?)";
    	try
    	{
    		PreparedStatement psmt = connection.prepareStatement(query);
    		psmt.setString(1, full_name);
    		psmt.setString(2, email);
    		psmt.setString(3, password);
    		int count = psmt.executeUpdate();
    		if(count>0)
    		{
    			System.out.println("REGISTRATION DONE SUCCESFULLY");
    		}
    		else
    		{
    			System.out.println("REGISTRATION FAILED!");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
//    method for login
    public String login()
    {
    	scanner.nextLine();
    	System.out.println("Enter email : ");
    	String email = scanner.nextLine();
    	System.out.println("Enterr password : ");
    	String password = scanner.nextLine();
    	String query = "SELECT * FROM USER WHERE EMAIL = ? AND PASSWORD = ?";
    	try
    	{
    		PreparedStatement psmt = connection.prepareStatement(query);
    		psmt.setString(1,email);
    		psmt.setString(2,password);
    		ResultSet rs = psmt.executeQuery();
    		if(rs.next())
    		{
    			return email;
    		}
    		else
    		{
    			return null;
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return null;
    }
    //method checking weather user is exist or  not 
    public boolean user_exist(String email)
    {
    	String query = "SELECT * FROM USER WHERE EMAIL = ?";
    	try
    	{
    		PreparedStatement psmt = connection.prepareStatement(query);
    		psmt.setString(1,email);
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
