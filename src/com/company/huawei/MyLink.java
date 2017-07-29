package com.company.huawei;

/**
 * Created by a1996_000 on 2017/7/26.
 */
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
    }
}
public class MyLink {
    Node head;
    public void push(int num){
        Node newnode = new Node(num);
        if(head==null){
            head = newnode;
            return ;
        }
        while(head!=null){
            head = head.next;
        }
        head = newnode;
    }
    public int length(){
        if(head==null){
            return 0;
        }
        int count = 0;
        Node cur = head;
        while(cur!=null){
            ++count;
            cur = cur.next;
        }
        return count;
    }
    public void delNode(int index){
        if(index<0||index>length()){
            System.out.println("要删除的节点超出链表范围");
            return ;
        }
        if(index==1){
            head=head.next;
            return ;
        }
        Node node = head;
        while(index!=0){
            node = node.next;
            --index;
        }
        if(node!=null&&node.next!=null) {
            node.next = node.next.next;
        }else{
            System.out.println("无法删除");
        }
    }
    public void delNode(Node node){
        if(node!=null||node.next!=null){
            node = new Node(node.next.data);
            node.next = node.next.next;
        }else{
            System.out.println("该链表无法删除");
        }
    }
    public void printAll(){
        Node cur = head;
        while(cur!=null){

            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    public static void main(String[]args){
        MyLink link = new MyLink();
        link.push(1);
        link.push(2);
        link.push(3);
        link.push(4);
        link.printAll();
    }
}
