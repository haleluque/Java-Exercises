package com.haleluqe.problems.lonely_integer;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class LonelyInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = lonelyInteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int lonelyInteger(List<Integer> a) {
        Map<Integer, Long> map =
                a.stream()
                        .collect(
                                Collectors.groupingBy(
                                        num -> num,
                                        Collectors.counting()));
        return map.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
    }
}
