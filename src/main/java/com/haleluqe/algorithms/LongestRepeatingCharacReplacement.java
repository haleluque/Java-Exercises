package com.haleluqe.algorithms;

import java.util.HashMap;

public class LongestRepeatingCharacReplacement {
    public static void main(String[] args) {
        String word = "AABABBA";
        int k = 1;
        System.out.println(calculateSubstringWindows(word, k));
    }

    /**
     * Problem: 424. Longest Repeating Character Replacement
     * Difficulty: Medium
     * Pattern: Sliding Window (Optimized)
     * Time Complexity: O(n) — We traverse the string once with two pointers.
     * Space Complexity: $O(1)$ — We use a fixed-size array of 26 integers regardless of input size.
     * Core Concept
     * The problem asks for the longest substring where, after replacing at most k characters, all characters are the same.
     * A window is valid if:
     * - Window size - Count of most frequent character <= kKey Optimization
     * - Instead of re-scanning the window to find the most frequent character (which would lead to O(n^2),
     * we maintain a sliding frequency array.
     *
     * We only update the maxRepeatCount when a new character enters the window from the right.
     * Even if the actual max frequency inside the window decreases when moving the left pointer,
     * we don't need to update maxRepeatCount downwards because we are only looking for a window that exceeds our current maximum.
     */
    public static int calculateSubstringWindowsOptimized(String word, int k) {
        int left = 0;
        int maxWindowSize = 0;
        int maxRepeatCount = 0;
        // Usamos un arreglo de 26 para letras A-Z (más rápido que HashMap)
        int[] counts = new int[26];

        for (int right = 0; right < word.length(); right++) {
            // 1. Actualizar el conteo del nuevo carácter que entra (O(1))
            int charIndex = word.charAt(right) - 'A';
            counts[charIndex]++;

            // 2. Actualizar el carácter más repetido visto hasta ahora
            maxRepeatCount = Math.max(maxRepeatCount, counts[charIndex]);

            // 3. Si la ventana es inválida, la desplazamos (no necesitamos un while si solo queremos el máximo)
            int currentWindowSize = right - left + 1;
            if (currentWindowSize - maxRepeatCount > k) {
                counts[word.charAt(left) - 'A']--;
                left++;
            }

            // 4. El tamaño de la ventana después del ajuste es nuestro candidato a máximo
            maxWindowSize = Math.max(maxWindowSize, right - left + 1);
        }

        return maxWindowSize;
    }

    public static int calculateSubstringWindows(String word, int k){
        int left = 0;
        int right = 0;
        int maxWindowSize = 0;

        while (right < word.length()){
            String subString = word.substring(left, right + 1);
            int windowSize = subString.length();
            int maxRepeated = calculateMaxRepeatedCharacterOfWindow(subString);
            int calculation = windowSize - maxRepeated;
            if (calculation <= k) {
                maxWindowSize = Math.max(maxWindowSize, maxRepeated);
                right++;
            }
            else {
                left++;
            }
        }

        return maxWindowSize;
    }

    public static int calculateMaxRepeatedCharacterOfWindow(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxRepeated = 0;

        for (Character c : word.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);

            if (count > maxRepeated) {
                maxRepeated = count;
            }
        }

        return maxRepeated;
    }
}
