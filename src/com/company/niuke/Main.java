package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
//将一句话的单词进行倒置，标点不倒置。比如 I like beijing. 经过函数后变为：beijing. like I
import java.util.*;
public class Main {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        String[]strs = line.split(" ");
        StringBuffer bf = new StringBuffer();
        for(int i=strs.length-1;i>=0;i--){
            bf.append(strs[i]+" ");
        }
        System.out.println(bf.toString().trim());
    }
}
