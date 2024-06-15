package com.dipanjal.ocp.practiece.chapter14;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @author dipanjal
 * @since 4/22/2021
 */

public class ThreadingExample {
    public static void yield(String str){
        System.out.println(String.format("%s - %s", str, LocalDateTime.now()));
    }


    private static Runnable getRunnable(){
        return () -> {
            Thread ct = Thread.currentThread();
//            ct.setName(threadName);
            ct.setPriority(Thread.MAX_PRIORITY);
            while(!ct.isInterrupted()){
                yield(ct.getName()+" Start");
                try {
                    yield(ct.getName()+" Going to Sleep");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return; //terminating the thread;
                }
            }
        };
    }

    private static void runAsDemonThread(Optional<Thread> threadOptional){
        threadOptional.ifPresent(thread -> {
            thread.setDaemon(true);
            thread.start();
        });
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(getRunnable(), "Thread 1");
        Thread t2 = new Thread(getRunnable(), "Thread 2");
        Thread watchMan = new Thread(() -> {
            while(t1.isAlive() || t2.isAlive()){
                System.out.println("T1 state "+t1.getState());
                System.out.println("T2 state "+t2.getState());
                try {
                    Thread.sleep(1000); //TIMED_WAITING
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("T1 state "+t1.getState());
            System.out.println("T2 state "+t2.getState());
        });

        System.out.println("T1 state "+t1.getState());
        System.out.println("T2 state "+t2.getState());

        watchMan.start();
        /*t1.start();
        t2.start();*/

        runAsDemonThread(Optional.ofNullable(t1));
//        runAsDemonThread(Optional.ofNullable(t2));
        t2.start();

        Thread.sleep(5000);
        t1.interrupt();
//        return;



/*        while(true){
            System.out.println("T1 state "+t1.getState());
            System.out.println("T2 state "+t2.getState());
        }*/


    }
}
