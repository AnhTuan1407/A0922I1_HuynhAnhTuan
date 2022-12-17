package Loop;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Prime numbers less than 100");
        int n = 2;
        int count = 0;
        while (n <= 100) {
            if (n == 2) {
                System.out.print(n + " ");
            } else {
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.print(n + " ");
                }
                count = 0;
            }
            n++;
        }
    }
}
