package Th;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class impl {

    public static void main(String[] args) {
        Queue<Runnable> runQ = new LinkedList<>();
        System.out.println(Thread.currentThread().getName());

        ExecutorService exec = Executors.newFixedThreadPool(5);
        runQ.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1 with " + Thread.currentThread().getName());
                System.out.println(System.currentTimeMillis());
                try{
//                    Thread.sleep(5000);
                }catch (Exception e){}
            }
        });
        runQ.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable2 with " + Thread.currentThread().getName());
                System.out.println(System.currentTimeMillis());
            }
        });
        runQ.add(new t11());

        while(!runQ.isEmpty()){
            exec.submit(runQ.poll());
        }
    }

}

class t11 implements Runnable{

    @Override
    public void run() {
        System.out.println("runnable t11 with "+ Thread.currentThread().getName());
        System.out.println(System.currentTimeMillis());
    }
}

class t12 extends Thread{
    public void run(){
    }
}
