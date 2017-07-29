package com.company.huawei;

import java.io.File;
import java.io.IOException;

/**
 * Created by a1996_000 on 2017/7/27.
 */
public class FileTest {
    public static void main(String[]args){
        File file = new File("E:\\Important documents\\word.txt");
        if(file.exists()){
            //file.delete();
            String name = file.getName();
            long length = file.length();
            boolean flag = file.isHidden();
            boolean isFile = file.isFile();
            System.out.println("文件的名称  " + name);
            System.out.println("文件的长度  " + length);
            System.out.println("是否是隐藏文件  " + flag);
            //System.out.println("文件已删除");
        }else{

                try {
                    file.createNewFile();
                    System.out.println("文件已创建");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

