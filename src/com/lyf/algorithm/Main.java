package com.lyf.algorithm;

/**
 * Created by a1996_000 on 2017/7/8.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *遍历多叉树求最优解的过程  阿里巴巴在线测评题
 */
public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while(line != null && !line.isEmpty()) {
            if(line.trim().equals("0")) break;
            String []values = line.trim().split(" ");
            if(values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        int res = resolve(_ids, _parents, _costs);

        System.out.println(String.valueOf(res));
    }

    // write your code here
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {
        Integer cost1 = costs.get(0);
        int []array = new int[costs.size()];
        int j=0;
        for(int i=1;i<costs.size();i++){
            array[j] = costs.get(i)+cost1;
            j++;
        }
        Arrays.sort(array);
        return array[array.length];
    }
}

