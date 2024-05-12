package innerClass.lambdaSyntax;

public class Main {
@FunctionalInterface
    interface  HelloWorld {
        void greet();
    }

    public static void main(String[] args) {

        HelloWorld frenchGreeting = new HelloWorld() {
        @Override
            public void greet(){
                System.out.println("Bonjour Le monde !"); 
            }
                        
        };
        say(frenchGreeting);

        HelloWorld frenchGreeting2 = ()->System.out.println("Bonjour Le monde !~~(lambda)");
        say(frenchGreeting2);


        say (new HelloWorld(){ 
            public void greet(){
                System.out.println("Hello~"); }
            });

        say(()->System.out.println("Hello~(lambda)"));
    }

    public static void say(HelloWorld o) {
        o.greet();
    }


}
