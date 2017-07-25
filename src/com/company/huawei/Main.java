package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/25.
 */
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine().trim();
        String[]strs = str.split("[^a-zA-Z]+");
        StringBuffer bf = new StringBuffer();
        for(int i=strs.length-1;i>=0;i--){
            bf.append(strs[i]+" ");
        }
        System.out.println(bf.toString().substring(0,bf.length()-1));
    }
}