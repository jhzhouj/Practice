public class Bank {
    public int accountNumber = 123456789;
    public double balance = 50.0;
    public String customerName = "Jiahang Zhou";
    public String email = "jiahang.zhouj.@gmail.com";
    public int phoneNumber = 987654321;

    public Bank() {}

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
        System.out.println("Customer information: " + this.customerName + this.accountNumber + this.balance +this.email +this.phoneNumber);
    }

}
