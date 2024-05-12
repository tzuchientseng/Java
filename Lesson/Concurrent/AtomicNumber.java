package Concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicNumber {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(5);
        if (i.compareAndSet(5, 30)) {
            System.out.println("compareAndSet() " + i);
        }
        i.getAndIncrement();
        System.out.println("getAndIncrement() " + i);
    }
}
