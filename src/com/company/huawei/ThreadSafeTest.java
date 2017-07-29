package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class ThreadSafeTest implements Runnable{
    int num = 10;
    @Override
    public  void run() {
        while(true) {
            synchronized ("") {
                if (num > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(num);
                        --num;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[]args){
        Thread thread1 = new Thread(new ThreadSafeTest());
        Thread thread2 = new Thread(new ThreadSafeTest());
        Thread thread3 = new Thread(new ThreadSafeTest());
        Thread thread4 = new Thread(new ThreadSafeTest());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
