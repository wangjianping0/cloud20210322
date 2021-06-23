package com.example.springcloud;

import java.util.concurrent.TimeUnit;

/**
 * @Classname VolicateDemo
 * @Description TODO
 * @Date 2021/3/24 9:56
 * @Created by wangjianping
 */
class DataDemo{
    volatile int num;
    public void addTo60(){
        num=60;
    }
}
public class VolicateDemo {
    public static void main(String[] args) {
        DataDemo demo=new DataDemo();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try{TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t updated number value:"+demo.num);
        },"AAA").start();
        while (demo.num==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
