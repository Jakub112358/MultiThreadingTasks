package AdvancedTask;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Zadanie 10
//Napisz klasę wątku, która będzie wielokrotnie wywoływać metodę inc() w obiekcie typu Counter.
// Obiekt powinien być współdzieloną zmienną globalną. Utwórz kilka wątków,
// uruchom je wszystkie i poczekaj na zakończenie wszystkich wątków.
// Wydrukuj ostateczną wartość licznika i sprawdź, czy jest poprawna.
public class Task10 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            CounterThread counterThread = new CounterThread();
            counterThread.setName(String.valueOf(i));
            executorService.execute(counterThread);
        }
        executorService.shutdown();

        // this loop is to wait until all threads are terminated
        while (!executorService.isTerminated()) {
        }

        System.out.println("final value of counter equals: " + Counter.getCounter() + ", expected value: 100");


    }
}
