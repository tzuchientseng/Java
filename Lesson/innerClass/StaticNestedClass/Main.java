package innerClass.StaticNestedClass;

public class Main {
    private static int x = 10;

    static class InnerClass {
        public void display() {
            System.out.println("value of x in outer class is: "  + x );
            System.out.println("value of x in outer class is: "  + Main.x );
        }
    }

    public static void main(String[] args){
        Main.InnerClass inner = new Main.InnerClass();        
        inner.display();
        System.out.println("inner ref: " + inner);
    }
}
