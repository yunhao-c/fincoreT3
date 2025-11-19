import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BudgetManager manager = new BudgetManager();

        boolean running = true;

        while (running) {
            System.out.println("===== Budget Management =====");
            System.out.println("1. Add income");
            System.out.println("2. Add expense");
            System.out.println("3. View all entries");
            System.out.println("4. View balance");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Income amount: ");
                    double incomeAmount = readAmount(scanner);
                    System.out.print("Description: ");
                    String incomeDesc = scanner.nextLine();
                    manager.addIncome(incomeAmount, incomeDesc);
                    System.out.println("Income added.");
                    break;

                case "2":
                    System.out.print("Expense amount: ");
                    double expenseAmount = readAmount(scanner);
                    System.out.print("Description: ");
                    String expenseDesc = scanner.nextLine();
                    manager.addExpense(expenseAmount, expenseDesc);
                    System.out.println("Expense added.");
                    break;

                case "3":
                    System.out.println("All entries:");
                    for (BudgetEntry entry : manager.getEntries()) {
                        System.out.println(entry);
                    }
                    break;

                case "4":
                    System.out.println("Current balance: " + manager.getBalance());
                    break;

                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }

            System.out.println();
        }

        scanner.close();
    }


    private static double readAmount(Scanner scanner) {
        while (true) {
            try {
                String line = scanner.nextLine();
                double value = Double.parseDouble(line);
                if (value <= 0) {
                    System.out.print("Amount must be positive, try again: ");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid number, try again: ");
            }
        }
    }
}
