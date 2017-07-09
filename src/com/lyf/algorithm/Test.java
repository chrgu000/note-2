package com.lyf.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by a1996_000 on 2017/7/9.
 * 求字符串中某个字符出现的最大次数 以及 该字符
 */
public class Test {
    public static void main(String[]args){
        Test test = new Test();
        test.doString("ddddsssaaadddkj");
    }
    public void doString(String string){
        char[]chars = string.toCharArray();
        TreeSet treeSet = new TreeSet();
        ArrayList arrayList = new ArrayList();
        for(int i=0;i<chars.length;i++){
            treeSet.add(String.valueOf(chars[i]));
            arrayList.add(String.valueOf(chars[i]));
        }
        System.out.println(treeSet);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        StringBuffer bf = new StringBuffer();
        for(int i=0;i<arrayList.size();i++){
            bf.append(arrayList.get(i));
        }
        System.out.println(bf.toString());
        String str = bf.toString();
        Iterator iterator = treeSet.iterator();
        int max = 0;
        ArrayList maxList = new ArrayList();
        String maxString = "";
        while(iterator.hasNext()){
            String s = (String)iterator.next();
            int start = str.indexOf(s);
            int end = str.lastIndexOf(s);
            int value = end-start+1;

            if(value>max){
                maxString = s;
                maxList.add(maxString);
                max = value;
            }else if(value==max){
                maxList.add(s);
            }
        }
        int index = 0;
        for(int i=0;i<maxList.size();i++){
            if(maxList.get(i).equals(maxString)){
                index = i;
            }
        }
        System.out.println("================================================");
        System.out.println(max);
        for(int i=index;i<maxList.size();i++) {
            System.out.println(maxList.get(i));
        }
    }

}
