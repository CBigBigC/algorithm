package com.watson.algorithm.动态规划;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 */
public class LIS {

    public int lengthOfLIS(int[] nums) {
        // 递推，dp[i]标识以下标i结尾的LIS，
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int currentMax = 0;

        for (int i = 1; i < nums.length; i ++) {
            int tempMax =  1;
            for (int j = 0; j < i; j ++) {
                if (nums[i] > nums[j]) {
                    tempMax = Math.max(dp[j] + 1, tempMax);
                }
            }
            dp[i] = tempMax;
            currentMax = Math.max(currentMax, tempMax);
        }
        return currentMax;
    }
}
