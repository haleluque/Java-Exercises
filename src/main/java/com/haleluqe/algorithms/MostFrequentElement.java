package com.haleluqe.algorithms;

import java.util.*;

public class MostFrequentElement {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,1,1,2,2,3};
        int k = 2;
        MostFrequentElement.mostKFrequentElements(nums, k);
        System.out.println(MostFrequentElement.mostFrequentElement(nums));
    }

    /**
     * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
     *
     * Example 1:
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     *
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     */
    public static void mostKFrequentElements(Integer[] nums, int k) {
        Map<Integer, Integer> repeated = new HashMap<>();
        for (Integer num : nums) {
            if (repeated.containsKey(num)) {
                repeated.put(num, repeated.get(num) + 1);
            } else {
                repeated.put(num, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(repeated.entrySet());
        list.sort((o1, o2) ->  o2.getValue().compareTo(o1.getValue()));

        Integer[] result = new Integer[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        System.out.println(Arrays.toString(result));
    }

    /**
     * Most frequent element, but extracts one
     */
    public static int mostFrequentElement(Integer[] nums) {
        Map<Integer, Integer> repeated = new HashMap<>();
        for (Integer num : nums) {
            if (repeated.containsKey(num)) {
                repeated.put(num, repeated.get(num) + 1);
            } else {
                repeated.put(num, 1);
            }
        }

        Integer value = 0;
        Integer freq = 0;
        for (Map.Entry<Integer, Integer> entry : repeated.entrySet()) {
            if (entry.getValue() > freq) {
                value = entry.getKey();
                freq = entry.getValue();
            }
        }

        return value;
    }
}
