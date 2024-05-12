package function.vectorPractice;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            float x1 = 0, y1 = 0, z1 = 0;
            float x2 = 0, y2 = 0, z2 = 0;
            float a = 0, b = 0, c = 0, d = 0;

            System.out.println("Enter numbers in sequence (x, y, z)");
            System.out.println("The first vector:");
            x1 = scanner.nextFloat();
            y1 = scanner.nextFloat();
            z1 = scanner.nextFloat();
            System.out.println("Enter the second vector:");
            x2 = scanner.nextFloat();
            y2 = scanner.nextFloat();
            z2 = scanner.nextFloat();

            a = y1 * z2 - z1 * y2;
            b = z1 * x2 - x1 * z2;
            c = x1 * y2 - y1 * x2;
            d = x1 * x2 + y1 * y2 + z1 * z2;

            System.out.println("\n\nInner product: (" + x1 + "," + y1 + "," + z1 + ").(" + x2 + "," + y2 + "," + z2 + ") = " + d);
            System.out.println("Outer product: (" + x1 + "," + y1 + "," + z1 + ") x (" + x2 + "," + y2 + "," + z2 + ") = (" + a + "," + b + "," + c + ")");
            System.out.println("\n-----------------------------Next Assignment-----------------------------\n");
        }
    }
}
