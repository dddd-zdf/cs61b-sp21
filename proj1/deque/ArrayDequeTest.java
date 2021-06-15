package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void AddFirstTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(1);
        L.addFirst(3);
        L.addFirst(7);
        L.printDeque();
    }
    @Test
    public void AddLastTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        //L.printDeque();
    }
    @Test
    public void isEmptyTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(1);
        L.printDeque();
        L.removeFirst();
        assertEquals(true, L.isEmpty());
    }
    @Test
    public void sizeTest() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addLast(3);
        L.addFirst(9);
        L.removeFirst();
        //L.printDeque();
        assertEquals(1, L.size());
    }
    @Test
    public void getTest() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        System.out.println(L.last);
        L.get(2);
        assertEquals("92", L.get(2));
    }
    @Test
    public void getRecursiveTest() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        L.get(2);
        //L.printDeque();
        assertEquals("92", L.get(2));
    }
    @Test
    public void removeFirstTest() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        assertEquals("a1", L.removeFirst());
        L.printDeque();
    }
    @Test
    public void removeLastTest() {
        ArrayDeque<String> L = new ArrayDeque<>();
        L.addFirst("a1");
        L.addLast("c3");
        L.addLast("92");
        assertEquals("92", L.removeLast());
        //L.printDeque();
    }
}
