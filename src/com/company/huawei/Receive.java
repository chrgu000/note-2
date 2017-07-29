package com.company.huawei;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class Receive extends JFrame implements Runnable,ActionListener {
    int port;
    InetAddress group = null;
    MulticastSocket socket = null;
    JButton ince = new JButton("开始接受");
    JButton stop = new JButton("停止接受");
    JTextArea incear = new JTextArea(10,10);
    JTextArea inced = new JTextArea(10,10);
    Thread thread;
    boolean b = false;
    public Receive(){
        super("广播数据报");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thread = new Thread(this);
        ince.addActionListener(this);
        stop.addActionListener(this);
        incear.setForeground(Color.blue);
        JPanel north = new JPanel();
        north.add(ince);
        north.add(stop);
        add(north,BorderLayout.CENTER);
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,2));
        center.add(incear);
        center.add(inced);
        add(center,BorderLayout.CENTER);
        validate();
        port = 9898;
        try {
            group = InetAddress.getByName("224.255.10.0");
            try {
                socket = new MulticastSocket(port);
                socket.joinGroup(group);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        setBounds(100,50,360,380);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ince){
            ince.setBackground(Color.RED);
            stop.setBackground(Color.yellow);
            if(!(thread.isAlive())){
                thread = new Thread(this);
            }
            thread.start();
            b = false;
        }
        if(e.getSource()==stop){
            ince.setBackground(Color.yellow);
            stop.setBackground(Color.RED);
            b = true;
        }
    }

    @Override
    public void run() {
        while(true){
            byte[]data = new byte[1024];
            DatagramPacket packet = null;
            packet = new DatagramPacket(data,data.length,group,port);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(),0,packet.getLength());
                incear.setText("正在接受的内容  ：" + message);
                inced.append(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(b==true){
                break;
            }
        }
    }
    public static void main(String[]args){
        Receive receive  = new Receive();
        receive.setSize(460,200);
    }
}
