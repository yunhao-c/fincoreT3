
public class BudgetEntry {

    private double amount; 
    private String type;  
    private String description;   

    public BudgetEntry(double amount, String type, String description) {
        setAmount(amount);       
        this.type = type;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!"INCOME".equals(type) && !"EXPENSE".equals(type)) {
            throw new IllegalArgumentException("Type must be INCOME or EXPENSE.");
        }
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSignedAmount() {
        if ("INCOME".equals(type)) {
            return amount;
        } else {
            return -amount;
        }
    }

    @Override
    public String toString() {
        return "[" + type + "] " + amount + " - " + description;
    }
}
