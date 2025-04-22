import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        Customer currentCustomer = null;

        boolean running = true;

        while (running) {
            System.out.println("\n--- Simple Banking Menu ---");
            System.out.println("1. Create New Bank Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter a new account number: ");
                    String accountNumber = scanner.nextLine();

                    currentCustomer = new Customer(name, accountNumber);
                    bank.addCustomer(currentCustomer);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String depositName = scanner.nextLine();
                    System.out.print("Enter your account number: ");
                    String depositAccount = scanner.nextLine();

                    Customer depositCustomer = bank.find_customer(depositName, depositAccount);
                    if (depositCustomer != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        depositCustomer.depositMoney(depositAmount);
                    } else {
                        System.out.println("Customer not found. Please check your details.");
                    }
                    break;

                case 3:
                    System.out.print("Enter your name: ");
                    String withdrawName = scanner.nextLine();
                    System.out.print("Enter your account number: ");
                    String withdrawAccount = scanner.nextLine();

                    Customer withdrawCustomer = bank.find_customer(withdrawName, withdrawAccount);
                    if (withdrawCustomer != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdrawCustomer.withdrawMoney(withdrawAmount);
                    } else {
                        System.out.println("Customer not found. Please check your details.");
                    }
                    break;

                case 4:
                    if (checkCustomer(currentCustomer)) {
                        currentCustomer.checkBalance();
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank you for using the Simple Banking System!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5.");
            }
        }

        scanner.close();
    }

    private static boolean checkCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("No customer account found. Please create an account first.");
            return false;
        }
        return true;
    }
}