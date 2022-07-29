public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
       if(n == 0) return 0;
        //return maxPoint(points, n-1, 3, new int[n][4]);
        return maxPointSO(points, n);
    }
    
    public static int maxPoint(int[][] points, int ind, int task, int[][] dp){
        if(ind == 0){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < points[0].length; i++){
                if(i != task){
                    max = Math.max(max, points[ind][i]);
                }
            }
            return max;
        }
        if(dp[ind][task] != 0) return dp[ind][task];
        int maxMeritPoint = Integer.MIN_VALUE;
        
        for(int i = 0; i < points[0].length; i++){
            if(i != task){
                int point = points[ind][i] + maxPoint(points, ind-1, i, dp);
                 maxMeritPoint = Math.max(maxMeritPoint, point);
                //dp[ind][i] = maxMeritPoint;
            } 
        }
        return dp[ind][task] = maxMeritPoint;
    }
    
    public static int maxPointDP(int[][] points, int n){
        
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][3]));
        
        for(int days = 1; days < n; days++){
            for(int last = 0; last < 4; last++){
                 int max = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                       int point = points[days][task] + dp[days-1][task]; 
                       max = Math.max(max, point);
                    }
                }
               dp[days][last] = max;
            }    
        }
        return dp[n-1][3];
    }
    
    public static int maxPointSO(int[][] points, int n){
        int[] prev = new int[4];
        
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(prev[0], Math.max(prev[1], prev[2]));
        
        for(int d = 1; d < n; d++){
            int[] dp = new int[4];
            for(int l = 0; l < 4; l++){
                int max = 0;
                for(int t = 0; t < 3; t++){
                    if(t != l){
                        int point = points[d][t] + prev[t];
                        max = Math.max(point, max);
                    }
                }
                dp[l] = max;
            }
            prev = dp;
        }
        return prev[3];
    }
}