package com.company.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a1996_000 on 2017/8/1.
 */
public class Algorithm021
{
    public static void main(String[] args)
    {
        int n = 20;//变量n
        int m = 5;//变量m
        List<Integer> list = new ArrayList<>();//集合

        int up = n > m ? m : n;//n m中的较小值

        printList(m, up, list);
    }

    /**
     *
     * @param m
     *            剩些的能减去的数
     * @param n
     *            遍历的树列中的最大，从1，2，3...n右往左校验
     * @param list
     */
    public static void printList(int m, int n, List<Integer> list)
    {
        if (m == 0)
        {
            System.out.println(list);
            return;
        }

        if (n <= 0 || m < 0)
        {
            return;
        }

        List list1 = new ArrayList<>(list);
        printList(m, n - 1, list);

        list1.add(n);
        printList(m - n, n - 1, list1);

    }
}
