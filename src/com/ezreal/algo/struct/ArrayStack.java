package com.ezreal.algo.struct;

/**
 * 顺序栈,使用数组保存数据，实现栈的FILO效果，有容量限制
 */
public class ArrayStack<T> {

    private T[] items;
    private int n;
    private int elementCount = 0;

    public ArrayStack(int capacity){
        this.n = capacity;
        items = (T[]) new Object[n];
    }

    public boolean push(T e){
        if (elementCount == n){
            return false;
        }
        items[elementCount] = e;
        elementCount++;
        return true;
    }

    public T pop(){
        if (elementCount == 0){
            return null;
        }
        T e = items[elementCount - 1];
        elementCount--;
        return e;
    }
}
