package com.fengshan.Thread;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.concurrent.TimeUnit;

/**
 * Created by macbookpro on 2016/9/15.
 */
public class ThreadVariations {
    public static void main(String[] args){
        new InnerThread1("InnerThraed1");
        new InnerThread2("InnerThraed2");
        new InnerThread3("InnerThraed3");
        new InnerThread4("InnerThraed4");
        new MethodThread("MethodThread").runTask();
    }

}

class InnerThread1{

    private int countDown=5;
    private Inner inner;

    private class Inner extends Thread{

        Inner(String name){
            super(name);
            start();
        }

        @Override
        public void run() {
            while (true){
                System.out.println(this);
                if(--countDown==0)
                    return;
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return getName()+":"+countDown;
        }
    }

    public InnerThread1(String name){
        inner =new Inner(name);
    }
}

class InnerThread2{

    private int countDown=5;
    private Thread thread;

    public InnerThread2(String name){
        thread=new Thread(name){

            @Override
            public void run() {
                while (true){
                    System.out.println(this);
                    if (--countDown==0) return;;
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public String toString() {
                return getName()+":"+countDown;
            }
        };
        thread.start();
    }

}

class InnerThread3{

    private int countDown=5;
    private Inner inner;
    private Thread thread;

    private class Inner implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println(this);
                if (--countDown==0) return;
            }
        }

        @Override
        public String toString() {
            return thread.getName()+":"+countDown;
        }
    }

    public InnerThread3(String name){
        thread=new Thread(new Inner());
        thread.setName(name);
        thread.start();
    }

}

class DiffirentVersionInnerThread3{

    private int countDown=5;
    private Inner inner;

    private class Inner implements Runnable{
        Thread thread;

        public Inner(String name){
            thread=new Thread(this,name);
        }

        @Override
        public void run() {
            while (true){
                System.out.println(this);
                if (--countDown==0) return;
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public String toString() {
            return thread.getName()+":"+countDown;
        }
    }

    public DiffirentVersionInnerThread3(String name){
        new Inner(name);
    }

}

class InnerThread4{

    private int countDown = 5;
    private Thread thread;

    public InnerThread4(String name){
        thread =new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(this);
                    if (--countDown==0) return;
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public String toString() {
                return thread.getName()+":"+countDown;
            }
        },name);
        thread.start();
    }

}

class MethodThread{

    private int countDown = 5;
    private Thread thread;
    private String name;
    public MethodThread(String name){
        this.name=name;
    }

    public void runTask(){
        if (thread==null){
            thread=new Thread(name){
                @Override
                public void run() {
                    while (true){
                        System.out.println(this);
                        if (--countDown==0) return;
                    }
                }

                @Override
                public String toString() {
                    return thread.getName()+";"+countDown;
                }
            };
            thread.start();
        }
    }

}



























