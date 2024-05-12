public class StaticExample {
    static int classVariable = 0;  // Class variable

    int instanceVariable = 0;  // Instance variable

    // Class method
    static void classMethod() {
        System.out.println("This is a class method");
        // Class methods can only access class variables
        System.out.println("Class variable: " + classVariable);
        // The following line will result in a compilation error because class methods cannot access instance variables
        // System.out.println("Instance variable: " + instanceVariable);
    }

    // Instance method
    void instanceMethod() {
        System.out.println("This is an instance method");
        // Instance methods can access both instance variables and class variables
        System.out.println("Instance variable: " + instanceVariable);
        System.out.println("Class variable: " + classVariable);
    }

    public static void main(String[] args) {
        // Create an instance of the class
        StaticExample StaticexampleInstance = new StaticExample();

        // Call the class method
        StaticExample.classMethod();

        // Call the instance method
        StaticexampleInstance.instanceMethod();
    }
}
