package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/29.
 */
import java.util.Scanner;

/**
 * 对输入的字符串按长度为八进行截取
 */
public class Demo2 {
    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String string = new String(input.nextLine());
            if(string.length()%8!=0){
                string = string + "00000000";
            }
            while(string.length()>=8){
                String str = string.substring(0,8);
                System.out.println(str);
                string = string.substring(8);
            }
        }
    }
}
