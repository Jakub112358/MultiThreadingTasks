package BasicTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Podst.
//Zad.10 Zaplanuj zadanie, które wykonuje się raz na sekundę.
public class Task10 {
    public static void main(String[] args) {

        //attempt 1: using ScheduledExecutorService and scheduleAtFixedRate method:
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        TimeDisplayer timeDisplayer = new TimeDisplayer();
        scheduledExecutorService.scheduleAtFixedRate(timeDisplayer,0,1,TimeUnit.SECONDS);


        //attempt 2: using Thread.sleep method: (doesn't work well)
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        TimeDisplayerWithSleep timeDisplayerWithSleep = new TimeDisplayerWithSleep();
        while(true){
            executorService.execute(timeDisplayerWithSleep);
        }

        

    }
}
