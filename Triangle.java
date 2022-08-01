public class Solution {
    public static int minimumPathSum(int[][] triangle, int n) {
        //return minPath(triangle, 0, 0, n, new int[n][n]);
        return minPathSO(triangle, n);
    }
    public static int minPath(int[][] arr, int i, int j, int n, int[][] dp){
        if(i == n-1) return arr[i][j];
        if(dp[i][j] != 0) return dp[i][j];
        int down = minPath(arr, i+1, j, n, dp);
        int dg = minPath(arr, i+1, j+1, n, dp);
        return dp[i][j] = arr[i][j] + Math.min(down, dg);
        
    }
    public static int minPathDP(int[][] arr, int n){
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++){
            dp[n-1][i] = arr[n-1][i];
        }
        
        for(int i = n-2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int up = dp[i+1][j];
                int dg = dp[i+1][j+1];
                dp[i][j] = arr[i][j] + Math.min(up, dg);
            }
        }
        return dp[0][0];
    }
    
    public static int minPathSO(int[][] arr, int n){
        
        int[] front = new int[n];
        for(int i = 0; i < n; i++){
            front[i] = arr[n-1][i];
        }
        
        for(int i = n-2; i >= 0; i--){
            int[] dp = new int[i+1];
            for(int j = i; j >= 0; j--){
                int up = front[j];
                int dg = front[j+1];
                dp[j] = arr[i][j] + Math.min(up, dg);
            }
            front = dp;
        }
        return front[0];
    }
}