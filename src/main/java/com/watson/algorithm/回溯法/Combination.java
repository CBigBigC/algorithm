package com.watson.algorithm.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class Combination {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 数字0~9的使用标识，0标识未使用，1标识已经使用过
        int[] mark = new int[9];
        // 当前DFS的已选数列
        List<Integer> single = new ArrayList<>();

        doCombine(k, n, mark, single);

        return result;
    }

    private void doCombine(int k, int n, int[] mark, List<Integer> single) {

        if (single.size() == k) {
            if ( single.stream().mapToInt(Integer::intValue).sum() == n) {
                result.add(new ArrayList<>(single));
            }
            return;
        }

        int currentMaxNum = single.isEmpty() ? 0 : single.getLast() - 1;
        for(int i = currentMaxNum; i < mark.length; i ++) {
            if(mark[i] == 1) continue;
            // 判断当前数字是否可用
            boolean legal = judgeLegal(single, i + 1, n);
            if (!legal) {
                continue;
            }
            single.add(i + 1);
            mark[i] = 1;
            doCombine(k, n, mark, single);
            mark[i] = 0;
            single.removeLast();
        }
    }

    private boolean judgeLegal(List<Integer> single, int availableNumber, int n) {
        return availableNumber <=  n - single.stream().mapToInt(Integer::intValue).sum();
    }

}
