import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a tool (mean, vector, line, pch).");
            return;
        }
        Kits o = Kits.valueOf(args[0]);
        //var o = Kits.valueOf(args[0]);
        run(o);
    }

    private static void run(Kits e) {
        e.apply();
    }
}

enum Kits {
    mean(new Mean()),
    vector(new Vector()),
    line(new SimultaneousEquations()),
    pch(new DiscreteNumbers());

    private MathOperation method;

    private Kits(MathOperation method) {
        this.method = method;
    }

    public void apply() {
        this.method.apply();
    }
}

interface MathOperation {
    void apply();
}

class Mean implements MathOperation {
    Scanner s = new Scanner(System.in);

    public void apply() {
        while (true) {
            System.out.println("How many values: ");
            double count = s.nextDouble();
            System.out.println("Enter the values: ");
            double sum = 0;
            for (int i = 1; i <= count; i++) {
                sum += s.nextDouble();
            }
            double ans = sum / count;
            System.out.println("Average is: " + ans);
            System.out.println("\n--------------Next Assignment--------------\n");
        }
    }
}

class Vector implements MathOperation {
    Scanner s = new Scanner(System.in);
    
    public void apply() {
        while (true) {
            double x1, y1, z1;
            double x2, y2, z2;
            double a, b, c, d;
            
            System.out.println("Enter the values in sequence (x, y, z)");
            System.out.println("The first vector:");
            x1 = s.nextDouble();
            y1 = s.nextDouble();
            z1 = s.nextDouble();
            
            System.out.println("Enter the second vector:");
            x2 = s.nextDouble();
            y2 = s.nextDouble();
            z2 = s.nextDouble();
            
            a = y1 * z2 - z1 * y2;
            b = z1 * x2 - x1 * z2;
            c = x1 * y2 - y1 * x2;
            d = x1 * x2 + y1 * y2 + z1 * z2;
            
            System.out.println("\n\nInner product: (" + x1 + "," + y1 + "," + z1 + ") . (" + x2 + "," + y2 + "," + z2 + ") = " + d);
            System.out.println("Outer product: (" + x1 + "," + y1 + "," + z1 + ") x (" + x2 + "," + y2 + "," + z2 + ") = (" + a + "," + b + "," + c + ")");
            System.out.println("\n--------------Next Assignment--------------\n");
        }
    }
}

class SimultaneousEquations implements MathOperation {
    Scanner s = new Scanner(System.in);
    public void apply() {
        while (true) {
            double x1, y1, z1;
            double x2, y2, z2;
            System.out.println("Line1: ax+by=c");
            System.out.println("Enter the values in sequence (a, b, c)");
            x1 = s.nextDouble();
            y1 = s.nextDouble();
            z1 = s.nextDouble();
            System.out.println("Line1: "+x1+" x + "+y1+" y = "+z1+";");
            System.out.println("\nLine2: kx+qy=j;");
            System.out.println("Enter the values in sequence (k, q, j)");
            x2 = s.nextDouble();
            y2 = s.nextDouble();
            z2 = s.nextDouble();
            Line l1 = new Line(x1,y1,z1);
            Line l2 = new Line(x2,y2,z2);
            double X = solForX(l1, l2);
            double Y = solForY(l1, l2);
            System.out.println("\npoint coordinates: (" + X + "," + Y + ")");
            System.out.println("\n--------------Next Assignment--------------\n");
        }
    }
    private double solForX(Line l1, Line l2) {
        return (l1.getz() * l2.gety() - l1.gety() * l2.getz()) / (l1.getx() * l2.gety() - l1.gety() * l2.getx());
    }

    private double solForY(Line l1, Line l2) {
        return (l1.getx() * l2.getz() - l1.getz() * l2.getx()) / (l1.getx() * l2.gety() - l1.gety() * l2.getx());
    }
    class Line {
        private double x;
        private double y;
        private double z;
        public Line(double a, double b, double c) {
            this.x = a;
            this.y = b;
            this.z = c;
        }
        public double getx() {
            return this.x;
        }
        public double gety() {
            return this.y;
        }
        public double getz() {
            return this.z;
        }
    }
}

class DiscreteNumbers implements MathOperation{
    Scanner s = new Scanner(System.in);
    public void apply() {
        while (true) {
            System.out.println("Enter two values of the Combinations(n,k):");
            int n = 0, k = 0;
            System.out.print("n = "); n = s.nextInt();
            System.out.print("k = "); k = s.nextInt();

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