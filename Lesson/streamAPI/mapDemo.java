package streamAPI;
import java.util.stream.*;;

public class mapDemo {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5) //input int
              .map(i->String.valueOf(i))
              .forEach(s->System.out.print(s + " ")); //out string
            //   .forEach(t->System.out.println(t.getClass()));
    } 
}
