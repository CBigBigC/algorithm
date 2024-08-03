package com.watson.algorithm.动态规划;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 */
public class MatryoshkaDoll {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        int[] dp = new int[envelopes.length];
        int curMax = 0;

        for (int i = 1; i < envelopes.length; i ++) {
            int tempMax = 1;
            for(int j = 0; j < i; j ++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    tempMax = Math.max(tempMax, dp[j] + 1);
                }
            }
            curMax = Math.max(curMax, tempMax);
        }
        return curMax;
    }
}
