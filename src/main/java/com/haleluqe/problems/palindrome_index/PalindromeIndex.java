package com.haleluqe.problems.palindrome_index;

import java.io.*;
import java.util.stream.*;

public class PalindromeIndex {

    public static int palindromeIndex(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] word = s.toCharArray();

        while (i < j) {
            if (word[i] == word[j]) {
                i++;
                j--;
            } else {
                // ignore left: check [i+1 .. j]
                if (isPalindrome(word, i + 1, j)) {
                    return i;
                }
                // ignore right: check [i .. j-1]
                if (isPalindrome(word, i, j - 1)) {
                    return j;
                }
                return -1;
            }
        }

        return -1;
    }

    private static boolean isPalindrome(char[] word, int left, int right) {
        while (left < right) {
            if (word[left] != word[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = palindromeIndex(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
