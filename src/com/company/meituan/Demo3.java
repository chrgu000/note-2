package com.company.meituan;

/**
 * Created by a1996_000 on 2017/7/31.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//读入一个字符串str，输出字符串str中的连续最长的数字串
public class Demo3 {
    public static String getMaxNum(){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char[]array = str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]<'0'||array[i]>'9'){
                array[i] = '#';
            }
        }
        str = String.valueOf(array);
        String[]strs = str.split("#");
        List list = new ArrayList();
        for(int i=0;i<strs.length;i++){
            if(i==0){
                list.add(strs[i]);
            }else{
                if(((String)(list.get(0))).length()<strs[i].length()){
                    list.clear();
                    list.add(strs[i]);
                }
            }
        }
        return (String)list.get(0);
    }
    public static void main(String[]args){
        System.out.println(Demo3.getMaxNum());
    }
}
