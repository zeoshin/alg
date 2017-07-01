package CombinationSumIV;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
        	for (int n : nums) {
        		if (i >= n) dp[i] += dp[i - n];
        	}
        }
        return dp[target];
    }
    
    public static void main(String[] args) {
    	int[] nums = {1, 4, 2};
    	int target = 32;
    	System.out.println(combinationSum4(nums, target));
    }
}
