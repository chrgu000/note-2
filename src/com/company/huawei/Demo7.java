package com.company.huawei;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by a1996_000 on 2017/7/31.
 */
class TreeNode{
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value){
        this.value = value;
    }
}
public class Demo7 {
    //计算二叉树的高度，计算左子树的深度与右子树的深度他俩的较大值+1
    public int getHeight(TreeNode head){
        if(head==null){
            return 0;
        }
        int left = getHeight(head.left);
        int right = getHeight(head.right);
        return Math.max(left,right)+1;
    }
    //计算二叉树的宽度  使用队列，层次遍历二叉树。在上一层遍历完成后，下一层的所有节点已经放到队列中，此时队列中的元素个数
    // 就是下一层的宽度。以此类推，依次遍历下一层即可求出二叉树的最大宽度。
    public int getWidth(TreeNode head){
        if(head==null){
            return 1;
        }
        Queue queue = new ArrayDeque();
        int maxSize = 1;
        while(true){
            queue.add(head);
            if(queue.size()==0){
                break;
            }
            TreeNode node = (TreeNode) queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            maxSize = Math.max(maxSize,queue.size());
        }
        return maxSize;
    }
    //求二叉树的宽度
    public int getWidthOfTree(TreeNode tree){
        if(tree==null){
            return 0;
        }
        if(tree.left==null&&tree.right==null){
            return 1;
        }
        int result = getWidthOfTree(tree.left)+getWidthOfTree(tree.right);
        return result;
    }
}
