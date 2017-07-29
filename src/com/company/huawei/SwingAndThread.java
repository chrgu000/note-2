package com.company.huawei;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class SwingAndThread extends JFrame {
    private JLabel jl = new JLabel();
    private static Thread t;
    private int count = 0;
    private Container container;
    public SwingAndThread(){
        setBounds(300,200,250,100);
        //container.setLayout(null);
        URL url = SwingAndThread.class.getResource("E:\\Important documents\\IMG_325101.jpg");
        Icon icon = new ImageIcon();
        jl.setIcon(icon);
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        jl.setBounds(10,10,200,50);
        jl.setOpaque(true);
        t = new Thread(new Runnable(){

            @Override
            public void run() {
                while(count<=200){
                    jl.setBounds(count,10,200,50);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count += 4;
                    if(count == 200){
                        count = 10;
                    }
                }
            }
        });
        t.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[]args){
        new SwingAndThread();
    }
}
