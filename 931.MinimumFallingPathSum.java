class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int mn = Integer.MAX_VALUE;
        int n = matrix.length, m = matrix[0].length;
        /*
        for(int j = 0; j < m; j++){
            mn = Math.min(mn, fMem(n-1, j, matrix, new int[n][m]));
        }
        */
        //return fDP(matrix, n, m);
        return fSO(matrix, n, m);
    }
    public static int f(int i, int j, int[][] matrix){
        if(j < 0 || j>= matrix.length) return (int)1e8;
        if(i == 0) return matrix[i][j];
        
        int left = matrix[i][j] + f(i-1, j-1, matrix);
        int right = matrix[i][j] + f(i-1, j+1, matrix);
        int down = matrix[i][j] + f(i-1, j, matrix);
        return Math.min(left, Math.min(right, down));
    }
    public static int fMem(int i, int j, int[][] matrix, int[][] dp){
        if(j < 0 || j>= matrix.length) return (int)1e8;
        if(i == 0) return matrix[i][j];
        if(dp[i][j] != 0) return dp[i][j];
        
        int left = matrix[i][j] + fMem(i-1, j-1, matrix, dp);
        int right = matrix[i][j] + fMem(i-1, j+1, matrix, dp);
        int down = matrix[i][j] + fMem(i-1, j, matrix, dp);
        return dp[i][j] = Math.min(left, Math.min(right, down));
        
    }
    
    public static int fDP(int[][] matrix, int n, int m){
        int[][] dp = new int[n][m];
        
        for(int i = 0; i < m; i++) dp[0][i] = matrix[0][i];
        
        for(int i = 1; i < n; i++){
            
            for(int j = 0; j < m; j++){
                int down = matrix[i][j] + dp[i-1][j];
                int left = matrix[i][j];
                if(j > 0) left += dp[i-1][j-1];
                else left = (int)1e8;
                int right = matrix[i][j];
                if(j < m-1) right += dp[i-1][j+1];
                else right = (int)1e8;
                
                dp[i][j] = Math.min(down, Math.min(left, right));
            }
        }
        
        int res = (int)1e8;
        for(int i = 0; i < m; i++)
            res = Math.min(res, dp[n-1][i]);
        
        return res;
        
    }
    
    public static int fSO(int[][] matrix, int n, int m){
       int[] dp = new int[m];
        
        for(int i = 0; i < m; i++) dp[i] = matrix[0][i];
        
        for(int i = 1; i < n; i++){
            int[] curr = new int[m];
            for(int j = 0; j < m; j++){
                int down = matrix[i][j] + dp[j];
                int left = matrix[i][j];
                if(j > 0) left += dp[j-1];
                else left = (int)1e8;
                int right = matrix[i][j];
                if(j < m-1) right += dp[j+1];
                else right = (int)1e8;
                
                curr[j] = Math.min(down, Math.min(left, right));
            }
            dp = curr;
        }
        
        int res = (int)1e8;
        for(int i = 0; i < m; i++)
            res = Math.min(res, dp[i]);
        
        return res; 
    }
}