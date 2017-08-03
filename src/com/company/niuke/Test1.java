package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
import java.util.*;
public class Test1 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int c = 2;
        while(num>0){
            if(num%c==0){
                System.out.print(c+" ");
                num = num/c;
            }else{
                if(c<num){
                    c++;
                }else{
                    break;
                }
            }
        }
    }
}
