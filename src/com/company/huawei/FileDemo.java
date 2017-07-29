package com.company.huawei;

import java.io.*;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class FileDemo {
    public static void main(String[]args){
        File file = new File("E:\\Important documents\\word.txt");
        try {
            //向文件中写入数据用输出流
            FileOutputStream out = new FileOutputStream(file);
            byte[]buy = "1234567890".getBytes();
            try {
                out.write(buy);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //读取文件中的数据用输入流
        try {
            FileInputStream inputStream = new FileInputStream(file);
            byte[]bys = new byte[20];
            try {
                int len = inputStream.read(bys);
                System.out.println("文件中的信息是  ：" + new String(bys,0,len));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
