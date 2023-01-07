package furama_project;

import java.util.ArrayList;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> students = new ArrayList<String>();
        int n;
        do {
            System.out.println("Nhap so luong hoc vien: ");
            n = scanner.nextInt();
            scanner.nextLine();
            if (n > 10)
            {
                System.out.println("Loi! Nhap lai!");
            }
        }while (n > 10);

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap hoc vien " + (i + 1) + ": ");
            String name = scanner.nextLine();
            students.add(name);
        }
        System.out.println("Danh sach hoc vien");
        for (int i = 0; i < n; i++) {
            System.out.println(students.get(i));
        }
    }
}
