package com.company.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class MyTcp {
    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;

    void getServer() {
        try {
            server = new ServerSocket(8998);
            System.out.println("服务器套接字已经建立成功");
            while (true) {
                System.out.println("等待客户端的连接");
                socket = server.accept();
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getClientMessage() {

        try {
            while (true) {
                System.out.println("获取客户端信息  ：" + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            if (reader != null) {
                reader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        MyTcp tcp = new MyTcp();
        tcp.getServer();
    }
}

