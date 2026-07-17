package com.haleluqe.problems.min_max_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class minMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .toList();

        miniMaxSum(arr);

        bufferedReader.close();
    }

    public static void miniMaxSum(List<Integer> arr) {
        long totalSum = arr.stream().mapToLong(Integer::longValue).sum();
        int minValue = arr.stream().min(Comparator.comparingInt(Integer::intValue)).get();
        int maxValue = arr.stream().max(Comparator.comparingInt(Integer::intValue)).get();
        System.out.println((totalSum - maxValue) + " " + (totalSum - minValue));
    }
}
