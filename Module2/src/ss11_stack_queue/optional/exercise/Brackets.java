package lesson11_stack_queue.optional.exercise;

import java.util.Scanner;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        Stack bStack = new Stack();
        System.out.println("Enter str: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                bStack.push(str.charAt(i));
            } else if (str.charAt(i) == ')' && !bStack.isEmpty()) {
                bStack.pop();
            } else if (str.charAt(i) == ')' && bStack.isEmpty()) {
                bStack.push(str.charAt(i));
            }
        }
        if (!bStack.isEmpty()) {
            System.out.println("False");
        } else {
            System.out.println("True");
        }
    }
}
