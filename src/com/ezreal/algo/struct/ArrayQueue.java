package com.ezreal.algo.struct;

/**
 * 顺序队列,用数组存储数据，
 */
public class ArrayQueue<T> {

    private T[] items;
    private int size;
    private int head = 0 ;
    private int tail = 0;

    public ArrayQueue(int capacity){
        this.size = capacity;
        items = (T[]) new Object[capacity];
    }

    public boolean push(T e){
        if (tail == size){
            if (head == 0){
                return false;
            }
            // 把数据往前移动
            if (tail - head >= 0) {
                System.arraycopy(items, head, items, 0, tail - head);
            }
            // 移动完成后更新头尾指针
            head = 0;
            tail -= head;
        }
        // 数据从尾部插入，尾部指针向后移动
        items[tail] = e;
        tail++;
        return true;
    }

    public T pop(){
        if (tail == head){
            return null;
        }
        // 从头部弹出，头部指针向后移动
        T r =  items[head];
        head++;
        return r;
    }
}
