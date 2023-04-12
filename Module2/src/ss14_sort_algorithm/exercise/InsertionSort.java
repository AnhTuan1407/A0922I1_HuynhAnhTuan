package lesson14_sort_algorithm;

import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arrInt = new int[10];
        for (int i = 0; i < arrInt.length; i++) {
            int code = (int) Math.floor(((Math.random() * 99) + 10));
            arrInt[i] = code;
        }
        for (int c : arrInt) {
            System.out.print(c + " ");
        }

        System.out.println("SORT");
        int pos, x;
        for (int i = 1; i < arrInt.length; i++) {
            x = arrInt[i];
            pos = i;

            while (pos > 0 && x < arrInt[pos - 1]) {
                arrInt[pos] = arrInt[pos - 1];
                pos--;
            }
            arrInt[pos] = x;
        }

        for (int c : arrInt) {
            System.out.print(c + " ");
        }
    }
}
