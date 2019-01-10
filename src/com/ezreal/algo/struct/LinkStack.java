package com.ezreal.algo.struct;

/**
 * 链式栈，使用链表保存数据，实现栈的FILO的效果，无容量限制
 */
public class LinkStack<T> {

    private Node<T> head;

    public LinkStack(){
    }

    public void push(T e){
        head = new Node<>(e,head);
    }

    public T pop(){
        if (head == null){
            return null;
        }
        Node<T> h = head;
        head = head.next;
        h.next = null;
        return h.value;
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
