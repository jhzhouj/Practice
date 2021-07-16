import java.util.List;

public interface BankDao {
    public void addCustomer(int accountNumber, double balance, String customerName, String email, int phoneNumber);
    public void updateName(Bank user, String newName);
    public void updateEmail(Bank user, String newEmail);
    public void updatePhone(Bank user, int newPhone);
    public void deleteCustomer(Bank user);
    public List<Bank> getAllUsers();
    public void displayAllUsers();
    public void displayInfo(Bank user);
    public void deposit(Bank user, double funds);
    public void displayBalance(Bank user);
}
