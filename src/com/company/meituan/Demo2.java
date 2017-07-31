package com.company.meituan;

/**
 * Created by a1996_000 on 2017/7/30.
 */
// n个数里出现次数大于等于n/2的数
import java.util.*;

public class Demo2 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []num = new int[n];
        for(int i=0;i<num.length;i++){
            num[i] = input.nextInt();
        }
        int count = num.length/2;
        Map map = new HashMap();
        for(int i=0;i<num.length;i++){
            if(map.containsKey(num[i])){
                map.put(num[i],(Integer)map.get(num[i])+1);
            }else{
                map.put(num[i],1);
            }
        }
        Set set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            Object obj = it.next();

            if((Integer)map.get(obj)>=count){
                System.out.println(obj);
            }
        }
    }

}
