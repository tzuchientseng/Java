package innerClass.MemberInnerClass;

public class Main {
    private int x = 10;

    class InnerClass {
        public void display() {
            System.out.println("value of x in outer class is: "  + x );
            System.out.println("value of x in outer class is: "  + Main.this.x );
            System.out.println("inner main.this: "  + Main.this );
        }
    }

    public static void main(String[] args){
        Main outer = new Main();
        Main.InnerClass inner = outer.new InnerClass();
        
        var a = new Main().new InnerClass();

        inner.display();
        System.out.println("outer ref: " + outer);
        System.out.println("inner ref: " + inner);
    }
}
