package com.company.huawei;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class Weather extends  Thread {
    String weather = "节目预报八点有大型晚会，请收听";
    int port = 9898;
    InetAddress inetAddress = null;
    MulticastSocket socket = null;
    Weather(){
        try {
            inetAddress = InetAddress.getByName("224.255.10.0");
            try {
                socket = new MulticastSocket(port);
                socket.setTimeToLive(1);
                socket.joinGroup(inetAddress);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while(true){
            DatagramPacket packet = null;
            byte[]data = weather.getBytes();
            packet = new DatagramPacket(data,data.length,inetAddress,port);
            System.out.println(new String(data));
            try {
                socket.send(packet);
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[]args){
        Weather weather = new Weather();
        weather.start();
    }
}
