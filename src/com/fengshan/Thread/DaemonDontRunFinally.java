package com.fengshan.Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbookpro on 2016/9/13.
 */
 class ADaemon implements Runnable {

    @Override
    public void run() {
        System.out.println("Starting DaemonDontRunFinally");
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("finnaly语句被执行");
        }
    }
}

public class DaemonDontRunFinally{
    public static void  main(String[] args){
        Thread thread=new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
    }
}
