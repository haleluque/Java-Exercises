package com.haleluqe.problems.leetCode.Medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxCount = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            else {
                set.add(s.charAt(right));
                maxCount = Math.max(maxCount, set.size());
                right++;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String test = "pwwkew";
        System.out.println(lengthOfLongestSubstring(test));
    }
}
