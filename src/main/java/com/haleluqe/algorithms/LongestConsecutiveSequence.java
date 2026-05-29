package com.haleluqe.algorithms;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{0,3,7,2,5,8,4,6,0,1};
        //Integer[] numbers = new Integer[]{100,4,200,1,3,2};
        HashSet<Integer> noRepeated = new HashSet<>(Arrays.asList(numbers));
        System.out.println(longestConsecutiveSequence(noRepeated));
    }

    /**
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     *
     * Example 1:
     * Input: nums = [100, 4, 200, 1, 3, 2]
     * Output: 4
     * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * Example 2:
     * Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
     * Output: 9
     */
    public static int longestConsecutiveSequence(HashSet<Integer> noRepeated) {
        int longestStreak = 0;
        for (Integer num : noRepeated) {
            if (!noRepeated.contains(num - 1)) {
                //Count from here
                int counter = 0;
                while (noRepeated.contains(num + counter)) {
                    counter++;
                }
                longestStreak = Math.max(longestStreak, counter);
            }
        }
        return longestStreak;
    }
}
