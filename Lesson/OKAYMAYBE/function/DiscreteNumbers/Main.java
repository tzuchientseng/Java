package function.DiscreteNumbers;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter two values of the Combinations(n,k):");
            int n = 0, k = 0;
            System.out.print("n = "); n = scanner.nextInt();
            System.out.print("k = "); k = scanner.nextInt();

            if (n - k < 0) {
                System.out.println("RuntimeException: Defined that n >= k");
            } else {
                System.out.println("\nP(" + n + "," + k + ") = " + combinations(n, k) * factorial(k));
                System.out.println("C(" + n + "," + k + ") = " + combinations(n, k));
                System.out.println("H(" + n + "," + k + ") = " + combinations(n + k - 1, k));
                System.out.println("\n--------------Next Assignment--------------\n");
            }
        }
    }

    private static long combinations(long a, long b) {
        long d = 0, N = 0, K = 0, numerator = 1, denominator = 1;
        // Residue Theorem C(a,b)->C(N,K)
        d = a - b;  N = a;  K = b;  K = Math.min(d, K);
        
        while(K>0)
        {
            long x=0, y=0, GCD=0;
             x=N/gcd(N,K);
             y=K/gcd(N,K);
             numerator*=x;
             denominator*=y;
             N-=1;
             K-=1;
             GCD=gcd(numerator,denominator); //Simplified the fraction
             numerator/=GCD; //In fact, the combinations is numerator cause the denominator is "1".
             denominator/=GCD; //denominator=1;
       }
       return  numerator;
    }

    private static long gcd(long a, long b) {
        long i;
        while (b != 0) {
        // Euclidean algorithm
            i = b;
            b = a % b;
            a = i;
        }
        return a;
    }

    private static long factorial(long a) {
        long i = 1;
        while (a != 0) {
            i *= a;
            a--;
        }
        return i;
    }
}