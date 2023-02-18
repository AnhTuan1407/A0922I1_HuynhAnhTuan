package lesson13_search_algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LongestString {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();

        System.out.println("Enter str: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int temp = 0;
        arrayList1.add(String.valueOf(str.charAt(0)));
        for (int i = temp + 1; i < str.length(); i++) {
            if (str.charAt(temp) < str.charAt(i)) {
                arrayList1.add(String.valueOf(str.charAt(i)));
                temp++;
            } else {
                temp = temp + 2;
            }

        }
        System.out.println(arrayList1);
    }
}
