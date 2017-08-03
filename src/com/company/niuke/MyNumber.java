package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/2.
 */
public class MyNumber {
    public static int getNumber(){
        int count=0;
        int j=1;
        while(true){

            if(j%2==0||j%3==0||j%5==0){
                ++count;

            }
            ++j;
            if(count==1500){
                break;
            }
        }
        return j;
    }
    public static void main(String[]args){
        System.out.println("Hello World");
        System.out.println(MyNumber.getNumber());

    }
}
