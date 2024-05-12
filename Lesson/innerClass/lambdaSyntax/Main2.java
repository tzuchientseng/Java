package innerClass.lambdaSyntax;

public class Main2 {
@FunctionalInterface
    interface HelloWorld{
        void greet(String name);
    }

    public static void main(String[] args){
        HelloWorld englisGreeting = (name)->{
                System.out.println("Hello, "+ name + "!");
            };
        say("John", englisGreeting); //Hello, Hohn!

        say("Jean", name -> System.out.println("Bonjour, " + name + "!")); //Bonjour, Jean!
        }

    private static void say(String name, HelloWorld o ) {
        o.greet(name);
    }

}
