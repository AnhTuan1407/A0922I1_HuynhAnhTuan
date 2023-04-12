package Loop;

import java.util.Scanner;

public class Print_Shape {
    public static void main(String[] args) {
        int choice;
        while (true) {
            do {
                System.out.println("\n");
                Scanner scanner = new Scanner(System.in);
                System.out.println("1. Print the rectangle");
                System.out.println("2. Print the square triangle");
                System.out.println("3. Print isosceles triangle");
                System.out.println("4. Exit");
                System.out.println("Enter your choice: ");
                choice = scanner.nextInt();
                if (choice < 0 || choice > 4) {
                    System.out.println("Error!");
                }
            } while (choice < 0 || choice > 4);

            switch (choice) {
                case 1: {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("");
                        for (int j = 0; j < 7; j++) {
                            System.out.print("* ");
                        }
                    }
                    break;
                }

                case 2: {
                    for (int i = 0; i < 5; i++) {
                        System.out.println("");
                        for (int j = 0; j < i + 1; j++) {
                            System.out.print("* ");
                        }
                    }
                    break;
                }

                case 3: {
                    int temp = 1;
                    int n = 5;
                    for (int i = 0; i < 5; i++) {
                        System.out.println("");
                        for (int j = 0; j < n -1; j++) {
                            System.out.print("  ");
                        }
                        for (int k = 0; k < i + temp; k++) {
                            System.out.print("* ");
                        }
                        temp += 1;
                        n--;
                    }
                    break;
                }

                case 4: {
                    System.exit(0);
                }
            }
        }

    }
}
