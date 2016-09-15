package com.fengshan.Thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbookpro on 2016/9/13.
 *
 * 后台线程派生出来的子线程也是后台线程
 *
 */
public class Daemons {

    public Daemons() {

    }

    public static void main(String[] args){

        Thread thread=new Thread(new Daemon() );
        thread.setDaemon(true);
        thread.start();
        System.out.println("thred isDaemon:"+thread.isDaemon());
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class Daemon implements Runnable{

    private Thread[] t=new Thread[10];

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            t[i]=new Thread(new DaemonSpawn());
        }
        for (int i=0;i<t.length;i++){
            System.out.println("t["+i+"]"+"is.isDaemon:"+t[i].isDaemon());
        }
        Thread.yield();

    }
}

class DaemonSpawn implements Runnable{

    @Override
    public void run() {
        Thread.yield();
    }
}
