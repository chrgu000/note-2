package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/26.
 */
public class MyStack {
    Object[]objs;
    int maxsize;
    int top=-1;
    public MyStack(){
        this(10);
    }
    public MyStack(int maxsize){
        this.maxsize = maxsize;
        objs = new Object[maxsize];
    }
    public void push(int num){
        if(top==maxsize-1){
            return ;
        }
        objs[++top] = num;
    }
    public int pop(){
        if(top==-1){
            System.out.println("栈已空");
            return 0;
        }
        return (int)objs[top--];
    }
    public boolean isFull(){
        return top==maxsize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int peek(){
        return (int)objs[top];
    }
    public static void main(String[]args){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
