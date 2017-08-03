package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
//输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，
// 输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
public class Demo {
    public static String updateString(String s1,String s2){
        char[]array = s2.toCharArray();
        for(int i=0;i<array.length;i++){
            s1 = s1.replace(array[i],'#');
        }
        StringBuffer bf = new StringBuffer();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!='#') {
                bf.append(s1.charAt(i));
            }
        }
        return bf.toString();
    }
    public static void main(String[]args){
        Demo demo = new Demo();
        System.out.println(demo.updateString("”They are students.”","aeiou"));
    }
}
