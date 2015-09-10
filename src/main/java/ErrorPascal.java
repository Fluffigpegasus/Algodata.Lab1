/**
 * Created by Madde on 2015-09-04.
 * The abstract class including sanity check of n and k
 */
public abstract class ErrorPascal implements Pascal {
    public void printPascal(int n) throws Exception{
        if(n < 0) {
            throw new Exception("Invalid n, n can't be 0 or less!");
        }
    }

    public int binom(int n, int k) throws Exception{
        if(k < 0 || k > n){
            throw new Exception("Invalid k and/or n!");
        }
        return 0;
    }
}
