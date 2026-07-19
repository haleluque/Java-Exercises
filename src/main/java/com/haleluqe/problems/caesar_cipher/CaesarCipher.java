package com.haleluqe.problems.caesar_cipher;

import java.io.*;

public class CaesarCipher {

    public static String caesarCipher(String s, int k) {
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                int newPosition = (arr[i] - 'a' + k) % 26;
                arr[i] = (char) ('a' + newPosition);
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                int newPosition = (arr[i] - 'A' + k) % 26;
                arr[i] = (char) ('A' + newPosition);
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
