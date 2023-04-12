package Array;

import java.util.Scanner;

public class Sum_Numbers_In_Column {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter m: ");
        int m = scanner.nextInt();
        System.out.println("Enter n: ");
        int n = scanner.nextInt();
        int[][] array = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter element [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Matrix: ");
        for (int i = 0; i < m; i++) {
            System.out.println("");
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
            }
        }

        int column;
        do {
            System.out.println("Enter the column you want to calculate: ");
            column = scanner.nextInt();
            if (column < 0 || column > m - 1) {
                System.out.println("Error!");
            }
        } while (column < 0 || column > m - 1);

        int sum = 0;
        int line = 0;
        while (line < m) {
            sum = sum + array[column][line];
            line++;
        }
        System.out.println(sum);
    }
}
