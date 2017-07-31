package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/29.
 */
import java.util.Scanner;
public class Demo5 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        num = num<<16;
        System.out.println(num);
    }
}
