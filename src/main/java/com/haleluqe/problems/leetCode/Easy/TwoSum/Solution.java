package com.haleluqe.problems.leetCode.Easy.TwoSum;

import java.util.HashMap;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] values = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int objective = target - nums[i];
            if (map.containsKey(objective)) {
                values[0] = map.get(objective);
                values[1] = i;
                break;
            }
            else {
                map.put(nums[i], i);
            }
        }
        return values;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
