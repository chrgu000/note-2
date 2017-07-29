package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class Sleep implements Runnable {
    static Thread thread1;
    static Thread thread2;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " "+"Hello");
        try {
            Thread.sleep(1000);
            try {
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " " + "World");
    }
    public static void main(String[]args){

        thread1 = new Thread(new Sleep());
        thread1.setName("thread1");

        thread2 = new Thread(new Sleep());
        thread2.setName("thread2");

        thread1.start();

    }
}
