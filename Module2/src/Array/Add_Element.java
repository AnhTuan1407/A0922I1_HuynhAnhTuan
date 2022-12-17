package Array;

import java.util.Scanner;

public class Add_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0, 0};

        System.out.println("Enter index you want to add element: ");
        int x = scanner.nextInt();

        System.out.println("Enter element you want to add: ");
        int num = scanner.nextInt();

        if (x <= 1 || x >= array.length - 1) {
            System.out.println("Unable to add!");
        } else {
            for (int i = array.length - 1; i > x; i--) {
                array[i] = array[i - 1];
            }
            array[x] = num;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + " ");
        }
    }
}

