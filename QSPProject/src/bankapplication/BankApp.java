package bankapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
public class BankApp 
{
  	private static final String dburl = "jdbc:mysql://localhost:3307/bank";
	private static final String user = "root";
	private static final String password = "root";
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//loading the drivers
		}
		catch(ClassNotFoundException e)
		{
		   e.printStackTrace();	
		}
		try
		{
			Connection connection = DriverManager.getConnection(dburl, user, password);
			Scanner scanner = new Scanner(System.in);
			User user = new User(connection,scanner);
			Accounts accounts = new Accounts(connection,scanner);
			AccountManager accountManager = new AccountManager(connection,scanner);
			String email;
			long account_number;
			while (true)
			{
				System.out.println("***Welcome to Banking System***");
				System.out.println();
				System.out.println("1. Register");
				System.out.println("2. Login");
				System.out.println("3. Exit");
				System.out.println("Enter your choice : ");
				int choice1 =scanner.nextInt();
				switch(choice1)
				{
		    		case 1 : user.register();
		    		         break;
		    		         
		    		case 2: email = user.login();
		    		        if(email!=null)
		    		        {
		    		        	System.out.println();
		    		        	System.out.println("User is logged in !!!");
		    		        	if(!accounts.account_exist(email))
		    		        	{
		    		        		System.out.println();
		    		        	    System.out.println("1. Open a new Bank Account");
		    		        	    System.out.println("2. Exit");
		    		        	}
		    		        	if(scanner.nextInt() == 1)
		    		        	{
		    		        		account_number = accounts.open_account(email);
		    		        		System.out.println("Account is created successfully!!");
		    		        		System.out.println("Account number : " + account_number);
		    		        		

		    		        	}
		    		        	else
		    		        	{
		    		        		break;
		    		        	}
		    		        
		    		        account_number = accounts.getAccount_number(email);
		    		        int choice2 = 0;
		    		        while(choice2!=5)
		    		        {
		    		           System.out.println();
		    		           System.out.println("1. Debit Money");
		    		           System.out.println("2. Credit Money");
		    		           System.out.println("3. Transfer Money");
		    		           System.out.println("4. Check Balance");
		    		           System.out.println("5. Logout");
		    		           System.out.println("Enter your choice : ");
		    		           choice2 = scanner.nextInt();
		    		           switch(choice2)
		    		           {
		    		              case 1 : accountManager.debit_money(account_number);
		    		                       break;
		    		              case 2 : accountManager.credit_money(account_number);
                                           break;
		    		              case 3 : accountManager.transfer_money(account_number);
		    		                       break;
		    		              case 4 : accountManager.getBalance(account_number);
		    		                       break;
		    		              case 5 : 
		    		            	       break;
		    		              default: System.out.println("Enter Valid Choice!!!");
		    		                       break;
		    		           }
		    		       }
		    	    }	
		    				else
		    				{
		    					System.out.println("Incorrect email or password");
		    				}
		    				case 3 : System.out.println("Thank you for using bankging system!!!");
		    				         System.out.println("Existing the System");
		    				         return ;
		    				default : System.out.println("Enter valid choice ");
		    				          break;
		
			}
	}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
