package IO;
import java.io.*;

public class serializable {    
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        foo.setName("Sunny");
        foo.setAge(18);

        File f = new File("C:\\Users\\GOOD-PC\\Coding\\Java\\Lesson\\IO\\serializable.ser");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(foo);

        oos.close();
        fos.close();
    }
}

class Foo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
