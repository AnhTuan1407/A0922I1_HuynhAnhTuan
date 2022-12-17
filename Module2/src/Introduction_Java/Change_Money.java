package Introduction_Java;

import java.util.Scanner;

public class Change_Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 USD = 23.000 VND");
        System.out.println("Enter the amount you want to exchange (USD): ");
        int money = scanner.nextInt();
        System.out.println(money + " USD = " + money*23000 + " VND");
    }
}
