package deque;

import java.lang.reflect.Array;

public class ArrayDeque<T> {
    T[] value;
    int first;
    int last;
    int size;

    public ArrayDeque() {
        value = (T[]) new Object[8];
        first = 3;
        last = 4;
        size = 0;
    }
    public static void resize(ArrayDeque A) {
        ArrayDeque sized = (T[]) new Object[A.size()*2];

    }
    public void addFirst(T item) {
        //resize if size == length
        first -= 1;
        if (first < 0) {
            first += size;
        }
        value[first] = item;
        size += 1;
    }
    public void addLast(T item) {
        //resize if size == length
        value[first + size] = item;
        size += 1;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int size() {
        return size;
    }
    public void printDeque() {
    }
    public T removeFirst() {
        T output = value[first];
        value[first] = null;
        first += 1;
        size -= 1;
        return output;
    }
    public T removeLast() {
        T output = value[first + this.size()];
        value[first + this.size()] = null;
        size -= 1;
        return output;
    }
}
