import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		
        //return path(m-1, n-1);
        //return pathMem(m-1, n-1, new int[m][n]);
        //return pathDP(m, n);
        return pathSO(m, n);
	}
    public static int path(int x, int y){
        if(x == 0 && y == 0) return 1;
        if(x < 0 || y < 0) return 0;
        
        int up = path(x-1, y);
        int left = path(x, y-1);
        return up + left;
    }
    
    public static int pathMem(int x, int y, int[][] dp){
        if(x == 0 && y == 0) return 1;
        if(x < 0 || y < 0) return 0;
        if(dp[x][y] != 0) return dp[x][y];
        
        int up = pathMem(x-1, y, dp);
        int left = pathMem(x, y-1, dp);
        return dp[x][y] = up + left;
    }
    
    public static int pathDP(int m, int n){
        if(m == 1 || n == 1) return 1;
        
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    
    public static int pathSO(int m, int n){
        if(m == 1 || n == 1) return 1;
        
        int[] prev = new int[n];
        
        for(int i = 0; i < m; i++){
            int[] dp = new int[n];
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[j] = 1;
                }
                else{
                    dp[j] = prev[j] + dp[j-1];
                } 
            }
            prev = dp;
        }
        return prev[n-1];
    }
}