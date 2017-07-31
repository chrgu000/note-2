package com.company.meituan;

/**
 * Created by a1996_000 on 2017/7/30.
 */
//在一行内输出str中里连续最长的数字串。
import java.util.Scanner;
public class Main {

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        StringBuffer bf = new StringBuffer();
        while(input.hasNext()){
            String str = input.nextLine();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)<'0'||str.charAt(i)>'9'){
                    str.replace(str.charAt(i),'#');
                }
            }
            String []strs = str.split("#");
            for(String string:strs){
                System.out.println(string);
            }


        }
    }
}
