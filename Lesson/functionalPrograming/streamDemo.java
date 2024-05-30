package functionalPrograming;
import java.util.stream.*;

public class streamDemo {
    public static void main(String[] arg) {
    //METHOD REFERENCE  
    //1.Static Level (Often)
        System.out.println("-------static Level-------");
        Stream.of("Sunny", "Jason", "John mayer")
              .map(streamDemo::hi) 
              .forEach(n->System.out.println(n));
    //2.Lambda outter block (Object level)
        System.out.println("-------object Level-------");
        Foo f = new Foo();
        Stream.of("Sunny", "Jason", "John mayer")
              .map(f::hi) 
              .forEach(n->System.out.println(n));
    //3.Lambda outter block
        System.out.println("-------lambda(object level)-------");
        Stream.of("Sunny", "Jason", "John mayer")
              .map(String::toUpperCase) //No input String method, cause input is "Sunny", "Jason", "John mayer"
              .forEach(n->System.out.println(n));
        System.out.println("-------reduce-------");
        var s = Stream.of("a", "b", "c")
                      .reduce(String::concat); //Two inputs one out put Same type
        System.out.println(s);
    //4.Constructor
        System.out.println("-------constructor-------");
        Stream.of("Sunny", "Jason", "John mayer")
              .map(Foo2::new) //input string(stream) return itself (object)
              .forEach(o->System.out.println(o.hi()));
        System.out.println(new Foo2("--New name--"));
        System.out.println("-------Factory Method Pattern.(constructor factory method reference)-------");
        System.out.println("-------adding interface(4 type combine)-------");
        Bar b = Foo2::new; //Need interface
        Stream.of("Sunny", "Jason", "John mayer")
              .map(b::get) //outter lambda  
              .map(Foo2::hi) //inner lambda
              .forEach(System.out::println); //static
    }
    public static String hi(String name) {
        return "HI " + name;
    }
}
class Foo {
    public String hi(String name) {
        return "Hi " + name;
    }
}
class Foo2 {
    private String name;
    public Foo2(String name) {
        this.name = name;
        System.out.println("Constructor!!");
    }
    public Foo2(int i) {
        System.out.println("Overload!");
    }
    public String hi() {
        return "Hi " + this.name;
    }
}
interface Bar {
    Foo2 get(String name); //Any method name (Function) one input out itself(object)
}
/*
def hi(name):
    return "HI " + name

def main():
    names = ["Sunny", "Jason", "John mayer"]
    greetings = map(hi, names)
    for greeting in greetings:
        print(greeting)

if __name__ == "__main__":
    main()

 */
