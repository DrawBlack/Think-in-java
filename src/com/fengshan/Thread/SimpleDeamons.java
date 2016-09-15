package com.fengshan.Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbookpro on 2016/9/12.
 *
 * 后台线程的相关知识
 *
 *
 */
public class SimpleDeamons implements Runnable {
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(this);
            } catch (InterruptedException e) {
                System.out.println("Thread interupted");
            }
        }
    }

    public static void main(String[] args){
        for (int i=0;i<10;i++){
            Thread thread=new Thread(new SimpleDeamons());
            thread.setDaemon(true);
            thread.start();
        }

        System.out.println("all deamons start");
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
