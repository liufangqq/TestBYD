package com.byd.firstcode.kotlin;

/**
 * <pre>
 * author : liu.fang49
 * e-mail : xxx@xx
 * time : 2021/08/17
 * desc :
 * version: 1.0
 * </pre>
 */
public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    public synchronized static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }
    public void singletonTest(){
        System.out.println("called");
    }

}
