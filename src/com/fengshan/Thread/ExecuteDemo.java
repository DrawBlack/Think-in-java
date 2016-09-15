package com.fengshan.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by macbookpro on 2016/9/6.
 */
public class ExecuteDemo {
    public static void main(String[] args){
        Executor executor= Executors.newCachedThreadPool();
        for(int i=0 ;i<5;i++)
            executor.execute(new Test());

    }

}

class Test implements Runnable{
    private static int id=0;
    private int count=id++;
    private int taskCount=10;

    @Override
    public void run() {
        while (taskCount-->0){
            System.out.println("#"+count+"("+taskCount+")");
            Thread.yield();
        }
    }
}