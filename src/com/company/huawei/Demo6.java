package com.company.huawei;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by a1996_000 on 2017/7/29.
 */
public class Demo6 {
    public char findFirstRepeat(String A, int n) {
        // write code here
        Map map = new HashMap<Character,Integer>();
        for(int i=0;i<A.length();i++){
            if(map.containsKey(A.charAt(i))){
                return A.charAt(i);
            }else{
                map.put(A.charAt(i),1);
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        Demo6 demo = new Demo6();
        System.out.println(demo.findFirstRepeat("kdbaaak",7));
    }
}
