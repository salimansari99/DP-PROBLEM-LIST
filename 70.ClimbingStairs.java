class Solution {
    public int climbStairs(int n) {
        
        //return helper(0, n, new int[n+1]);
        return helper2(n);
    }
    
    // method 1
    public int helper(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != 0) return dp[i];
        int a1 = helper(i+1, n, dp);
        int a2 = helper(i+2, n, dp);
        /*
        shortcut for writing function call
        int ans = 0;
        for(int step = 1; step <= 2; step++){
            ans += helper(i+step, n, dp);
        }
        */
        return dp[i] = a1 + a2;
    }
    // method 2
    public int helper2(int n){
        if(n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}