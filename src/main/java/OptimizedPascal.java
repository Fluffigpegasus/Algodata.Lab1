import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Madde on 2015-09-03.
 * My improved version of the class RecursivePascal
 */
public class OptimizedPascal extends ErrorPascal implements Pascal{

    // prints the first n levels of Pascal’s Triangle to standard out
    public void printPascal(int n) throws Exception{
        // check if n > 0 and give the array a size
        if (Driver.temp == n+1){
            super.printPascal(n);
            Driver.mem = new int[n+1][n+1];
        }

        // basecase, n equals rows, k equals columns
        if(n < 0) {
            return;
        }
        if(Driver.toggle){
            printPascal(n - 1);
        }

        // loops through each column of the multi-array
        for(int k = 0; k <= n; k++){
            StdOut.print(binom(n,k) + " ");
        }
        StdOut.println(" ");
        if(!Driver.toggle){
            printPascal(n-1);
        }
    }

    // saves calculations in an array
    public int binom(int n, int k) throws Exception{
        super.binom(n, k);
        if(n == k){
            Driver.mem[n][n] = 1;
            return 1;
        }
        if(k == 0){
            Driver.mem[n][0] = 1;
            return 1;
        }
        //check if already calculated
        if(Driver.mem[n][k] != 0){
            return Driver.mem[n][k];
        }
        return (Driver.mem[n][k] = (Driver.mem[n - 1][k - 1] = binom(n-1, k-1)) + (Driver.mem[n - 1][k] = binom(n-1, k)));
    }
}


