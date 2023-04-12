package lesson11_stack_queue.optional.exercise;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Decimal: ");
        int decimal = scanner.nextInt();

        int temp = decimal;
        while (temp != 0) {
            stack.push(temp % 2);
            temp /= 2;
        }
        System.out.println("Binary: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
