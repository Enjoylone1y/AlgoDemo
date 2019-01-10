package com.ezreal.algo.struct;

/**
 * 链式队列，链表存储数据，实现队列的FILO，无容量限制
 */
public class LinkQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public void push(T e){
        if (head == null){
            head = tail = new Node<>(e,null);
        }else {
            tail.next = new Node<>(e,null);
            tail = tail.next;
        }
    }

    public T pop(){
        if (head == null){
            return null;
        }
        Node<T> ret = head;
        head = head.next;
        if (head == null){
            tail = null;
        }
        return ret.value;
    }

    private static class Node<T>{
        T value;
        Node<T> next;
        Node(T value,Node<T> next){
            this.value = value;
            this.next = next;
        }
    }
}
