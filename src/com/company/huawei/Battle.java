package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/25.
 */
import java.util.Scanner;
public class Battle
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            num = num >> 1;
            System.out.println(num);
        }
    }
}
