package lesson15_exception_debug.triangle_exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập vào 3 cạnh của tam giác: ");
        Scanner scanner = new Scanner(System.in);

        try {
            int canh1 = scanner.nextInt();
            int canh2 = scanner.nextInt();
            int canh3 = scanner.nextInt();
            if (canh1 <= 0 || canh2 <= 0 || canh3 <= 0) {
                throw new IllegalTriangleException("Các cạnh phải lớn hơn 0!");
            }
            if (canh1 + canh2 <= canh3 || canh1 + canh3 <= canh2 || canh2 + canh3 <= canh1) {
                throw new IllegalTriangleException("Không đúng định dạng tam giác!");
            }
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai định dạng!");
        }
    }
}
