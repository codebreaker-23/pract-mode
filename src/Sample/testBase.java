package Sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testBase {

    private final ExecutorService e;
    private Thread t1, t2;

    public testBase(){
        e = Executors.newFixedThreadPool(2);
    }

    public void d(){
        t1 = new Thread(() -> {
            System.out.println(System.currentTimeMillis() + " in d with t1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        t2 = new Thread(()->{
            System.out.println(System.currentTimeMillis() + " in d with t2");
        });
    }

    public void process(){
//        try{
            e.submit(t1);
            e.submit(t2);
//        }catch ()
            e.shutdown();
    }
}
