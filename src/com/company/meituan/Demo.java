package com.company.meituan;

/**
 * Created by a1996_000 on 2017/7/30.
 */
//找出n个数里最小的k个
import java.util.Arrays;
import java.util.Scanner;
public class Demo {
    public static String getMins(){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []array = new int[n];
        for(int i=0;i<array.length;i++){
            array[i] = input.nextInt();
        }
        int k = array[array.length-1];
        Arrays.sort(array);
        StringBuffer bf = new StringBuffer();

        for(int i=0;i<k;i++){
            bf.append(array[i]+" ");
        }
        return bf.toString().trim();
    }
    public static void main(String[]args){
        System.out.println(Demo.getMins());
    }
}
