package functionalPrograming;
public class Recursive {
    public static void main(String[] args) {
        var sum = 0;
        for (int i = 0; i < 11; i++){
           sum += i; 
        }
        System.out.println(sum);
        System.out.println(sum(0, 10));
    }
    private static int sum(final int s,final int e) {
       return e == 0 ? s : sum(s + e, e-1);
    }
}