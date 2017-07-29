package com.company.huawei;

import java.util.Stack;

/**
 * Created by a1996_000 on 2017/7/26.
 */
class Tree{
    Tree left;
    Tree right;
    int data;
    public Tree(int data){
        this.data = data;
    }
}
public class MyTree {
    //--------------------递归---------------------------------------
    public void preOrder(Tree tree){
        if(tree!=null){
            System.out.println(tree.data);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }
    public void midOrder(Tree tree){
        if(tree!=null){
            midOrder(tree.left);
            System.out.println(tree.data);
            System.out.println(tree.right);
        }
    }
    public void postOrder(Tree tree){
        if(tree!=null){
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.data);
        }
    }
    //----------------------非递归----------------------------------------------
    public void preOrder1(Tree tree){
        Stack stack = new Stack();
        stack.push(tree);
        if(!stack.isEmpty()){
            Tree tree1 = (Tree)stack.pop();
            System.out.println(tree1.data);
            stack.push(tree.right);
            stack.push(tree.left);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
    public void midOrder1(Tree tree){
        Stack stack = new Stack();
        Tree cur = tree;
        while(!(stack.isEmpty()&&cur==null)){
            stack.push(cur);
            cur = cur.left;
            if(cur==null){
                Tree tree1 = (Tree)stack.pop();
                System.out.println(tree1.data);
                cur = tree1.right;
            }
        }
    }
    public void postOrder1(Tree tree){
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        stack1.push(tree);
        while(!stack1.isEmpty()){
            Tree tree1 = (Tree)stack1.pop();
            stack2.push(tree1);
            stack1.push(tree1.left);
            stack1.push(tree1.right);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop()+" ");
        }
    }
}
