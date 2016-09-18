package com.fengshan.Thread;

/**
 * Created by macbookpro on 2016/9/16.
 * 由于线程的本质特性。使得你不能捕获从线程中逃逸的异常,一旦异常逃逸出任务的run方法,他就会向外传播到控制台
 * ,除非你采取特殊的步骤捕获这种异常
 *
 */
public class ExceptionThread extends Thread {
    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args){
        try {
            new ExceptionThread().start();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch the exception");
        }
    }
}