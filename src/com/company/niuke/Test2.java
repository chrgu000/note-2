package com.company.niuke;

/**
 * Created by a1996_000 on 2017/8/1.
 */
public class Test2
{
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
    public static void main(String[]args){
        Test2 test = new Test2();
        test.test();
    }
}

