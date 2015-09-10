import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Madde on 2015-09-04.
 * My version of RecursivePascal with iterative methods instead of recursive
 */
public class IterativePascal extends ErrorPascal implements Pascal {

    // prints the first n levels of Pascal’s Triangle to standard out
    public void printPascal(int n) throws Exception{
        super.printPascal(n);
        Driver.mem = new int[n+1][n+1];

        // loop through each row
        for (int r = 0; r <= n; r++) {
            // loops through each column of the multi-array
            for (int k = 0; k <= r; k++) {
                binom(r, k);
                // for top up print right away
                if (Driver.toggle) {
                    StdOut.print(Driver.mem[r][k] + " ");
                    if(r == k){
                        // new row
                        StdOut.println();
                    }
                }
            }
        }

        // if bottom first, print out the array in reversed order
        if(!Driver.toggle){
            // loop through each row
            for (int r = n; r >= 0; r--) {
                // loops through each column of the multi-array
                for (int k = 0; k <= r; k++) {
                    StdOut.print(binom(r, k) + " ");
                }
                StdOut.println(" ");
            }
        }
    }

    // saves calculations in array
    public int binom(int n, int k) throws Exception{
        super.binom(n, k);
        if(n == k || k == 0){
            Driver.mem[n][k] = 1;
            return 1;
        }
        return (Driver.mem[n][k] = Driver.mem[n - 1][k - 1] + Driver.mem[n - 1][k]);
    }
}
