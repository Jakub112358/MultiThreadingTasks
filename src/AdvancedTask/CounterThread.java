package AdvancedTask;

import java.util.concurrent.CountDownLatch;

public class CounterThread extends Thread {
    private final CountDownLatch countDownLatch;

    public CounterThread (CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            Counter.inc();
            System.out.println(this.getName() + ": " + Counter.getCounter());
        }
        countDownLatch.countDown();
    }


}
