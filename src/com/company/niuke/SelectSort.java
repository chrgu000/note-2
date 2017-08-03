package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/2.
 *
 */

/**
 *选择排序
 */
public class SelectSort {
    public int[] SelectSort(int[]array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i]<array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int n:array){
            System.out.print(n + "  ");
        }
        return array;
    }
    public static void main(String[]args){
        SelectSort sort = new SelectSort();
        int []array = {6,5,553,2,1};
        int []num = sort.SelectSort(array);
        for(int n:num){
            System.out.print(n + "  ");
        }
    }
}
