public class Main {
    // Declare catJumpable as a class-level variable
    private static Jumpable catJumpable;

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.makeSound(); // Output: Cat meows.
        cat.eat(); // Output: Animal is eating.
        Animal.sleep(); // Output: Animal is sleeping.

        // Initialize catJumpable outside the main method
        catJumpable = new Cat();
        catJumpable.jump(); // Output: Cat is jumping.
        catJumpable.run(); // Output: Jumpable is running.
        Jumpable.stop(); // Output: Jumpable is stopping.
        catJumpable.callPrivateMethod(); // Output: This is a private method in Jumpable interface.
    }
}

interface Animal {
    void makeSound();
    default void eat() {
       System.out.println("Animal is eating.");
    }
    static void sleep() {
        System.out.println("Animal is sleeping.");
    }
    private void privateMethod() {
      System.out.println("This is a private method in Animal interface.");
    }
    default void callPrivateMethod() {
     privateMethod();
    }
}
interface Jumpable {
    void jump();
    default void run() {
        System.out.println("Jumpable is running.");
    }
    static void stop() {
        System.out.println("Jumpable is stopping.");
    }
    private void privateMethod() {
        System.out.println("This is a private method in Jumpable interface.");
    }
    default void callPrivateMethod() {
        privateMethod();
}
}
class Cat implements Animal, Jumpable {
    @Override
    public void makeSound() {
    System.out.println("Cat meows.");
    }
    @Override
    public void jump() {
    System.out.println("Cat is jumping.");
    }
    @Override
    public void callPrivateMethod() {
        Animal.super.callPrivateMethod();
        Jumpable.super.callPrivateMethod();
    }
}

