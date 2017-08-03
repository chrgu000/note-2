package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
import java.util.Scanner;
public class Demo3{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long num;
        while(in.hasNext()){
            num = in.nextLong();
            int k = 2;
            while(num > 0){
                if(num % k == 0){
                    System.out.print(k + " ");
                    num /= k;
                }
                else{
                    if(k < num)
                        k++;
                    else
                        break;
                }
            }
        }
    }
}
