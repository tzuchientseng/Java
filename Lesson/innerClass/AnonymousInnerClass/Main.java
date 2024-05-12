package innerClass.AnonymousInnerClass;

public class Main{
    interface HelloWorld{
        void greet(String name);
    }

public static void main(String[] args){
    HelloWorld englisGreeting = new HelloWorld(){
        public void greet(String name) {
            System.out.println("Hello, "+ name + "!");
        };
    };
    say("John", englisGreeting); //Hello, Hohn!

    say("Jean", new HelloWorld() {
        public void greet (String name) {
            System.out.println("Bonjour, " + name + "!");

        }
    }); //Bonjour, Jean!
    }

    private static void say(String name, HelloWorld o ) {
        o.greet(name);
    }

}