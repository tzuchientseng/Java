package functionalPrograming;

public class lambda {
    public static void main(String[] args) {
        final var s = bar("AAA", n->"Hi~"+n);
        System.out.println(s);
    }
    private static String bar(final String name, final Foo f) {
        return f.hi2("BBB", name);
    }
}

interface Foo {
    public String hi (String name);
    public default String hi2 (String a, String b) {
        return a + " " + b;
    }
}
