import java.util.Scanner;

public class BankTransactions {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter 1 for showing your account balance, " +
                "2 for depositing money, 3 for withdrawing money and 4 for exit.");
        int answer = myObj.nextInt();

        Bank customer = new Bank();
        switch (answer) {
            case 1:
                System.out.println("Your account balance: " + customer.balance);
                break;
            case 2:
                System.out.println("How much money do you want to deposit?");
                double amount = myObj.nextDouble();
                customer.deposit(amount);
                System.out.println("Your account balance: " + customer.balance);
                break;
            case 3:
                System.out.println("How much money do you want to withdraw?");
                double amountWithdraw = myObj.nextDouble();
                customer.withdraw(amountWithdraw);
                System.out.println("Your account balance: " + customer.balance);
                break;
            case 4:
                System.out.println("Exit successfully.");
                break;
        }


    }
}
