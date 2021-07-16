import java.util.Scanner;
import java.util.Random;

public class BankTransactions {
    public static void main(String[] args) {
        BankDao customerDao = new BankDaoImpl();

        Scanner myObj = new Scanner(System.in);

        System.out.println("Please enter your name, email and phone number to create an account: ");
        String name = myObj.nextLine();
        String email = myObj.nextLine();
        int phone = myObj.nextInt();

        Random rand = new Random();
        int rand_int1 = rand.nextInt(10000);
        customerDao.addCustomer(rand_int1, 0, name, email, phone);

        // just for testing two accounts
        customerDao.addCustomer(6666, 222, "Lee", "yahoo", 110);

        customerDao.displayAllUsers();

        System.out.println("What is your account number? ");
        int num = myObj.nextInt();



        System.out.println("Please enter 1 for showing your account balance, " +
                "2 for depositing money, 3 for withdrawing money and 4 for exit.");
        int answer = myObj.nextInt();

        while(answer != 4) {

            switch (answer) {
                case 1:
                    for (Bank user : customerDao.getAllUsers()) {
                        if (user.getAccountNumber() == num) {
                            System.out.println("Your account balance: ");
                            customerDao.displayBalance(user);
                        }
                    }
                    break;
                case 2:
                    System.out.println("How much money do you want to deposit?");
                    double amount = myObj.nextDouble();
                    for (Bank user : customerDao.getAllUsers()) {
                        if (user.getAccountNumber() == num) {
                            customerDao.deposit(user, amount);
                            System.out.println("Your account balance: ");
                            customerDao.displayBalance(user);
                        }
                    }
                    break;
                case 3:
                    System.out.println("How much money do you want to withdraw?");
                    double amountWithdraw = myObj.nextDouble();
                    for (Bank user : customerDao.getAllUsers()) {
                        if (user.getAccountNumber() == num) {
                            user.withdraw(amountWithdraw);
                            System.out.println("Your account balance: ");
                            customerDao.displayBalance(user);
                        }
                    }
                    break;
            }
            System.out.println("Please enter 1 for showing your account balance, " +
                    "2 for depositing money, 3 for withdrawing money and 4 for exit.");
            answer = myObj.nextInt();
        }
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