package com.haleluqe.algorithms;

import java.util.*;

public class temp {
    public static void main(String[] args) {
        List<String> repeated = new ArrayList<>();
        repeated.add("a");
        repeated.add("b");
        repeated.add("c");
        repeated.add("a");
        repeated.add("b");
        repeated.add("h");
        repeated.add("z");
        System.out.println(countRepeatedStrings(repeated));
    }

    public static int countRepeatedStrings(List<String> repeated) {
        Map<String, Integer> map = new HashMap<>();

        for (String  s : repeated) {
            map.merge(s, 1, Integer::sum);
        }

        return map.values().stream().filter(num -> num > 1).mapToInt(Integer::intValue).sum();
    }
}
