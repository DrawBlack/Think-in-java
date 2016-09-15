package com.fengshan.Thread;


import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by macbookpro on 2016/9/6.
 *
 * 线程有返回值的情况
 *
 */
 class TaskWithResult implements Callable{

    private int id;

    public TaskWithResult(int id){
        this.id=id;
    }


    @Override
    public String call() throws Exception {
        return "taskwithresult is  "+id;
    }
}

public class CallableDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Future<String>> arrayList=new ArrayList<Future<String>>();
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++)
            arrayList.add(executorService.submit(new TaskWithResult(i)));

        for (Future<String> f:arrayList) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }

    }
}


