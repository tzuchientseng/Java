import java.util.*;
import java.util.function.*;

public class Test {
    public static void main(String[] args) {
        var s = Optional.ofNullable("zz");
        
        if (s.isPresent()) {
            System.out.println(s.get());
        }

        s.ifPresent(new Consumer<String>() {
            public void accept(String s) {
                System.out.println("AAA " + s);
            }
        });
    }
}
