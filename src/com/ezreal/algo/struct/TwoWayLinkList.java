package com.ezreal.algo.struct;

/**
 * 双向链表
 */
public class TwoWayLinkList<E> implements BaseLinkList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public TwoWayLinkList() {
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
            last = first = new Node<>(e, null, null);
        } else if (index == 0) {
            first = new Node<>(e, null, first);
        } else if (index == size) {
            last = last.next = new Node<>(e, last, null);
        } else {
            Node<E> pre = getNode(index - 1);
            Node<E> next = pre.next;
            pre.next = new Node<>(e, pre, next);
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
            first.pre = null;
            result.next = null;
        } else {
            result = getNode(index);
            Node<E> pre = result.pre;
            Node<E> next = result.next;
            if (pre != null){
                pre.next = next;
            }
            if (next != null){
                next.pre = pre;
            }
            result.next = null;
            result.pre = null;
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
            pre.pre = null;
            pre = current;
            current = current.next;
        }
        pre.next = null;
        pre.pre = null;
        size = 0;
        first = last = null;
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
        Node<E> x;
        if (index <= (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
        }
        return x;
    }

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
        Node<E> pre;
        E element;

        Node(E element, Node<E> pre, Node<E> next) {
            this.element = element;
            this.pre = pre;
            this.next = next;
        }
    }
}
