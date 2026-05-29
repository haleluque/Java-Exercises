package com.haleluqe.algorithms;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{1,8,6,2,5,9,8,3,7};
        System.out.println(calculateMaxContainerSize(numbers));
    }

    /**
     * Difficulty: Medium
     * Pattern: Two PointersSpace
     * Complexity: O(1) (Constant Space)
     * Time Complexity: O(n)
     *
     * Problem Description:
     * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
     * of the i^th line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Notice: You may not slant the container. The water level is determined by the shorter of the two lines.
     */
    public static int calculateMaxContainerSize(Integer[] numbers) {
        int right = numbers.length - 1;
        int left = 0;
        int area = 0;
        while (left < right) {
            int weight = right - left;
            int height = Math.min(numbers[left], numbers[right]);
            int tempArea = height * weight;
            if (tempArea > area) {
                area = tempArea;
            }

            if (numbers[left] < numbers[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return area;
    }
}
