package com.fengshan.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by macbookpro on 2016/9/6.
 *
 * 简单的单例线程的例子
 * 单例线程池会先运行完先加入的线程再去运行其他的线程
 *
 */
public class SingleThreadPoolDemo {

    private static int defautCount=5;

    public static void main(String[] args){
        Executor executor= Executors.newSingleThreadExecutor();
        while (defautCount-->0){
            executor.execute(new Test());
        }
    }
}
