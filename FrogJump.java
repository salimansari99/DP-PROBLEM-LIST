public class Solution {
    public static int frogJump(int n, int heights[]) {
        
        //return fun(n-1, heights);
        //return funMem(n-1, heights, new int[n]);
        return funDP(n, heights, new int[n]);
    }
    
    public static int fun(int n, int[] heights){
        if(n == 0) return 0;
        
        int left = fun(n-1, heights) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n-2 >= 0){
            right = fun(n-2, heights) + Math.abs(heights[n] - heights[n-2]);
        }
        return Math.min(left, right);
    }
    
     public static int funMem(int n, int[] heights, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != 0) return dp[n];
        int left = funMem(n-1, heights, dp) + Math.abs(heights[n] - heights[n-1]);
        int right = Integer.MAX_VALUE;
        if(n-2 >= 0){
            right = funMem(n-2, heights, dp) + Math.abs(heights[n] - heights[n-2]);
        }
        return dp[n] = Math.min(left, right);
    }
    
     public static int funDP(int n, int[] heights, int[] dp){
        if(n == 0) return 0;
         dp[0] = 0;
         for(int i = 1; i < n; i++){
             int left = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
             int right = Integer.MAX_VALUE;
             if(i-2 >= 0){
                 right = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
             }
             dp[i] = Math.min(left, right);
         }
       return dp[n-1];
    }

}