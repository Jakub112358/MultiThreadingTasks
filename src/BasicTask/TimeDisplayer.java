package BasicTask;


import java.time.LocalTime;
import java.time.temporal.ChronoUnit;


public class TimeDisplayer implements Runnable {
    private LocalTime lastTime;
    private int numberOfExecutions;
    private double averageTimeBetweenExecutions;

    public TimeDisplayer() {
        this.lastTime = LocalTime.now().minusSeconds(1);
    }

    @Override
    public void run() {
        numberOfExecutions++;
        LocalTime actualTime = LocalTime.now();
        averageTimeBetweenExecutions = (averageTimeBetweenExecutions*(numberOfExecutions-1)+lastTime.until(actualTime, ChronoUnit.NANOS))/numberOfExecutions;
        System.out.println("METHOD 1: average time between executions: " + averageTimeBetweenExecutions + " actual time: " + actualTime);
        lastTime = actualTime;
    }
}
