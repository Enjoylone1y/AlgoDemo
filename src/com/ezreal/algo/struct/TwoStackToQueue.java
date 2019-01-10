package com.ezreal.algo.struct;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 * 其中一个栈负责入队（inStack），另外一个栈负责出队（outStack）
 * 入队时，直接加入 inStack 即可
 * 出队时，如果 outStack 不为空，出队即可，否则看 inStack 是否为空
 * inStack 不为空，把数据全部转移到 outStack ，然后 outStack 出队即可
 * inStack 也为空，则无数据，返回NULL
 */
public class TwoStackToQueue<T> {

    private Stack<T> inStack = new Stack<>();
    private Stack<T> outStack = new Stack<>();

    public void push(T e){
        inStack.push(e);
    }

    public T pop(){
        if (!outStack.isEmpty()){
            return outStack.pop();
        }
        if (!inStack.isEmpty()){
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
        return null;
    }
}
