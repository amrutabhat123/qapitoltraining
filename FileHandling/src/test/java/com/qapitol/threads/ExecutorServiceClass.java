package com.qapitol.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceClass {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the pool
        for (int i = 0; i < 5; i++) {
            executor.submit(new RunnableTask(i));
        }

        // Shut down the executor
        executor.shutdown();
    }
}

class RunnableTask implements Runnable {
    private final int taskId;

    public RunnableTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());
        try {
            // Simulating some work
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());


    }
}
