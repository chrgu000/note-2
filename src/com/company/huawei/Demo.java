package com.company.huawei;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by a1996_000 on 2017/7/26.
 */

public class Demo {
    static InetAddress ip;
    public static void main(String[]args){
        try {
            ip = InetAddress.getLocalHost();
            String localName = ip.getHostName();
            String address = ip.getHostAddress();
            InetAddress info =  ip.getByName("localhost");
            System.out.println("本机名  ：" + localName);
            System.out.println("本机ip地址 ：" + address);
            System.out.println("info is :" + info);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }



}
