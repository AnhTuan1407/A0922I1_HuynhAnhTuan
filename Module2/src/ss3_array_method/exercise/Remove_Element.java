package Array;

import java.util.Scanner;

public class Remove_Element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 4, 6, 7, 2, 8, 6, 1, 3, 0, 5, 2, 2};
        System.out.println("Enter element you want to remove: ");
        int x = scanner.nextInt();
        boolean check = true;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                check = false;
            }
        }

        if (check == true) {
            System.out.println("Not Found!");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
