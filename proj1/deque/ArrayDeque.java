package deque;

import java.lang.reflect.Array;

public class ArrayDeque<T> {
    T[] value;
    int first;
    int last;
    int size;
    int refactor = 2;
    public ArrayDeque() {
        //start from the mid.
        value = (T[]) new Object[8];
        first = 6;
        last = 7;
        size = 0;
    }
    private void sizeCheck() {
        while (((double)size / value.length <= 0.25) && (size > 8)) {
            this.resize(value.length / refactor);
        }
    }
    private void resize(int new_size) {
        T[] a = (T[]) new Object[new_size];
        for (int i = first + 1, new_first = 0; i != last; i += 1, new_first += 1) {
            if (i == value.length) {
                i -= value.length;
            }
            //possible downsizing would cause outta-boundary problem. start from 0 in the new array.
            a[new_first] = value[i];
        }
        this.value = a;
    }
    public void addFirst(T item) {
        if  (size == value.length) {
            this.resize(value.length * refactor);
        }
        value[first] = item;
        first -= 1;
        if (first < 0) {
            first += value.length;
        }
        size += 1;
    }
    public void addLast(T item) {
        if  (size == value.length) {
            this.resize(value.length * refactor);
        }        value[last] = item;
        last += 1;
        if (last == value.length) {
            last = 0;
        }
        size += 1;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
            return;
        }
        for (int i = first + 1, count = 0; count < size; i += 1, count += 1) {
            if (i == value.length) {
                i = 0;
            }
            System.out.print(value[i] + " ");
        }
        System.out.println();
    }


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (first == value.length) {
            first = 0;
        }
        T output = value[first + 1];
        value[first] = null;
        size -= 1;
        this.sizeCheck();
        return output;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (last == 0) {
            last = value.length;
        }
        T output = value[last - 1];
        value[last] = null;
        size -= 1;
        this.sizeCheck();
        return output;
    }

    public T get(int index) {
        int output_index = first + 1 + index;
        if (output_index >= value.length) {
            output_index -= value.length;
        }
        return this.value[output_index];
    }
}
