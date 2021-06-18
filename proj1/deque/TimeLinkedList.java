package deque;
import edu.princeton.cs.algs4.Stopwatch;
import org.apache.commons.beanutils.locale.converters.DoubleLocaleConverter;
import org.checkerframework.checker.units.qual.A;

/**
 * Created by hug.
 */
public class TimeLinkedList {
    private static void printTimingTable(LinkedListDeque<Integer> Ns, LinkedListDeque<Double> times, LinkedListDeque<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeLinkedListDequeConstruction();
    }

    public static double time(int N) {
        LinkedListDeque<Integer> A = new LinkedListDeque<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < N; i += 1) {
            A.addLast(i);
        }
        return sw.elapsedTime();
    }

    public static void timeLinkedListDequeConstruction() {
        int[] N = {256000, 512000, 1024000, 2048000, 4096000, 4096000*2, 4096000*4};
        LinkedListDeque<Integer> Ns = new LinkedListDeque<>();
        LinkedListDeque<Double> Ts = new LinkedListDeque<>();
        for (int i:N) {
            Ns.addLast(i);
            Ts.addLast(time(i));
        }
        printTimingTable(Ns, Ts, Ns);
    }


}
