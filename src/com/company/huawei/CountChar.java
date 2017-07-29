package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/26.
 */

import java.util.*;

public class CountChar {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        Map map = new HashMap<Character,Integer>();
        String line = input.nextLine();
        int[]array = new int[255];
        char[]chars = line.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],1+(Integer)map.get(chars[i]));
            }else{
                map.put(chars[i],1);
            }
        }
        Set set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Character c = (Character) it.next();
            System.out.println(c+" "+map.get(c));
        }
    }
}
