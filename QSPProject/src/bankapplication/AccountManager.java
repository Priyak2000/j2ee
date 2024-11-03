package bankapplication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AccountManager 
{
    private Connection connection;
    private Scanner scanner;
	public AccountManager(Connection connection, Scanner scanner)
	{
		this.connection = connection;
		this.scanner = scanner;
	}
//	method for credit money
	public void credit_money(long account_number) throws SQLException
	{
		scanner.nextLine();
		System.out.println("ENTER YOUR AMOUNT:");
		double amount =scanner.nextDouble();
		scanner.nextLine();
		System.out.println("ENTER YOUR SECURITY PIN:");
		String pin = scanner.nextLine();
		
		try
		{
			connection.setAutoCommit(false);
			if(account_number!=0)
			{
				String query = "SELECT* FROM ACCOUNTS WHERE ACCOUNT_NUMBER=? AND SECURITY_PIN=? ";
				PreparedStatement psmt =connection.prepareStatement(query);
				psmt.setLong(1, account_number);
				psmt.setString(2, pin);
				ResultSet rs = psmt.executeQuery();
				if(rs.next())
				{
					String credit ="UPDATE ACCOUNTS SET BALANCE = BALANCE + ? WHERE ACCOUNT_NUMBER=?";
					PreparedStatement psmt1 = connection.prepareStatement(credit);
					psmt1.setDouble(1, amount);
					psmt1.setLong(2, account_number);
					int count = psmt1.executeUpdate();
					if(count>0)
					{
						System.out.println("rs."+amount+"CREDITY SUCCESSFULLY");
						connection.commit();
						connection.setAutoCommit(true);
						return;
					}
					else
					{
						System.out.println("TRANSACTION FAILED");
						connection.rollback();
						connection.setAutoCommit(true);
					}
				}
				else
				{
					System.out.println("INVALID PIN");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		connection.setAutoCommit(true);
	}
//	method for debit money
	
	public void debit_money(long account_number) throws SQLException
	{
		scanner.nextLine();
		System.out.println("ENTER YOUR AMOUNT:");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("ENTER YOUR SECURITY PIN:");
		String pin = scanner.nextLine();
		try
		{
			connection.setAutoCommit(false);
			if(account_number!=0)
			{
				String query ="SELECT * FROM ACCOUNTS WHERE ACCOUNT_NUMBER=? AND SECURITY_PIN=?";
				PreparedStatement psmt = connection.prepareStatement(query);
				psmt.setLong(1, account_number);
				psmt.setString(2, pin);
				ResultSet rs = psmt.executeQuery();
				if(rs.next())
				{
					double current_balance = rs.getDouble("balance");
					if(amount<=current_balance)
					{
						String debit ="UPDATE ACCOUNTS SET BALANCE = BALANCE -? WHERE ACCOUNT_NUMBER=?";
						PreparedStatement psmt1 = connection.prepareStatement(debit);
						psmt1.setDouble(1, amount);
						psmt1.setLong(2, account_number);
						int count = psmt1.executeUpdate();
					    if(count>0)	
					    {
					    	System.out.println("RS."+amount+"DEBITED SUCCESSFULLY");
					    	connection.commit();
					    	connection.setAutoCommit(true);
					    }
					    else
					    {
					    	System.out.println("TRANSACTION FAILED");
					    	connection.rollback();
					    	connection.setAutoCommit(true);
					    }
					}
					else
					{
						System.out.println("INSUFFIENT FUNDS/BALANCE");
					}
				}
				else
				{
					System.out.println("INVALID PIN");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		connection.setAutoCommit(true);
	}
//	method for transfer the money
	
	public void transfer_money(long sender_account_number)
	{
		scanner.nextLine();
		System.out.println("ENTER RECIEVER ACCOUNT NUMBER:");
		long reciever_account_number = scanner.nextLong();
		System.out.println("ENTER AMOUNT:");
		double amount = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("ENTER SECURITY  PIN:");
		String pin = scanner.next();
		try
		{
			connection.setAutoCommit(false);
			if(sender_account_number!=0 && reciever_account_number !=0 )
			{
				String query = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_NUMBER = ? AND SECURITY_PIN= ?";
				PreparedStatement psmt = connection.prepareStatement(query);
				psmt.setLong(1, sender_account_number);
				psmt.setString(2, pin);
				ResultSet rs = psmt.executeQuery();
				if(rs.next())
				{
					double current_balance = rs.getDouble("balance");
					if(amount<=current_balance)
					{
//						write debit and credit queries
						String debit = "UPDATE ACCOUNTS SET BALANCE = BALANCE -? WHERE ACCOUNT_NUMBER =?";
						String credit = "UPDATE ACCOUNTS SET BALANCE = BALANCE +? WHERE ACCOUNT_NUMBER =?";
						PreparedStatement psmt1 = connection.prepareStatement(credit);
						PreparedStatement psmt2 = connection.prepareStatement(debit);
//						set the values for debit
						psmt1.setDouble(1, amount);
						psmt1.setLong(2, reciever_account_number);
//						set the values for credit
						psmt2.setDouble(1, amount);
						psmt2.setLong(2, sender_account_number);
						int count1= psmt1.executeUpdate();
						int count2= psmt2.executeUpdate();
						if(count1>0 && count2>0)
						{
							System.out.println("TRANSFER DONE SUCCESFULLY");
							System.out.println("Rs."+amount+ "TRANSFERRED SUCCESSFULLY");
							connection.commit();
							connection.setAutoCommit(true);
							return;
						}
						else
						{
							System.out.println("TRANSACTION FAILED");
							connection.rollback();
							connection.setAutoCommit(true);
						}
					}
					else
					{
						System.out.println("INSUFFIECENT FUNDS OR BALANCE");
					}
				}
				else
				{
					System.out.println("INVALID PIN");
				}
				
			}
			else
			{
				System.out.println("INVALID ACCOUNT NUMBER");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
//	method for get balance
	public void getBalance(long account_number)
	{
		scanner.nextLine();
		System.out.println("ENTER SECURTIY PIN");
		String pin = scanner.nextLine();
		try 
		{
			String query = "SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNT_NUMBER=? AND SECURITY_PIN=?" ;
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setLong(1, account_number);
			psmt.setString(2, pin);
			ResultSet rs = psmt.executeQuery();
			if(rs.next())
			{
				double balance = rs.getDouble("balance");
				System.out.println("ACCOUNT BALANCE: rs."+balance);
			}
			else
			{
				System.out.println("INVALID PIN");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
	
