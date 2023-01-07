package furama_project.type;

import java.util.Scanner;

public enum Level {
    Intermediate, College, Undergraduate, Graduate;

    public static Level displayLevel() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Intermediate");
        System.out.println("2. College");
        System.out.println("3. Undergraduate");
        System.out.println("4. Graduate");
        System.out.println("Enter your level: ");
        choice = scanner.nextInt();
        switch (choice) {
            case 1: {
                return Level.Intermediate;
            }

            case 2: {
                return Level.College;
            }

            case 3: {
                return Level.Undergraduate;
            }

            case 4: {
                return Level.Graduate;
            }
        }
        return null;
    }
}
