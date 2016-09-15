package com.fengshan.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by macbookpro on 2016/9/12.
 *
 * 线程池构造函数可以使用一个线程工厂来制作想要的线程
 *
 *
 */
public class DeamonFromFactory implements Runnable{
    @Override
    public void run() {
        while (true){
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[]args){
        ExecutorService executorService= Executors.newCachedThreadPool(new DeamonThreadFactory());
        for (int i=0;i<10;i++){
            executorService.execute(new DeamonFromFactory());
        }

        try {
            TimeUnit.MILLISECONDS.sleep(99);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
