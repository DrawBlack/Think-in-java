package com.fengshan.Thread;

/**
 * Created by macbookpro on 2016/9/16.
 *
 * 线程的jon机制
 *
 */
public class Joining {
    public static void main(String[] args){
        Sleep sleepy=new Sleep("Sleepy",1500);
        Sleep grump =new Sleep("grumpy",1500);
        Jonner doepy = new Jonner("doepy",sleepy);
        Jonner doc = new Jonner("doc",grump);
        grump.interrupt();

    }

}

class Sleep extends  Thread{
    private int duation;

    public Sleep(String name ,int sleepTime){
        super(name);
        this.duation=sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            sleep(duation);
        } catch (InterruptedException e) {
            System.out.println(getName()+"has interupted"+"isInterrupted():"+isInterrupted());
        }

        System.out.println(getName()+"has awakened");
    }
}

class Jonner extends Thread{
    private Sleep sleep;
    public Jonner(String name,Sleep sleep){
        super(name);
        this.sleep=sleep;
        start();
    }

    @Override
    public void run() {
        try {
            sleep.join();
        } catch (InterruptedException e) {
            System.out.println("interuoted");
        }

        System.out.println(getName()+"has join completed");
    }
}




















