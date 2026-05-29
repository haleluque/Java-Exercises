package com.haleluqe.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,4,3,5,8};
        System.out.println(ContainsDuplicate.containsDuplicate(nums));
    }

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     * Example 1:
     * Input: nums = [1, 2, 3, 1]
     * Output: true
     *
     * Example 2:
     * Input: nums = [1, 2, 3, 4]
     * Output: false
     *
     * Example 3:
     * Input: nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
     * Output: true
     */
    public static boolean containsDuplicate(Integer[] nums) {
        Set<Integer> list = new HashSet<>();
        boolean exist = false;
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                exist = true;
            }
            else {
                list.add(nums[i]);
            }
        }
        return exist;
    }
}
