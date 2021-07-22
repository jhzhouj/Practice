import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Random;

public class BankTransactions {
    public static void main(String[] args) {
    	
    	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    	String DB_URL = "jdbc:mysql://database-july2021.cham8bsd6cos.us-east-2.rds.amazonaws.com:3306/BankDB";
        String USER = "admin";
        String PASS = "testadmin";
        
        System.out.println("Connecting to a selected database...");
        
        
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {		      
           System.out.println("Connected database successfully...");  
		
		   System.out.println("Creating table in bank database...");
		   
		   Statement stmt = conn.createStatement();
		   
		   String sql = "CREATE TABLE Person " +
		                "(accountNumber INTEGER NOT NULL, " +
				        " customerName VARCHAR(30), " +
				        " balance DOUBLE PRECISION, " +
		                " email VARCHAR(100), " +
				        " phoneNumber VARCHAR(30), " +
		                " PRIMARY KEY(accountNumber) )";
				   
		   stmt.executeUpdate(sql);
		   System.out.println("Created table in given database...");
           
        } catch (SQLException e) {
           e.printStackTrace();
        } 
        
        
        //BankDao customerDao = new BankDaoImpl();
    	
    	MYSQL_DAO customer = new MYSQL_DAO();

        Scanner myObj = new Scanner(System.in);

        System.out.println("Please enter your name, email and phone number to create an account: ");
        String name = myObj.nextLine();
        String email = myObj.nextLine();
        int phone = myObj.nextInt();

        Random rand = new Random();
        int rand_int1 = rand.nextInt(10000);
        //customerDao.addCustomer(rand_int1, 0, name, email, phone);
        Bank user1 = new Bank(rand_int1, 0, name, email, phone);
        
        //for testing two persons
        Bank user2 = new Bank(6666, 250, "Jack", "jack@gmail.com", 123456789);

        customer.addCustomer(user1);
        customer.addCustomer(user2);
        
        //System.out.println("What is your account number? ");
        //int num = myObj.nextInt();

        user1.setCustomerName("Mary");
    	customer.updateName(user1);
    	
    	
        customer.displayAllUsers();
        /*
        System.out.println("Please enter 1 for updating name, " +
                "2 for deleting customer, 3 for displaying all users, and 4 for exit.");
        int answer = myObj.nextInt();

        while(answer != 4) {

            switch (answer) {
                case 1:
                	//String sql = "SELECT accountNumber, customerName FROM Person" +
                    //        " WHERE accountNumber = num ";
                	//ResultSet rs = stmt.executeQuery(sql);
                	System.out.println("What name do you want? ");
                	String newName = myObj.nextLine();
                	user1.setCustomerName(newName);
                	customer.updateName(user1);
                    break;
                case 2:
                	String sql2 = "SELECT accountNumber, customerName FROM Person" +
                            " WHERE accountNumber = num ";
                	ResultSet rs2 = stmt.executeQuery(sql2);
                	customer.deleteCustomer(num);
                    break;
                case 3:
                	customer.displayAllUsers();
                	break;
                    
              
            }
            System.out.println("Please enter 1 for updating name, " +
                    "2 for deleting customer, 3 for displaying all users, and 4 for exit.");
            answer = myObj.nextInt();
        }
        */
    }
}




/*

Please enter your name, email and phone number to create an account:
Jack
jack@gmail.com
123456789
Customer name: Jack
Customer account: 9186
Customer balance: 0.0
Customer email: jack@gmail.com
Customer phone number: 123456789

Customer name: Lee
Customer account: 6666
Customer balance: 222.0
Customer email: yahoo
Customer phone number: 110

What is your account number?
9186
Please enter 1 for showing your account balance, 2 for depositing money, 3 for withdrawing money and 4 for exit.
1
Your account balance:
0.0
Please enter 1 for showing your account balance, 2 for depositing money, 3 for withdrawing money and 4 for exit.
2
How much money do you want to deposit?
100
Your account balance:
100.0
Please enter 1 for showing your account balance, 2 for depositing money, 3 for withdrawing money and 4 for exit.
2
How much money do you want to deposit?
1
You can't deposit less than $5 or more than $10000.
Your account balance:
100.0
Please enter 1 for showing your account balance, 2 for depositing money, 3 for withdrawing money and 4 for exit.
3
How much money do you want to withdraw?
50
Your account balance:
50.0
Please enter 1 for showing your account balance, 2 for depositing money, 3 for withdrawing money and 4 for exit.
4

Process finished with exit code 0



 */