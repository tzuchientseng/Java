package array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
    int[] i = {10,20,30,40,50};
    // int[] i = {1,2,3,4,5};
    arrayArgs(i);
    intArgs(1,2);
    varArgs(1,2,3,4,5);
    varArgs(1,2,3); 
    varArgs(1,2,3,4,5,6,7);
    varArgs();
    requireAtLeastOneInput(1,2,3);
    requireAtLeastOneInput(1);
// requireAtLeastOneInput(); // compilation failed
}
private static void arrayArgs(int[] i){
    System.out.println(Arrays.toString(i));
}
private static void intArgs(int i, int j){
    System.out.println(i +", "+ j);
}
private static void varArgs(int... i){
    System.out.println(Arrays.toString(i));
}
    private static void requireAtLeastOneInput(int i, int... j){
    System.out.println(i + ", " + Arrays.toString(j));
}
}
