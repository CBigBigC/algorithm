package com.watson.algorithm.回溯法;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class AllRange {
    // 最终结果
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        // 访问标志位
        int[] mark = new int[nums.length];
        List<Integer> resultTemp = new ArrayList<>();

        realPermute(nums, mark, resultTemp);
        return result;

    }

    private void realPermute(int[] nums, int[] mark, List<Integer> resultTemp) {

        // 结束标志：两个size一致
        if (resultTemp.size() == nums.length) {
            result.add(new ArrayList<>(resultTemp));
            return;
        }

        for (int i = 0; i < mark.length; i ++) {
            // 如果已经被使用了，继续寻找
            if (mark[i] == 1) continue;
            // 没有被使用，加入使用队列、标记为已经使用
            resultTemp.add(nums[i]);
            mark[i] = 1;
            // 进入下一层
            realPermute(nums, mark, resultTemp);
            // 关键:回溯！回溯！
            mark[i] = 0;
            resultTemp.removeLast();

        }

    }

}
