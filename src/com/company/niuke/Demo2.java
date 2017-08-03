package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
//输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
import java.util.*;
public class Demo2{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            char[] s = in.nextLine().toCharArray();
            int w, b, d, o;
            w = b = d = o = 0;
            for(int i = 0; i < s.length; i++) {
                if((s[i] >= 'a' && s[i] <= 'z') || (s[i] >= 'A' && s[i] <= 'Z'))
                    w++;
                else if(s[i] >= '0' && s[i] <= '9')
                    d++;
                else if(s[i] == ' ')
                    b++;
                else
                    o++;
            }
            System.out.println(w);
            System.out.println(b);
            System.out.println(d);
            System.out.println(o);
        }
    }
}
