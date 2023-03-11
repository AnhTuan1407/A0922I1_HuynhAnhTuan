package on_tap_module2.model;

import java.util.Scanner;

public class Credit extends Card {
    private double balance;
    private double limit;

    public Credit() {
    }

    public Credit(String numCard, String nameCard, String identityCard, String address, double balance, double limit) {
        super(numCard, nameCard, identityCard, address);
        this.balance = balance;
        this.limit = limit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return super.toString() + "Credit{" +
                "balance=" + balance +
                ", limit=" + limit +
                '}';
    }

    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter limit: ");
        this.limit = scanner.nextDouble();
        scanner.nextLine();
    }
}
