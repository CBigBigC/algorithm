package com.watson.algorithm.数据结构;

/**
 * 链表基础结构
 */
public class LinkedNode {
    public int data;
    public LinkedNode next;

    public LinkedNode(int data) {
        this.data = data;
    }

    public LinkedNode(int data, LinkedNode next) {
        this.data = data;
        this.next = next;
    }
}
