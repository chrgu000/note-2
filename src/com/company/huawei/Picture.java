package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/25.
 */
import java.util.*;
public class Picture {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        if(line==null||line.length()<=0){
            return;
        }
        char[]array = line.toCharArray();
        Arrays.sort(array);
        for(char a:array){
            System.out.print(a+" ");
        }
    }
}
