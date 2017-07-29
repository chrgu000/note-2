package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/26.
 */
import java.util.*;
//输入一个字符串旋转他
public class Demo1 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String string = input.next();
        if(string==null||string.length()==0){
            return ;
        }
        StringBuffer bf = new StringBuffer();
        for(int i=string.length()-1;i>=0;i--){
            bf.append(string.charAt(i));
        }
        System.out.println(bf.toString());
    }
}
