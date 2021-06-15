package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class StopwatchDemo {
    /** Computes the nth Fibonacci number using a slow naive recursive strategy.*/
    private static int fib(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Stopwatch sw = new Stopwatch();
        int fib41 = fib(2);
        double timeInSeconds = sw.elapsedTime();
        System.out.println("The 1 fibonacci number is " + fib41);
        System.out.println("Time taken to compute 1 fibonacci number: " + timeInSeconds + " seconds.");
        int fib42 = fib(3);
        timeInSeconds = sw.elapsedTime();
        System.out.println("The 2 fibonacci number is " + fib42);
        System.out.println("Time taken to compute 2 fibonacci number: " + timeInSeconds + " seconds.");
    }
}
