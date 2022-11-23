package BasicTask;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeDisplayerWithSleep implements Runnable {
    private LocalTime lastTime;
    private int numberOfExecutions;
    private double averageTimeBetweenExecutions;

    public TimeDisplayerWithSleep() {
        this.lastTime = LocalTime.now().minusSeconds(1);
    }

    @Override
    public void run() {
        try {
            numberOfExecutions++;
            LocalTime actualTime = LocalTime.now();
            averageTimeBetweenExecutions = (averageTimeBetweenExecutions * (numberOfExecutions - 1) + lastTime.until(actualTime, ChronoUnit.NANOS)) / numberOfExecutions;
            System.out.println("METHOD 2: average time between executions: " + averageTimeBetweenExecutions + " actual time: " + actualTime);
            lastTime = actualTime;
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}