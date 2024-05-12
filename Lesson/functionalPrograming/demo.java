package functionalPrograming;

public class demo {
    public static void main(String[] args) {
        final var s = bar("AAA", n->"Hi~"+n);
        System.out.println(s);
    }
    private static String bar(final String name, final Foo f) {
        return f.hi(name);
    }
}
interface Foo {
    public String hi (String name);
}
