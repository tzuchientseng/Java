package Thread;
public class JoinThread{
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            for (int i=0; i<100; i++)
                System.out.println(name + "\t" + i);
            Thread.yield();
            for (int i=0; i<100; i++)
                System.out.println(name + "\t" + i);
        }, "T1");
        Thread t2 = new Thread(() -> {
            String name = Thread.currentThread().getName();
            for (int i=0; i<100; i++)
                System.out.println(name + "\t" + i);
            try{t1.join();}catch(Exception e){}
            for (int i=0; i<100; i++)
                System.out.println(name + "\t" + i);
        }, "T2");
        t1.start();
        t2.start();
    }
}
