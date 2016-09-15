package com.fengshan.Thread;

import java.util.concurrent.ThreadFactory;

/**
 * Created by macbookpro on 2016/9/12.
 */
public class DeamonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread=new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
