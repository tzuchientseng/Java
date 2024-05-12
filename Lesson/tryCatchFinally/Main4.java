// Try with Resources (Automatic Resource Management)
public class Main4 {
    public static void main(String[] args) {
        {// Earlier approach
            var r = new MyResource();
            try {  // Resource will be closed upon exiting the try block
                r.doSomething();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (r != null) {
                    r.close();                
                }
            }
        }
        {  // Modern approach
            var resource = new MyResource();
            try (resource) {
                resource.doSomething();
            }
        }
    }
}

class MyResource implements AutoCloseable {
    public MyResource() {
        System.out.println("init");
    }

    public void doSomething() {
        System.out.println("execute");
    }

    public void close() {
        System.out.println("close");
    }
}
