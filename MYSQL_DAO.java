import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MYSQL_DAO implements InterfaceUserDAO{

	Connection connection = null;
	PreparedStatement ptmt = null;
	ResultSet resultSet = null;
	
	public MYSQL_DAO() {
		
	}
	
	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionBank.getInstance().getConnection();
		return conn;
	}
	
	@Override
	public void addCustomer(Bank customer) {
		try {
			String queryString = "INSERT INTO Person(accountNumber, customerName, balance, email, phoneNumber) VALUES(?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, customer.getAccountNumber());
			ptmt.setString(2, customer.getCustomerName());
			ptmt.setDouble(3, customer.getBalance());
			ptmt.setString(4, customer.getEmail());
			ptmt.setInt(5, customer.getPhoneNumber());
			
			ptmt.executeUpdate();
			System.out.println("Data Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		
	}

	@Override
	public void updateName(Bank customer) {
		try {
			String queryString = "UPDATE Person SET customerName=? WHERE accountNumber=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setString(1, customer.getCustomerName());
			ptmt.setInt(2, customer.getAccountNumber());
			
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
	}

	@Override
	public void updateEmail(Bank customer) {
		try {
			String queryString = "UPDATE Person SET email=? WHERE accountNumber=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setString(1, customer.getEmail());
			ptmt.setInt(2, customer.getAccountNumber());
			
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
	}

	@Override
	public void updatePhone(Bank customer) {
		try {
			String queryString = "UPDATE Person SET phoneNumber=? WHERE accountNumber=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			
			ptmt.setInt(1, customer.getPhoneNumber());
			ptmt.setInt(2, customer.getAccountNumber());
			
			ptmt.executeUpdate();
			System.out.println("Table Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			}

			catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		
	}

	@Override
	public void deleteCustomer(int accountNumber) {

		try {
			String queryString = "DELETE FROM Person WHERE accountNumber=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setInt(1, accountNumber);
			
			ptmt.executeUpdate();
			System.out.println("Data deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

	@Override
	public void displayAllUsers() {
		try {
			String queryString = "SELECT * FROM Person";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			resultSet = ptmt.executeQuery();
			
			while (resultSet.next()) {
				System.out.println("Account Number: " + resultSet.getInt("accountNumber")
						+ ", Name: " + resultSet.getString("customerName") + ", Balance: "
						+ resultSet.getDouble("balance") + ", Email: "
						+ resultSet.getString("email") + ", Phone Number: " + resultSet.getInt("phoneNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}

}
