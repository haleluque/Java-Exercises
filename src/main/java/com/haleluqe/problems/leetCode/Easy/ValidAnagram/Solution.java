package com.haleluqe.problems.leetCode.Easy.ValidAnagram;

import java.util.HashMap;

public class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        countLetters(s, map);
        subtractLetters(t, map);
        return map.isEmpty();
    }

    public static void countLetters(String s, HashMap<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
    }

    public static void subtractLetters(String s, HashMap<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            }
            if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) == 0) {
                map.remove(s.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }
}
