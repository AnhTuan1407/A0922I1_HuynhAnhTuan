package Array;

import java.util.Scanner;
public class Count_Characters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String str = scanner.nextLine();
        System.out.println("Enter character you want to count: ");
        String c = scanner.next();
//        char[] ch = str.toCharArray();
        int count  = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c.charAt(0))
            {
                count++;
            }
        }
        System.out.println(str);
        System.out.println("The number of occurrences of element " + c + " in the string is: " + count);
    }
}
