package com.ezreal.algo.struct;

/**
 * 跳表
 * 空间换时间的思想，通过建立索引的方式，使得链表也能使用类二分查找的方式在O(logN)时间内查找数据
 * 增删改也时间复杂度也是 O(logN)
 * 空间：两个节点建一个索引的情况下 n-2， 三个情况下 O(n) n/2
 */
public class SkipList {

    // 保存最高一层索引的头结点
    private Node topIndexHead;

    /**
     * 使用普通链表来建立跳表
     * @param head 链表头结点
     */
    public SkipList(Node head){
        topIndexHead = head;
        if (head == null || head.next == null || head.next.next == null){
            return;
        }
        buildShipList();
    }

    private void buildShipList(){
        // 初始化新一级索引头结点
        Node newIndexHead  =  topIndexHead;
        newIndexHead.down = topIndexHead;
        int i = 0;
        int size = 1;
        while (topIndexHead.next != null){
            // 每两个节点新增一个节点
            if (i % 2 == 0){

                size++;
            }
            topIndexHead = topIndexHead.next;
            i++;
        }
        // 最后更新最高层索头结点为新建好的索引
        topIndexHead = newIndexHead;
        // 如果新的索引链表数量操作两个，则继续建立更高级索引
        if (size > 2){
            buildShipList();
        }
    }

    /**
     * 查找表中是否存在某个数
     */
    public boolean contains(int value){
        return false;
    }

    public static class Node{
        int value;
        Node next;
        Node down;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
