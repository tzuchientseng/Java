public class Main {
    private static final int HAS_A = 0b0001;
    private static final int HAS_B = 0b0010;
    private static final int HAS_C = 0b0100;
    private static final int HAS_D = 0b1000;

    public static void main(String[] args) {
        byte a = (byte) 0b10101010;
        System.out.println("~170: " + Integer.toBinaryString(~a));
        System.out.println("5&3: " + (5 & 3));
        System.out.println("5|3: " + (5 | 3));
        System.out.println("5^3: " + (5 ^ 3));
        System.out.println("5<<2: " + (5 << 2));
        System.out.println("-86>>2: " + (-86 >> 2));
        System.out.println("-86>>>2: " + (-86 >>> 2));

        int flag = HAS_A | HAS_C; // Set flags A and C
        execute(flag);
    }

    private static void execute(int flag) {
        if ((flag & HAS_A) != 0) {
            System.out.println("A function");
        }
        if ((flag & HAS_B) != 0) {
            System.out.println("B function");
        }
        if ((flag & HAS_C) != 0) {
            System.out.println("C function");
        }
        if ((flag & HAS_D) != 0) {
            System.out.println("D function");
        }
    }
}
