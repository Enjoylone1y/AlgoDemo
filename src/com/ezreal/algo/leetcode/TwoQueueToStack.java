package com.ezreal.algo.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 两个队列实现一个栈
 * 入栈时选择不为空的队列入栈
 * 出栈时，把有数据的队列中前n-1个数据转移到另外一个队列，剩下的第n个数据出队
 */
public class TwoQueueToStack<T> {

    private Queue<T> firstQueue = new LinkedList<>();
    private Queue<T> secondQueue = new LinkedList<>();

    public void push(T t){
        // 入栈操作都加入不为空的队列中，且首次入栈会先加入first队列
        if (!secondQueue.isEmpty()){
            secondQueue.add(t);
        }else {
            firstQueue.add(t);
        }
    }

    public T pop(){
        if (firstQueue.isEmpty() && secondQueue.isEmpty()){
            return null;
        }
        // 出栈操作，从不为空的队列中把前n-1个数据加到另一个队列，剩下那个就是出栈的
        if (!firstQueue.isEmpty()){
            while (firstQueue.size() != 1){
                secondQueue.add(firstQueue.poll());
            }
            return firstQueue.poll();
        }else {
            while (secondQueue.size() != 1){
                firstQueue.add(secondQueue.poll());
            }
            return secondQueue.poll();

        }
    }

    public T top(){
        if (firstQueue.isEmpty() && secondQueue.isEmpty()){
            return null;
        }
        if (!firstQueue.isEmpty()){
            while (firstQueue.size() != 1){
                secondQueue.add(firstQueue.poll());
            }
            T poll = firstQueue.poll();
            secondQueue.add(poll);
            return poll;
        }else {
            while (secondQueue.size() != 1){
                firstQueue.add(secondQueue.poll());
            }
            T poll = secondQueue.poll();
            firstQueue.add(poll);
            return poll;
        }
    }

    public boolean isEmpty(){
        return firstQueue.isEmpty() && secondQueue.isEmpty();
    }
}
