package com.watson.algorithm.动态规划;


import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class MoneyQuestion {



    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[Integer.MAX_VALUE];
        Arrays.fill(dp, -2);
        return realCoinChange(coins, amount, dp);
    }

    public int realCoinChange(int[] coins, int amount, int[] dp) {
        if (amount< 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount - 1] != -2) {
            return dp[amount - 1];
        }

        // 子迭代中最小的个数
        int minNumTemp = Integer.MAX_VALUE;

        for (Integer coin : coins) {
            int minNum = realCoinChange(coins, amount - coin, dp);
            if (minNum < 0) continue;
            minNumTemp = Math.min(minNumTemp, minNum);
        }
        dp[amount - 1] = minNumTemp + 1;
        return minNumTemp + 1;

    }

}
