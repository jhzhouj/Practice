public class Bank {


    private int accountNumber;
    private double balance;
    private String customerName;
    private String email;
    private int phoneNumber;

    public Bank(int accountNumber, double balance, String customerName, String email, int phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }





    public void deposit(double funds) {
        this.balance += funds;
    }

    public void withdraw(double funds) {
        if(this.balance < funds) {
            System.out.println("Insufficient balance error: " + this.balance + " for " + this.customerName);
        } else {
            this.balance -= funds;
        }
    }

    public void customerInfo() {
        System.out.println("Customer name: " + this.customerName);
        System.out.println("Customer account: " + this.accountNumber);
        System.out.println("Customer balance: " + this.balance);
        System.out.println("Customer email: " + this.email);
        System.out.println("Customer phone number: " + this.phoneNumber);
        System.out.println("");
    }

}
