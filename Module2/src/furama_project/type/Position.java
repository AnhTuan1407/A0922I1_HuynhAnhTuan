package furama_project.type;

import java.util.Scanner;

public enum Position {
    Receptionist, Waiter, Specialist, Supervisor, Manager, Director;

    public static Position displayPosition() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Receptionist");
        System.out.println("2. Waiter");
        System.out.println("3. Specialist");
        System.out.println("4. Supervisor");
        System.out.println("5. Manager");
        System.out.println("6. Director");
        System.out.println("Enter your position: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                return Position.Receptionist;
            }

            case 2: {
                return Position.Waiter;
            }

            case 3: {
                return Position.Specialist;
            }

            case 4: {
                return Position.Supervisor;
            }

            case 5: {
                return Position.Manager;
            }

            case 6: {
                return Position.Director;
            }
        }
        return null;
    }
}
