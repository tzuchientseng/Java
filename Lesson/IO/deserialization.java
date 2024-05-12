package IO;

import java.io.*;
public class deserialization {
    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Users\\GOOD-PC\\Coding\\Java\\Lesson\\IO\\deserialization.ser");
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Foo foo = (Foo) ois.readObject(); //retrun object 要轉型

        ois.close();
        fis.close();

        System.out.println(foo.getName());
        System.out.println(foo.getAge());
    }
}

class Foo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private transient int age; //預設0 因為transient 所以不會顯示原本值

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
}
