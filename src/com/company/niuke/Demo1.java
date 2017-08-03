package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
import java.util.Scanner;
//输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
public class Demo1 {
    public static void countString(){
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[]array = s.toCharArray();
        int english = 0;
        int space = 0;
        int number = 0;
        int other = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]>='0'&&array[i]<='9'){
                number++;
            }else if(array[i]>='a'&&array[i]<='z'||array[i]>='A'&&array[i]<='Z'){
                english++;
            }else if(array[i]==' '){
                space++;
            }else{
                other++;
            }
        }
        System.out.println("输入的该文本中字母数量有：" + english);
        System.out.println("输入的该文本中空格数量有：" + space);
        System.out.println("输入的该文本中数字数量有：" + number);
        System.out.println("输入的该文本中其它字符数量有：" + other);
    }
    public static void main(String[]args){
        Demo1 demo = new Demo1();
        demo.countString();
    }
}
