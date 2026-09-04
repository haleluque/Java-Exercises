package com.haleluqe.problems.others.recursive_digit_sum;

import java.io.*;

public class RecursiveDigitSum {
    public static int superDigit(String n, int k) {
        String number = String.valueOf(superDigitSum(n) * k);
        return Integer.parseInt(reduceNumber(number));
    }

    private static String reduceNumber(String number) {
        String repeatedNumberSum = String.valueOf(superDigitSum(number));
        if (repeatedNumberSum.length() > 1) {
            return reduceNumber(repeatedNumberSum);
        }
        else {
            return repeatedNumberSum;
        }
    }

    public static long superDigitSum(String number) {
        int superDigit = 0;
        for (int i = 0; i < number.length(); i++) {
            superDigit += number.charAt(i) - '0';
        }
        return superDigit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
