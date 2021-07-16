import java.util.ArrayList;
import java.util.List;

public class BankDaoImpl implements BankDao {
    List<Bank> customers;

    public BankDaoImpl(){

        customers = new ArrayList<Bank>();
    }

    @Override
    public void addCustomer(int accountNumber, double balance, String customerName, String email, int phoneNumber) {
        customers.add(new Bank(accountNumber, balance, customerName, email, phoneNumber));

    }

    @Override
    public void updateName(Bank user, String newName) {
        user.setCustomerName(newName);

    }

    @Override
    public void updateEmail(Bank user, String newEmail) {
        user.setEmail(newEmail);
    }

    @Override
    public void updatePhone(Bank user, int newPhone) {
        user.setPhoneNumber(newPhone);
    }

    @Override
    public void deleteCustomer(Bank user) {
        customers.remove(user);
    }
    @Override
    public List<Bank> getAllUsers() {
        return customers;
    }

    @Override
    public void displayAllUsers() {
        for(Bank user: customers) {
            displayInfo(user);
        }
    }


    @Override
    public void displayInfo(Bank user) {
        user.customerInfo();
    }

    @Override
    public void deposit(Bank user, double funds) {
        if(funds < 5 || funds > 10000) {
            System.out.println("You can't deposit less than $5 or more than $10000.");
        } else {
            user.deposit(funds);
        }
    }

    @Override
    public void displayBalance(Bank user) {
        System.out.println(user.getBalance());
    }


}
