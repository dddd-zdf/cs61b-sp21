package deque;

import net.sf.saxon.style.XSLMapEntry;

public class LinkedListDeque<T> {
    private class Node{
        private T value;
        private Node next;
        private Node prev;
        Node(T x, Node prev, Node next) {
            this.value = x;
            this.prev = prev;
            this.next = next;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    public void addFirst(T x) {
        Node n = new Node(x, sentinel, sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;

        size += 1;
    }
    public void addLast(T x) {
        Node n = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
        size += 1;
    }
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return this.size;
    }
    public void printDeque() {
        if (this.isEmpty()) {
            System.out.println();
            return;
        }
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.value + " ");
            p = p.next;
        }
        //System.out.println();
    }
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T output = sentinel.next.value;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return output;
    }
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T output = sentinel.prev.value;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return output;
    }
    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }
        Node p = sentinel;
        if (index >= size/2){
            index = size - index;
            for (int i = 0; i != index; i += 1) {
                p = p.prev;
            }
            return p.value;
        }
        for (int i = 0; i != index + 1; i += 1) {
            p = p.next;
        }
        return p.value;
    }

    public T getHelperhead (int index, Node n) {
        if (index == 0) {
            return n.value;
        }
        return getHelperhead(index - 1, n.next);
    }
    public T getHelperrear (int index, Node n) {
        if (index == 0) {
            return n.value;
        }
        return getHelperrear(index - 1, n.prev);
    }
    public T getRecursive(int index) {
        if (index > size / 2) {
            return getHelperrear(this.size() - index - 1, sentinel.prev);
        } else {
            return getHelperhead(index - 1, sentinel.next);
        }
    }

}
