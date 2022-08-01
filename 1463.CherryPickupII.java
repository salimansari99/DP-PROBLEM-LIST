class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // int ans = f(grid, 0, 0, m-1, new int[n][m][m]);
        // return ans;
        return pickupSO(grid, n, m);
    }
    
    public static int f(int[][] grid, int i, int j1, int j2, int[][][] dp){
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) return (int)-1e8;
        if(i == grid.length - 1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != 0) return dp[i][j1][j2];
        int ans = -(int)1e8;
        for(int dj1 = -1; dj1 <= 1; dj1++){
            for(int dj2 = -1; dj2 <= 1; dj2++){
                int temp = 0;
                if(j1 == j2){
                    temp = grid[i][j1];  
                }
                else{
                    temp = grid[i][j1] + grid[i][j2];
                }
                temp += f(grid, i+1, j1+dj1, j2+dj2, dp);
                ans = Math.max(ans, temp);
            }
        }
        return dp[i][j1][j2] = ans;
    }
    
    public static int pickupDP(int[][] grid, int n, int m){
        
        int[][][] dp = new int[n][m][m];
        
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }
        
        for(int i = n-2; i >= 0; i--){
            
            for(int j1 = 0; j1 < m; j1++){
                
                for(int j2 = 0; j2 < m; j2++){
                    
                    int ans = -(int)1e8;
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int temp = -(int)1e8;
                            if(j1 == j2){
                                temp = grid[i][j1];  
                            }
                            else{
                                temp = grid[i][j1] + grid[i][j2];
                            }
                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                temp += dp[i+1][j1+dj1][j2+dj2];
                            else temp += -(int)1e8;
                            
                            ans = Math.max(ans, temp);
                        }
                    }
                    dp[i][j1][j2] = ans;
                }
                
            }
        }
        return dp[0][0][m-1];
    }
    
    public static int pickupSO(int[][] grid, int n, int m){
        
        int[][] front = new int[m][m];
        
        for(int j1 = 0; j1 < m; j1++){
            for(int j2 = 0; j2 < m; j2++){
                if(j1 == j2) front[j1][j2] = grid[n-1][j1];
                else front[j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }
        
        for(int i = n-2; i >= 0; i--){
            int[][] curr = new int[m][m];
            for(int j1 = 0; j1 < m; j1++){
                
                for(int j2 = 0; j2 < m; j2++){
                    
                    int ans = -(int)1e8;
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int temp = -(int)1e8;
                            if(j1 == j2){
                                temp = grid[i][j1];  
                            }
                            else{
                                temp = grid[i][j1] + grid[i][j2];
                            }
                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                temp += front[j1+dj1][j2+dj2];
                            else temp += -(int)1e8;
                            
                            ans = Math.max(ans, temp);
                        }
                    }
                    curr[j1][j2] = ans;
                }
                
            }
            front = curr;
        }
        return front[0][m-1];
    }
}