package AdvancedTask;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {


    //AtomicInteger prevents the situation, when more than one thread are incrementing value in the same time
    //Tests showed, that commented, incorrect option with primite int gives results in range from 98 to 100
    private static AtomicInteger counter = new AtomicInteger(0);
//    private static int counter = 0;

    public static void inc(){
        counter.incrementAndGet();
    }
//    public static void inc(){
//        counter++;
//    }

    public static int getCounter() {
        return counter.get();
    }

//    public static int getCounter() {
//        return counter;
//    }
}
