import java.util.*;
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n = nums.size();
        //return maxSumMem(nums, n-1, new int[n]);
        return maxSumSO(nums);
        
	}
    public static int maxSum(ArrayList<Integer> nums, int ind){
        if(ind == 0) return nums.get(ind);
        if(ind < 0) return 0;
        int pick = nums.get(ind) + maxSum(nums, ind-2);
        int notpick = 0 + maxSum(nums, ind-1);
        return Math.max(pick, notpick);
    }
    
    public static int maxSumMem(ArrayList<Integer> nums, int ind, int[] dp){
        if(ind == 0) return nums.get(ind);
        if(ind < 0) return 0;
        if(dp[ind] != 0) return dp[ind];
        int pick = nums.get(ind) + maxSumMem(nums, ind-2, dp);
        int notpick = 0 + maxSumMem(nums, ind-1, dp);
        return dp[ind] = Math.max(pick, notpick);
    }
    
    public static int maxSumDP(ArrayList<Integer> nums, int[] dp){
        if(nums.size() == 1) return nums.get(0);
        
        dp[0] = nums.get(0);
        int n = nums.size();
        for(int i = 1; i < n; i++){
            int pick = nums.get(i);
            if(i > 1) pick += dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n-1];
    }
    
    public static int maxSumSO(ArrayList<Integer> nums){
        int n = nums.size();
        if(n == 1) return nums.get(0);
        
        int a = 0;
        int b = nums.get(0);
        
        for(int i = 1; i < n; i++){
            int pick = nums.get(i) + a;
            int notpick = b;
            int curr = Math.max(pick, notpick);
            a = b;
            b = curr;
        }
        return b;
    }
}