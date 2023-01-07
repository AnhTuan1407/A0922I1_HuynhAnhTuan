package furama_project.type;

import java.util.Scanner;

public enum RentalType {
    Year, Month, Day, Hour;

    public static RentalType displayRentalType() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Year");
        System.out.println("2. Month");
        System.out.println("3. Day");
        System.out.println("4. Hour");
        System.out.println("Enter your RentalType: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                return RentalType.Year;
            }

            case 2: {
                return RentalType.Month;
            }

            case 3: {
                return RentalType.Day;
            }

            case 4: {
                return RentalType.Hour;
            }
        }
        return null;
    }
}
