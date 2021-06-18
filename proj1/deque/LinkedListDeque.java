package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
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

    public T getHelperHead (int index, Node n) {
        if (index == 0) {
            return n.value;
        }
        return getHelperHead(index - 1, n.next);
    }
    public T getHelperRear (int index, Node n) {
        if (index == 0) {
            return n.value;
        }
        return getHelperRear(index - 1, n.prev);
    }
    public T getRecursive(int index) {
        if (index > size / 2) {
            return getHelperRear(this.size() - index - 1, sentinel.prev);
        } else {
            return getHelperHead(index - 1, sentinel.next);
        }
    }

    private class LLDequeIterator implements Iterator<T> {
        private Node curr;
        public LLDequeIterator() {
            curr = sentinel.next;
        }
        @Override
        public boolean hasNext() {
            return curr.next != sentinel;
        }
        @Override
        public T next() {
            T item = curr.value;
            curr = curr.next;
            return item;
        }
    }
    public Iterator<T> iterator() {
        return new LLDequeIterator();
    }
    @Override
    public boolean equals(Object o) {
        if (! (o instanceof Deque) || this.size != ((Deque<?>) o).size()) {
            return false;
        }
        Iterator<T> i1 = this.iterator();
        Iterator<T> i2 = ((Deque<T>) o).iterator();
        while (i1.hasNext() && i2.hasNext()) {
            if (i1.next() != i2.next()) {
                return false;
            }
        }
        return true;
    }
}
