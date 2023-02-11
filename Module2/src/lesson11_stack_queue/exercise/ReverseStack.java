package lesson11_stack_queue.exercise;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        // Mang so nguyen
        Stack<Integer> stackInts = new Stack<>();
        int[] arrInt = {1, 4, 0, 29, 7, 3};

        System.out.println("Mang ban dau: ");
        for (int i = 0; i < arrInt.length; i++) {
            System.out.print(arrInt[i] + ", ");
        }

        for (int i = 0; i < arrInt.length; i++) {
            stackInts.push(arrInt[i]);
        }
        System.out.println("\nMang sau khi dao nguoc: ");
        while (!stackInts.isEmpty())
        {
            System.out.print(stackInts.pop() + ", ");
        }


        // Mang String
        Stack<String> stackStrings = new Stack<>();
        String str = "Anh Tuan";
        String[] arrayStr=str.split(" ");
        System.out.println("Mang ban dau: ");
        for (int i = 0; i < arrayStr.length; i++) {
            System.out.print(arrayStr[i] + ", ");
        }

        for (int i = 0; i < arrayStr.length; i++) {
            stackStrings.push(arrayStr[i]);
        }
        System.out.println("\nMang sau khi dao nguoc: ");
        while (!stackStrings.isEmpty())
        {
            System.out.print(stackStrings.pop() + ", ");
        }
    }
}
