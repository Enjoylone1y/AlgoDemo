package com.ezreal.algo.struct;

/**
 * 单链表
 */
public class SingleLinkList<E> implements BaseLinkList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public SingleLinkList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int add(E e) {
        return add(size, e);
    }

    @Override
    public int add(int index, E e) {
        checkAddIndex(index);
        if (size == 0) {
            last = first = new Node<>(e, null);
        } else if (index == 0) {
            first = new Node<>(e, first);
        } else if (index == size) {
            last = last.next = new Node<>(e, null);
        } else {
            Node<E> pre = getNode(index - 1);
            pre.next = new Node<>(e, pre.next);
        }
        size++;
        return index;
    }

    @Override
    public E get(int index) {
        checkGetIndex(index);
        return getNode(index).element;
    }

    @Override
    public E remove(int index) {
        checkGetIndex(index);
        Node<E> result;
        if (index == 0) {
            result = first;
            first = first.next;
            result.next = null;
        } else {
            Node<E> pre = getNode(index - 1);
            result = pre.next;
            pre.next = pre.next.next;
            result.next = null;
        }
        size--;
        if (size == 0) {
            last = null;
        } else {
            last = getNode(size - 1);
        }
        return result.element;
    }

    @Override
    public boolean remove(E e) {
        if (size == 0) {
            return false;
        }
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (node.element == e) {
                remove(i);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void clear() {
        if (size == 0) {
            return;
        }
        Node<E> pre = first;
        Node<E> current = first.next;
        while (current != null) {
            pre.next = null;
            pre = current;
            current = current.next;
        }
        pre.next = null;
        size = 0;
        first = last = null;
    }

    // 链表反转
    public void reverse(){

        printAll();

        // 只有一个节点，直接退出
        if (size <= 1){
            return;
        }

        // 要进行反转，必须记住当前处理节点和其前后两个节点
        // 尾就是当前的头
        last = first;
        Node<E> pre = null;
        Node<E> next = null;
        while (first != null){
            // 首先保存原本的next节点
            next = first.next;
            // 把当前节点的next调转方向
            first.next = pre;
            // 移动到下一位置
            pre = first;
            first = next;
        }
        // 头就是在pre的位置
        first = pre;
        printAll();
    }

    private void checkGetIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getNode(int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public void printAll() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            builder.append(get(i).toString()).append(",");
        }
        System.out.println(String.format("size = %d , all = ", size));
        System.out.println(builder.toString());
    }

    private static class Node<E> {
        Node<E> next;
        E element;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
