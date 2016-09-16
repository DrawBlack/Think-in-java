package com.fengshan.Thread;

import java.io.IOException;

/**
 * Created by macbookpro on 2016/9/16.
 *
 * 有响应的应用程序
 *
 */
public class ResponsiveUI extends Thread {
    private static volatile int d=1;
    public ResponsiveUI(){
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        while (true){
            d= (int) (d+(Math.PI+Math.E)/d);
        }
    }

    public static void main(String[] args){
        ResponsiveUI responsiveUI=new ResponsiveUI();
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(d);
    }
}
