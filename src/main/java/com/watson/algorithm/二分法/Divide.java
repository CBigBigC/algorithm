package com.watson.algorithm.二分法;

public class Divide {

    public static void main(String[] args) {
        int[] a = {-1,0,3,5,9,12};

        System.out.println(search(a, 2));
    }

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        return  realSearch(nums, target, left, right);
    }

    private static int realSearch(int[] nums, int target, int left, int right) {
        if (left < 0 || right < 0 || right >= nums.length || left >= nums.length) {
            return -1;
        }
        int mid = left + (right - left)/2;
        if (nums[mid] == target) {
            return  mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
            return realSearch(nums, target, left, right);
        } else if (nums[mid] > target) {
            right = mid - 1;
            return realSearch(nums, target, left, right);
        }
        return -1;
    }

}
