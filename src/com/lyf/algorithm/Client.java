package com.lyf.algorithm;

/**
 * Created by a1996_000 on 2017/7/22.
 */
interface IStrategy {
    public int doCalculate(int a,int b);
}
//加
class Add implements IStrategy {
    public int doCalculate(int a,int b){
        return a+b;
    }
}
//减
class Minus implements IStrategy {
    public int doCalculate(int a,int b){
        return a-b;
    }
}
//乘
class Multi implements IStrategy {
    public int doCalculate(int a,int b){
        return a*b;
    }
}
//除
class Divide implements IStrategy {
    public int doCalculate(int a,int b){
        return a/b;
    }
}
class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy){
        this.strategy = strategy;
    }

    public int execute(int a,int b){
        return strategy.doCalculate(a,b);
    }
}

public class Client {
    public static void main(String[] args){
        Context context;
        System.out.println("-----执行Add-----");
        context = new Context(new Add());
        System.out.println(context.execute(1,3));

        System.out.println("-----执行Minus-----");
        context = new Context(new Minus());
        System.out.println(context.execute(1,3));
    }
}

