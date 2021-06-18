package gh2;

import deque.ArrayDeque;
import deque.Deque;
import deque.LinkedListDeque;

public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    private Deque<Double> buffer;
    public GuitarString(double frequency) {
        int capacity = (int) Math.round(SR / frequency);
        //ArrayDeque is faster when there is no need to add within the Deque.
        buffer = new ArrayDeque<>();
        for (int i = 0; i < capacity; i += 1) {
            buffer.addFirst(0.0);
        }
    }


    public void pluck() {
        for (int i = 0; i < buffer.size(); i += 1) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
        }
    }
    public void tic() {
        buffer.addLast((buffer.removeFirst() + buffer.get(0)) / 2 * DECAY);
        //double first = buffer.removeFirst();
        //buffer.addLast(first + buffer.get(0));
    }

    public double sample() {
        return buffer.get(0);
    }
}
