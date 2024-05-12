import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentReadWriteLockTest {
    public static void main(String[] args) {
        Foo f = new Foo();
        new Thread(() -> {
            for(int i=0; i<10; i++) {
                f.bar1();
            }
        }).start();
        new Thread(() -> {
            for(int i=0; i<10; i++) {
                f.bar2();
            }
        }).start();
    }
}

class Foo {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    public void bar1() {
        lock.readLock().lock();
        System.out.println("read lock");
        try{Thread.sleep(1000);}catch(Exception e){}
        lock.readLock().unlock();
        System.out.println("read unlock");
    }
    public void bar2() {
        lock.writeLock().lock();
        System.out.println("write lock");
        try{Thread.sleep(3000);}catch(Exception e){}
        lock.writeLock().unlock();
        System.out.println("write unlock");
    }
}
