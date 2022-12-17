package Introduction_Java;

import java.util.Scanner;

public class Read_Number {
    public static void main(String[] args) {
        int num;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter number: ");
            num = scanner.nextInt();
            if (num > 999)
            {
                System.out.println("Number is too large. Please re-enter!");
            }
        }while (num > 999);

        int temp1 = num;
        int temp2 = num;
        if (num <= 10) {
            switch (num) {
                case 0: {
                    System.out.println("Zero");
                    break;
                }

                case 1: {
                    System.out.println("One");
                    break;
                }

                case 2: {
                    System.out.println("Two");
                    break;
                }

                case 3: {
                    System.out.println("Three");
                    break;
                }

                case 4: {
                    System.out.println("Four");
                    break;
                }

                case 5: {
                    System.out.println("Five");
                    break;
                }

                case 6: {
                    System.out.println("Six");
                    break;
                }

                case 7: {
                    System.out.println("Seven");
                    break;
                }

                case 8: {
                    System.out.println("Eight");
                    break;
                }

                case 9: {
                    System.out.println("Nine");
                    break;
                }

                case 10: {
                    System.out.println("Ten");
                    break;
                }
            }
        } else if (num > 10 && num < 20) {
            int tens = temp1 % 10;
            switch (tens) {
                case 1: {
                    System.out.println("Eleven");
                    break;
                }

                case 2: {
                    System.out.println("Twelve");
                    break;
                }

                case 3: {
                    System.out.println("ThirdTeen");
                    break;
                }

                case 4: {
                    System.out.println("FourthTeen");
                    break;
                }

                case 5: {
                    System.out.println("Fifteen");
                    break;
                }

                case 6: {
                    System.out.println("SixTeen");
                    break;
                }

                case 7: {
                    System.out.println("SevenTeen");
                    break;
                }

                case 8: {
                    System.out.println("EightTeen");
                    break;
                }

                case 9: {
                    System.out.println("NineTeen");
                    break;
                }
            }
        } else if (num >= 20) {
            int unit = temp2 % 10;
            temp2 = temp2 / 10;
            int dozen = temp2 % 10;
            temp2 = temp2 / 10;
            int hundred = temp2;
            String str1 = null, str2 = null, str3 = null;
            switch (hundred) {
                case 1: {
                    str1 = "One Hundred";
                    break;
                }

                case 2: {
                    str1 = "Two Hundred";
                    break;
                }

                case 3: {
                    str1 = "Three Hundred";
                    break;
                }

                case 4: {
                    str1 = "Four Hundred";
                    break;
                }

                case 5: {
                    str1 = "Five Hundred";
                    break;
                }

                case 6: {
                    str1 = "Six Hundred";
                    break;
                }

                case 7: {
                    str1 = "Seven Hundred";
                    break;
                }

                case 8: {
                    str1 = "Eight Hundred";
                    break;
                }

                case 9: {
                    str1 = "Nine Hundred";
                    break;
                }
            }

            switch (dozen) {
                case 1: {
                    str2 = "Ten";
                    break;
                }

                case 2: {
                    str2 = "Twenty";
                    break;
                }

                case 3: {
                    str2 = "Thirty";
                    break;
                }

                case 4: {
                    str2 = "Forty";
                    break;
                }

                case 5: {
                    str2 = "Fifty";
                    break;
                }

                case 6: {
                    str2 = "Sixty";
                    break;
                }

                case 7: {
                    str2 = "Seventy";
                    break;
                }

                case 8: {
                    str2 = "Eighty";
                    break;
                }

                case 9: {
                    str2 = "Ninety";
                    break;
                }
            }

            switch (unit) {
                case 1: {
                    str3 = "One";
                    break;
                }

                case 2: {
                    str3 = "Two";
                    break;
                }

                case 3: {
                    str3 = "Three";
                    break;
                }

                case 4: {
                    str3 = "Four";
                    break;
                }

                case 5: {
                    str3 = "Five";
                    break;
                }

                case 6: {
                    str3 = "Six";
                    break;
                }

                case 7: {
                    str3 = "Seven";
                    break;
                }

                case 8: {
                    str3 = "Eight";
                    break;
                }

                case 9: {
                    str3 = "Nine";
                    break;
                }
            }
            String str;
            if (str2 != null && str3 != null) {
                str = str1 + " " + str2 + " " + str3;
            } else if (str2 == null && str3 == null) {
                str = str1;
            } else {
                str = str1 + " " + str2;
            }

            System.out.println(str);
        }
    }
}
