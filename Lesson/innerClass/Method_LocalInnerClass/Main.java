package innerClass.Method_LocalInnerClass;

public class Main {
    private int x = 10;
    private void someMethod(){
        class InnerClass {
            public void display() {
                System.out.println("Value of x in outer class is: " + x);
                System.out.println("Value of x in outer class is: " + Main.this.x);
                System.out.println("inner Main.this: " + Main.this);
            }
        }
        var inner = new InnerClass();
        inner.display(); // Value of x in outer class is: 10
    }
    public static void main(String[] args){
        Main outer = new Main();
        outer.someMethod();
    }
}
