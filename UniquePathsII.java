import java.util.*;
public class Solution {
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
       // return mazePath(n-1, m-1, mat, dp);
        //return mazePathDP(n, m, mat, dp);
        return mazePathSO(n, m, mat);
    }
    public static int mazePath(int i, int j, ArrayList<ArrayList<Integer>> mat, int[][] dp){
        if(i < 0 || j < 0 || mat.get(i).get(j) == -1) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int up = mazePath(i-1, j, mat, dp);
        int left = mazePath(i, j-1, mat, dp);
        return dp[i][j] = (up%1000000007 + left%1000000007)%1000000007;
    }
    
    public static int mazePathDP(int n, int m, ArrayList<ArrayList<Integer>> mat, int[][] dp){
        int fl = 0;
        for(int i = 0; i < m; i++){
            if(mat.get(0).get(i) == 0 && fl == 0){
                dp[0][i] = 1;
            }
            else{
                fl = 1;
                dp[0][i] = 0;
            }
        }
        
        fl = 0;
        for(int i = 0; i < n; i++){
            if(mat.get(i).get(0) == 0 && fl == 0){
                dp[i][0] = 1;
            }
            else{
                fl = 1;
                dp[i][0] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                    if(mat.get(i).get(j) == 0){
                       dp[i][j] = (dp[i-1][j]%1000000007 + dp[i][j-1]%1000000007)%1000000007;
                    }
                    else{
                        dp[i][j] = 0;
                    }
                }
            }
        
        return dp[n-1][m-1];
    }
    
    public static int mazePathSO(int n, int m, ArrayList<ArrayList<Integer>> mat){
        
        int[] prev = new int[m];
        int fl = 0;
        for(int i = 0; i < m; i++){
            if(mat.get(0).get(i) == 0 && fl == 0) prev[i] = 1;
            else{
                fl = 1;
                prev[i] = 0;
            }
        }
        
        for(int i = 1; i < n; i++){
            int[] dp = new int[m];
            for(int j = 0; j < m; j++){
                if(mat.get(i).get(j) == 0){
                    if(j > 0){
                    dp[j] = (prev[j]%1000000007 + dp[j-1]%1000000007)%1000000007;
                    }
                    else{
                        dp[j] = prev[j];
                    }
                }
                else dp[j] = 0;
            }
            prev = dp;
        }
        return prev[m-1];
    }

}
