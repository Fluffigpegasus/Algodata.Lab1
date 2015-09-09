import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Madde on 2015-09-03.
 */
public class RecursivePascal{

    public static int mem[][];
    public static boolean toggle = false;

    public static void main(String[] args){
        StdOut.println("Press 1 for top first, 0 for bottom first: ");
        if(StdIn.readInt() == 1){
            toggle = true;
        }
        StdOut.println("Amount of levels for Pascal's triangle: ");
        int n = StdIn.readInt();
        mem = new int[n][n];
        RecursivePascal row = new RecursivePascal();
        row.printPascal(n - 1);
    }

    // prints the first n levels of Pascal’s Triangle to standard out
    public void printPascal(int n){
        // basecase, n equals rows, k equals columns
        if(n < 0) {
            return;
        }
        if(toggle){
            printPascal(n - 1);
        }
        // loops through each column of the multi-array
        for(int k = 0; k <= n; k++){
            StdOut.print(binom(n,k) + " ");
        }
        StdOut.println(" ");
        if(!toggle){
            printPascal(n-1);
        }
    }

    // saves calculations in an array
    public int binom(int n, int k){
        if(n == k){
            mem[n][n] = 1;
            return 1;
        }
        if(k == 0){
            mem[n][0] = 1;
            return 1;
        }
        //check if already calculated
        if(mem[n][k] != 0){
            return mem[n][k];
        }
        return (mem[n][k] = (mem[n - 1][k - 1] = binom(n-1, k-1)) + (mem[n - 1][k] = binom(n-1, k)));
    }
}