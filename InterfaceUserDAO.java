

public interface InterfaceUserDAO {
	public void addCustomer(Bank customer);
    public void updateName(Bank customer);
    public void updateEmail(Bank customer);
    public void updatePhone(Bank customer);
    public void deleteCustomer(int accountNumber);
    public void displayAllUsers();
    
}
