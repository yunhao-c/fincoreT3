import java.util.ArrayList;
import java.util.List;

public class BudgetManager {

    public List<BudgetEntry> entries = new ArrayList<>();

    public void addIncome(double amount, String description) {
        BudgetEntry entry = new BudgetEntry(amount, "INCOME", description);
        entries.add(entry);
    }

    public void addExpense(double amount, String description) {
        BudgetEntry entry = new BudgetEntry(amount, "EXPENSE", description);
        entries.add(entry);
    }

    public double getBalance() {
        double balance = 0.0;
        for (BudgetEntry entry : entries) {
            balance += entry.getSignedAmount();
        }
        return balance;
    }

    public List<BudgetEntry> getEntries() {
        return entries;
    }
}
