package com.watson.algorithm.二叉树;

import com.watson.algorithm.数据结构.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class BinaryTree {

    public static void flatten(TreeNode root) {
        preOrder(root);
        TreeNode current = root;
        while(!queue.isEmpty()){
            current.left = null;
            current.right = queue.poll();
            current = current.right;
        }
    }

    static Queue<TreeNode> queue = new LinkedList<>();
    public static void preOrder(TreeNode root) {
        if(root == null) return;
        queue.offer(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
