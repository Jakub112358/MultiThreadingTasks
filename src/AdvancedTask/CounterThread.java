package AdvancedTask;

public class CounterThread extends Thread {
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            Counter.inc();
            System.out.println(this.getName() + ": " + Counter.getCounter());
        }
    }


}
