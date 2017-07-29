package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/26.
 */
//守护线程的作用
public class MultiThread implements Runnable{
    @Override
    public void run() {

            System.out.println("Hello");

    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MultiThread());
        Thread t2 = new Thread(new MultiThread());
        t2.setDaemon(true);//t2线程为守护线程
        t1.start();
        t2.start();
    }
}
