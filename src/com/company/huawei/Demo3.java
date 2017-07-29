package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/29.
 */

/**
 * 16进制转10进制
 */
import java.util.*;
public class Demo3 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String number = new String(input.nextLine());
        Integer num = Integer.parseInt(number,16);
        System.out.println(num);
    }
}
