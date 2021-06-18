package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class test {
    @Test
    public void AddFirstTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(1);
        L.addFirst(3);
        L.addFirst(7);
        L.printDeque();
    }
    @Test
    public void AddLastTest() {
        LinkedListDeque<Double> L = new LinkedListDeque<>();
        L.addLast(Math.random() - 0.5);
        L.printDeque();
        System.out.println();
        L.addLast(Math.random() - 0.5);
        L.addLast(Math.random() - 0.5);
        L.addLast(Math.random() - 0.5);
        L.printDeque();
        System.out.println();
        L.removeFirst();
        L.printDeque();

    }
    @Test
    public void isEmptyTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addLast(1);
        L.printDeque();
        L.removeFirst();
        assertEquals(true, L.isEmpty());
    }
    @Test
    public void sizeTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addLast(3);
        L.addFirst(9);
        L.removeFirst();
        L.printDeque();
        assertEquals(1, L.size());
    }
    @Test
    public void getTest() {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        L.get(2);
        assertEquals("92", L.get(2));
    }
    @Test
    public void getRecursiveTest() {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        L.get(2);
        L.printDeque();
        assertEquals("92", L.getRecursive(2));
    }
    @Test
    public void removeFirstTest() {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        assertEquals("a1", L.removeFirst());
        L.printDeque();
    }
    @Test
    public void removeLastTest() {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        assertEquals("92", L.removeLast());
        L.printDeque();
    }
    @Test
    public void instanceofTest() {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        ArrayDeque<Integer> A = new ArrayDeque<>();
        System.out.println(L.equals(A));
    }
}
