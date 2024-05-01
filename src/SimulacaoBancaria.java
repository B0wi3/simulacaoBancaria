import java.util.Scanner;

public class SimulacaoBancaria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your account number (8 digits): ");
        String accNumber = validateAccNumber(scanner);
        System.out.println("\nAccount " + accNumber + " registered.");

        double balance = 0;

        System.out.println("\nChoose an option: \n1 - Deposit \n2 - Withdraw \n3 - Check balance \n4 - Exit");

        boolean running = true;
        while (running) {
            int option = scanner.nextInt();

            switch(option) {
                case 1:
                    balance = deposit(balance, scanner);
                    break;

                case 2:
                    balance = withdraw(balance, scanner);
                    break;

                case 3:
                    System.out.println("Current balance: " + balance);
                    break;

                case 4:
                    System.out.println("Exiting... ");
                    running = false;
                    break;

                default:
                    System.out.println("Please, enter a valid option: ");
            }
        }
    }

    public static String validateAccNumber(Scanner scanner) {
        String accNumber;
        while (true) {
            accNumber = scanner.nextLine();
            if (accNumber.length() != 8) {
                System.out.println("Incorrect format, make sure you are entering 8 digits: ");
            } else {
                break;
            }
        }
        return accNumber;
    }

    public static double deposit (Double currBalance, Scanner scanner) {
        System.out.println("Enter the amount you wish to deposit: ");
        double deposit = scanner.nextDouble();

        currBalance += deposit;
        System.out.println("New balance: " + currBalance);

        return currBalance;
    }

    public static double withdraw (Double currBalance, Scanner scanner) {
        try {
            System.out.println("Enter the amount you wish to withdraw: ");
            double withdraw = scanner.nextDouble();

            if (withdraw > currBalance) {
                throw new invalidAmountException("Not enough balance available. ");
            } else {
                currBalance -= withdraw;
                System.out.println("New balance: " + currBalance);
            }
        } catch (invalidAmountException e) {
            System.out.println(e.getMessage());
        }

        return currBalance;
    }
}

class invalidAmountException extends Exception {
    public invalidAmountException(String message) {
        super(message);
    }
}