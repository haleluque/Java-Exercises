package com.haleluqe.problems.plus_minus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        PlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
    
    public static void plusMinus(List<Integer> arr) {
        Map<String, Long> countMap = arr
                .stream()
                .collect(
                        Collectors.groupingBy(
                                num -> num > 0 ? "positive" : num < 0 ? "negative" : "zero",
                                Collectors.counting()));
        arr.stream()
                .collect(
                        Collectors.groupingBy(
                                num -> num > 0 ? "positive" : num < 0 ? "negative": "zero",
                                Collectors.counting()
                        ));
        
        roundAndPrintNumber(countMap.getOrDefault("positive", 0L) / (double) arr.size());
        roundAndPrintNumber(countMap.getOrDefault("negative", 0L) / (double) arr.size());
        roundAndPrintNumber(countMap.getOrDefault("zero", 0L) / (double) arr.size());
    }

    public static void roundAndPrintNumber(double number) {
        String formatted = String.format("%.6f", number);
        System.out.println(formatted);
    }
}

