public class Solution {
	public static int countDistinctWayToClimbStair(long nStairs) {
		
        //recursion
        //return f(nStairs);
        
        //memoization
        //return fMem(nStairs, new int[(int)nStairs+1])%1000000007;
        
        //tabulation
        //return fDP(nStairs);
        
        //space optimisation
        return fS(nStairs);
	}
    /*
    public static int f(long n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        return f(n-1) + f(n-2);
    }
    */
    /*
    public static int fMem(long n, int[] dp){
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        if(dp[(int)n] != 0) return dp[(int)n];
        
        return dp[(int)n] = fMem(n-1, dp)%1000000007 + fMem(n-2, dp)%1000000007;
    }
    */
    /*
    public static int fDP(long n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        
        int[] dp = new int[(int)n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i <= (int)n; i++){
            dp[i] = dp[i-1]%1000000007 + dp[i-2]%1000000007;
        }
        return dp[(int)n]%1000000007;
    }
    */
    
    public static int fS(long n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        int a = 1;
        int b = 1;
        
        for(int i = 2; i <= (int)n; i++){
            int temp = a;
            a = b;
            b = (temp+b)%1000000007;
        }
        return b;
    }
}