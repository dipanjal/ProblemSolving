package com.dipanjal.ocp.practiece.chapter14;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author dipanjal
 * @since 4/22/2021
 */

public class ExecutorThreadExample {

    private static Runnable getRunnable(String label){
        return  () -> {
            Thread ct = Thread.currentThread();
            ct.setPriority(Thread.MAX_PRIORITY);
            ThreadingExample.yield(ct.getName()+" Start: "+ label);
        };
    }

    public static void main(String[] args) {

//        String 4name = "asdasd"; //invalid var name


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        // slot 1
//        executorService.scheduleAtFixedRate(getRunnable("File Download"), 2, 10, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(getRunnable("File Write"), 2, 5, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(getRunnable("Print Data"), 2, 3, TimeUnit.SECONDS);
//        // any of these 3 is done, executor will pick one from these tasks bellow
//        executorService.scheduleAtFixedRate(getRunnable("Network Call"), 2, 2, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(getRunnable("Send Email"), 2, 2, TimeUnit.SECONDS);

//        executorService.shutdown();
        // wont take these tasks
//        executorService.scheduleAtFixedRate(getRunnable("Make a coffee"), 1, 3, TimeUnit.SECONDS);
//        executorService.scheduleAtFixedRate(getRunnable("Serve the coffee"), 1, 5, TimeUnit.SECONDS);

        IntStream.range(0,5)
                .forEach(i -> {
                    System.out.println("Loop-count: "+i);
                    executorService.scheduleAtFixedRate(getRunnable("File Download"), 2, 10, TimeUnit.SECONDS);
                });

        try {
            //setting time_waited state
            if(!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }

    }

}
