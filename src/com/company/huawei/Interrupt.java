package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class Interrupt implements Runnable {
    @Override
    public void run() {
        int count = 0;
        for(int i=0;i<10;i++){
            System.out.println("count is ：" + count);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++count;
        }
    }
    public static void main(String[]args){
        Thread thread = new Thread(new Interrupt());
        thread.start();
        thread.interrupt();
    }
}
