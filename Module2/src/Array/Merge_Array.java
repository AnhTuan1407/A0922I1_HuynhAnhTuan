package Array;

import java.util.Scanner;

public class Merge_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array1 = new int[5];
        int[] array2 = new int[5];
        int[] array3 = new int[10];
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Enter element array1[" + (i + 1) + "]: ");
            array1[i] = scanner.nextInt();
        }
        System.out.println("Array1: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
        }

        System.out.println("");
        for (int j = 0; j < array2.length; j++) {
            System.out.println("Enter element array2[" + (j + 1) + "]: ");
            array2[j] = scanner.nextInt();
        }
        System.out.println("Array2: ");
        for (int j = 0; j < array2.length; j++) {
            System.out.print(array2[j] + " ");
        }

        for (int k = 0; k < array1.length; k++) {
            array3[k] = array1[k];
        }
        for (int k = 0; k < array2.length; k++) {
            array3[array1.length + k] = array2[k];
        }
        System.out.println("");
        System.out.println("Array3: ");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + " ");
        }
    }
}
