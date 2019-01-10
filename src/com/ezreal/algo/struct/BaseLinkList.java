package com.ezreal.algo.struct;

public interface BaseLinkList<E> {
    int size();
    int add(E e);
    int add(int index,E e);
    E get(int index);
    E remove(int index);
    boolean remove(E e);
    void clear();
    void printAll();
}
