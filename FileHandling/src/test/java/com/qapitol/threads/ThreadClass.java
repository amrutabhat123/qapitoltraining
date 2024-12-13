package com.qapitol.threads;

public class ThreadClass extends Thread {
    public void run(){
        System.out.println("thread is running"+Thread.currentThread().getName());
    }
    public static void main(String[] args){
        ThreadClass t1=new ThreadClass();

        t1.start();

        ThreadClass t2=new ThreadClass();
        t2.start();
    }
}
