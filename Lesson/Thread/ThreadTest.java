package Thread;
// public class ThreadTest {
//     public static void main(String[] args) throws Exception{
//         Thread t = new Foo();
//         t.start();
//         Thread.sleep(100000);
//     }
// }

// class Foo extends Thread{
//     public void run(){
//         System.out.println("Hi~");
//         try{
//             Thread.sleep(100000);
//         }catch(Exception e){};
//     }
// }

public class ThreadTest {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(new Foo());
        t.start();
        Thread.sleep(100000);
    }
}

class Foo implements Runnable{
    public void run(){
        System.out.println("Thread active~");
        try{
            Thread.sleep(100000);
        }catch(Exception e){};
    }
}
