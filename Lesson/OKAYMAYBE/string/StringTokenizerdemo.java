import java.util.*;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        StringTokenizer s = new StringTokenizer("A 1, B 2, C 3", ", ");
        while (s.hasMoreElements()) {
            String s1 = (String) s.nextElement();
            System.out.println(s1);
        }

        StringJoiner j = new StringJoiner(",");
        j.add("a")
         .add("b")
         .add("c");
        System.out.println(j);
    }
}
