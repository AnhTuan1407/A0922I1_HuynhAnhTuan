package lesson11_stack_queue.optional.exercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        Stack stack = new Stack<>();
        Queue queue = new LinkedList<>();

        System.out.println("Enter str: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.offer(str.charAt(i));
        }

        int count = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.remove()) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}
