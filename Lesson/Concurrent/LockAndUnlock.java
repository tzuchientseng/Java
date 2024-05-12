package Concurrent;
import java.util.concurrent.locks.*;

public class LockAndUnlock{
  public static void main(String[] args){
    Foo f = new Foo();
    new Thread(()->{
      for(int i=0; i<10; i++){
        f.bar1();
      }
    }, "T1").start();
    new Thread(()->{
      for(int i=0; i<10; i++){
        f.bar1();
      }
    }, "T2").start();
  }
}

class Foo{
  private final ReentrantLock lock = new ReentrantLock(true);
  public void bar1(){
    String name = Thread.currentThread().getName();
    lock.lock();
    System.out.println(name+ " lock");
    try{Thread.sleep(1000);}catch(Exception e){}
    lock.unlock();
    System.out.println(name+ " unlock");
  }
}
