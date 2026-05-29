package com.haleluqe.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public static void main(String[] args) {
        String mainWord = "ADOBECODEBANC";
        String window = "ABC";
        System.out.println(findMinSubStringWindow(mainWord, window));
    }

    public static String findMinSubStringWindow(String mainWord, String window) {
        Map<Character, Integer> targetMap = new HashMap<>();
        countRepeatedLetter(window, targetMap);
        int left = 0;
        int need = targetMap.size(); // Esto te da el número de caracteres únicos
        int have = 0;
        int right;

        Map<Character, Integer> windowMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int resStart = 0;

        for (right = 0; right < mainWord.length(); right++) {
            //extraer el character
            char letra = mainWord.charAt(right);
            windowMap.merge(letra, 1, Integer::sum);
            if (targetMap.containsKey(letra) &&
                    windowMap.get(letra).intValue() == targetMap.get(letra).intValue()) {
                have++;
            }

            while (left < right && need == have) {
                // 1. Antes de quitar nada, ¿es esta la ventana más corta vista hasta ahora?
                int currentWindowSize = right - left + 1;
                if (currentWindowSize < minLen) {
                    minLen = currentWindowSize;
                    resStart = left;
                }

                char removedLetter = mainWord.charAt(left);
                windowMap.merge(removedLetter, 1, (val1, val2) -> val1 - val2);
                if (targetMap.containsKey(removedLetter) &&
                        windowMap.get(removedLetter).intValue() < targetMap.get(removedLetter).intValue()) {
                    have--;
                }
                left++;
            }
        }

        // RETORNO FINAL (Usando el récord guardado)
        return minLen == Integer.MAX_VALUE ? "" : mainWord.substring(resStart, resStart + minLen);
    }

    private static Map<Character, Integer> countRepeatedLetter(String subWord, Map<Character, Integer> map) {
        for (int i = 0; i < subWord.length(); i++) {
            char letter = subWord.charAt(i);
            map.merge(letter, 1, Integer::sum);
        }
        return map;
    }
}
