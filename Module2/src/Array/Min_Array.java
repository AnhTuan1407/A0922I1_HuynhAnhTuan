package Array;

import java.util.Scanner;

public class Min_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of Array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter element [" + i + "]: ");
            array[i] = scanner.nextInt();
        }
        System.out.println("Array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        int min = array[0];
        for (int i = 0; i < n; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        System.out.println("Min: " + min);
    }
}

