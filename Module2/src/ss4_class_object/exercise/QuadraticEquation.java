package Lession4_Class_Object;

import java.util.Scanner;

public class Quadratic_Equation {
    public float hsBac1;
    public float hsBac0;
    public float hsBac2;

    public Quadratic_Equation() {
    }

    public Quadratic_Equation(float hsBac1, float hsBac0, float hsBac2) {
        this.hsBac1 = hsBac1;
        this.hsBac0 = hsBac0;
        this.hsBac2 = hsBac2;
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap he so bac 2: ");
        hsBac2 = scanner.nextFloat();
        System.out.println("Nhap he so bac 1: ");
        hsBac1 = scanner.nextFloat();
        System.out.println("Nhap he so bac 0: ");
        hsBac0 = scanner.nextFloat();
    }

    public void giaiPTBac2() {
        if (hsBac2 == 0) {
            System.out.println("Day la phuong trinh bac 1!");
            if (hsBac1 == 0 && hsBac0 != 0) {
                System.out.println("Phuong trinh vo nghiem!");
            } else if (hsBac1 == 0 && hsBac0 == 0) {
                System.out.println("Phuong trinh vo so nghiem!");
            } else {
                System.out.println("Phuong trinh co nghiem duy nhat: " + (-hsBac0 / hsBac1));
            }
        } else {
            float delta = hsBac1 * hsBac1 - 4 * (hsBac2 * hsBac0);
            if (delta > 0) {
                System.out.println("Phuong trinh co 2 nghiem phan biet!");
                System.out.println("x1: " + (-hsBac1 + Math.sqrt(delta)) / 2 * hsBac2);
                System.out.println("x2: " + (-hsBac1 - Math.sqrt(delta)) / 2 * hsBac2);
            } else if (delta == 0) {
                System.out.println("Phuong trinh co nghiem kep!");
                System.out.println("x1 = x2 : " + (-hsBac1 / (2 * hsBac2)));
            } else {
                System.out.println("Phuong trinh vo nghiem!");
            }
        }
    }

    public static void main(String[] args) {
        Quadratic_Equation_Extends.PhuongTrinhBac2 e = new Quadratic_Equation_Extends.PhuongTrinhBac2();
        e.nhap();
        e.giaiPTBac2();
    }
}
