
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
	
public class ConnectionBank {
	String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	String DB_URL = "jdbc:mysql://database-july2021.cham8bsd6cos.us-east-2.rds.amazonaws.com:3306/BankDB";
    String USER = "admin";
    String PASS = "testadmin";
    
    //System.out.println("Connecting to a selected database...");
    
    private static ConnectionBank connectionBank = null;
    
    public ConnectionBank() {
    	
    }
    
    public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}
    
    public static ConnectionBank getInstance() {
		if (connectionBank == null) {
			connectionBank = new ConnectionBank();
		}
		return connectionBank;
	}
    
}

