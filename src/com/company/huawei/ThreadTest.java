package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class ThreadTest extends Thread {
    private int count = 10;
    public void run(){
        while(true){
            System.out.println(count+" ");
            if(--count == 0){
                return;
            }
        }
    }
    public static void main(String[]args){
        new ThreadTest().start();
    }
}
