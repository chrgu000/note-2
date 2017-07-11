package com.lyf.regex;

/**
 * Created by a1996_000 on 2017/7/11.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    public static void main(String[] args) {
        fun5();
    }


    public static void fun1() {
        boolean ret = false;
        ret = Pattern.matches("\\d+", "2223");//返回true +代表一个或多个
        System.out.println(ret);

        ret = Pattern.matches("\\d+", "2223aa");//返回false,需要匹配到所有字符串才能返回true,这里aa不能匹配到    \\d代表匹配数字
        System.out.println(ret);

        ret = Pattern.matches("\\d+", "22bb23");//返回false,需要匹配到所有字符串才能返回true,这里bb不能匹配到     \\d代表匹配数字    完全匹配
        System.out.println(ret);

        Pattern p = Pattern.compile("\\w+");
    }

    public static void fun2() {
        boolean ret = false;

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("22bb23");
        ret = m.matches(); //返回false,因为bb不能被\d+匹配,导致整个字符串匹配未成功.   \\d代表匹配数字
        System.out.println(ret);

        Matcher m2 = p.matcher("2223");
        ret = m2.matches(); //返回true,因为\d+匹配到了整个字符串    \\d代表匹配数字
        System.out.println(ret);
    }

    public static void fun3() {
        boolean ret = false;

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher("22bb23");
        ret = m.lookingAt(); //返回true,因为\d+匹配到了前面的22   尝试将从区域开头开始的输入序列与该模式匹配。
        System.out.println(ret);

        Matcher m2 = p.matcher("aa2223");
        ret = m2.lookingAt(); //返回false,因为\d+不能匹配前面的aa
        System.out.println(ret);
    }

    public static void fun4() {
        boolean ret = false;

        Pattern p = Pattern.compile("\\d+");

        Matcher m = p.matcher("22bb23");
        ret = m.find(); //返回true      部分匹配
        System.out.println(ret);

        Matcher m2 = p.matcher("aa2223");
        ret = m2.find(); //返回true     部分匹配
        System.out.println(ret);

        Matcher m3 = p.matcher("aa2223bb");
        ret = m3.find(); //返回true     部分匹配
        System.out.println(ret);

        Matcher m4 = p.matcher("aabb");
        ret = m4.find(); //返回false    部分匹配
        System.out.println(ret);
    }

    public static void fun5() {
        String xx = "^a";//非的意思除a以外的意思
        String vv = "abcdef";
        System.out.println(vv.matches(xx));//完全匹配 字符串中有A  false


        int retInt = 0;
        String retStr = null;

        Pattern p = Pattern.compile("\\d+");

        Matcher m = p.matcher("aaa2223bb");
        m.find(); //匹配2223

        retInt = m.start(); //返回3      第一个匹配字符的索引。
        System.out.println(retInt);

        retInt = m.end(); //返回7,返回的是2223后的索引号   最后匹配字符之后的偏移量。   第一个b索引
        System.out.println(retInt);

        retStr = m.group(); //返回2223  返回由以前匹配操作所匹配的输入子序列
        System.out.println(retStr);

        Matcher m2 = p.matcher("2223bb");//p = Pattern.compile("\\d+");
        m2.lookingAt(); //匹配2223
        retInt = m2.start(); //返回0,由于lookingAt()只能匹配前面的字符串,所以当使用lookingAt()匹配时,start()方法总是返回0  匹配符合的第一个索引号
        System.out.println(retInt);

        retInt = m2.end(); //返回4 返回结束位置索引的偏移量即第一个b
        System.out.println(retInt);

        retStr = m2.group(); //返回2223
        System.out.println(retStr);

        System.out.println("*********************************");

    }
}
