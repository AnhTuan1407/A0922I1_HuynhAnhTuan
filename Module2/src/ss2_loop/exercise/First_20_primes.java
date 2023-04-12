package Loop;

public class First_20_primes {
    public static void main(String[] args) {
        System.out.println("First 20 primes");
        int count = 0;
        int countPrime = 0;
        int n = 2;
        while (countPrime <= 20)
        {
            if (n == 2)
            {
                System.out.print(n + " ");
                countPrime++;
            }else {
                for (int i = 2; i <= Math.sqrt(n) ; i++) {
                    if (n % i == 0)
                    {
                        count++;
                    }
                }
                if (count == 0)
                {
                    System.out.print(n + " ");
                    countPrime++;
                }
                count = 0;
            }
            n++;
        }
    }
}
