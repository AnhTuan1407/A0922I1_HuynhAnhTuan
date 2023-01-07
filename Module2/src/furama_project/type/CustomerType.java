package furama_project.type;

import java.util.Scanner;

public enum CustomerType {
    Diamond, Platinum, Gold, Silver, Member;

    public static CustomerType displayCustomerType() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Diamond");
        System.out.println("2. Platinum");
        System.out.println("3. Gold");
        System.out.println("4. Silver");
        System.out.println("5. Member");
        System.out.println("Enter your CustomerType: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                return CustomerType.Diamond;
            }

            case 2: {
                return CustomerType.Platinum;
            }

            case 3: {
                return CustomerType.Gold;
            }

            case 4: {
                return CustomerType.Silver;
            }

            case 5: {
                return CustomerType.Member;
            }
        }
        return null;
    }
}
