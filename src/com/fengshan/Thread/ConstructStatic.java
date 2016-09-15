package com.fengshan.Thread;

/**
 * Created by macbookpro on 2016/9/6.
 */

//单例模式

public class ConstructStatic {

    private static ConstructStatic cs;

    public ConstructStatic(){

    }
//双重检验锁
    public static  ConstructStatic getInstance(){
        if(cs==null){
            synchronized (ConstructStatic.class) {
                if(cs==null){
                    cs=new ConstructStatic();
                }
            }

        }
        return cs;
    }




    public static void main(String[] args){
        for(int i=0;i<10;i++)
            System.out.println(ConstructStatic.getInstance());
    }

}

