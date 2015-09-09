import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Madde on 2015-09-07.
 * My main Driver including a main method
 */
public class Driver {
    public static int mem[][];
    public static boolean toggle = false;
    public static int temp;

    public static void main(String[] args) throws Exception
    {
        StdOut.println("Press 1 for top first, 0 for bottom first: ");
        if(StdIn.readInt() == 1){
            toggle = true;
        }
        StdOut.println("Amount of levels: ");
        int n = StdIn.readInt();
        temp = n;

        StdOut.println("To print Recursive press 1, to print Iterative press 0:");
        int in = StdIn.readInt();
        boolean first = true;
        if(in == 0){
            first = false;
        }

        if(first) {
            OptimizedPascal rows = new OptimizedPascal();
            Stopwatch clock = new Stopwatch();
            rows.printPascal(n - 1);
            StdOut.println("Runtime for the recursive one: " + clock.elapsedTime());
        }

        if(!first) {
            IterativePascal rows1 = new IterativePascal();
            Stopwatch clock1 = new Stopwatch();
            rows1.printPascal(n - 1);
            StdOut.println("Runtime for the iterative one: " + clock1.elapsedTime());
        }
    }
}