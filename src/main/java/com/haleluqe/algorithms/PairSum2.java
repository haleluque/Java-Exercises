package com.haleluqe.algorithms;

import java.util.Arrays;

public class PairSum2 {
    public static void main(String[] args) {
        //Integer[] numbers = {2,7,11,15};
        Integer[] numbers = {2,3,4};
        int target = 6;
        //int target = 9;
        Integer[] result = findPairSumIndexes(numbers, target);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Problem: 167. Two Sum II - Input Array Is Sorted
     * Difficulty: Medium
     * Constraint: Your solution must use only constant extra space (O(1)).
     * Description: Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
     * find two numbers such that they add up to a specific target number.
     *
     * Example 1:
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2.
     * We return [1, 2].
     */
    public static Integer[] findPairSumIndexes(Integer[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int leftNumber = numbers[left];
            int rightNumber = numbers[right];
            if (leftNumber + rightNumber == target) {
                return new Integer[]{left + 1, right + 1};
            }

            if (leftNumber + rightNumber > target) {
                right--;
            }
            else {
                left++;
            }
        }

        return new Integer[]{};
    }
}
