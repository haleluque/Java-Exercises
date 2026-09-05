package com.haleluqe.problems.leetCode.Medium.TopKElements;

import java.util.*;

public class TopKElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequent(arr, k);
        System.out.println(Arrays.toString(result));
    }

    /**
     * Devuelve los {@code k} elementos más frecuentes de {@code nums} (en cualquier orden).
     *
     * <p><b>Enfoque:</b>
     * <ol>
     *   <li>Contar frecuencias en un {@link HashMap} ({@code número → cantidad}).</li>
     *   <li>Mantener un min-heap ({@link PriorityQueue}) de tamaño como máximo {@code k},
     *       ordenado por frecuencia. Al superar {@code k}, se expulsa el de menor frecuencia.</li>
     *   <li>Al final el heap contiene exactamente los {@code k} más frecuentes; se extraen las keys.</li>
     * </ol>
     *
     * <p>Un min-heap de tamaño {@code k} evita ordenar todos los elementos únicos
     * ({@code O(n log n)}) y cumple el follow-up con {@code O(n log k)}.
     *
     * <p><b>Complejidad:</b> tiempo {@code O(n log k)}, espacio {@code O(n)} para el mapa
     * (y {@code O(k)} para el heap).
     *
     * @param nums arreglo de enteros
     * @param k    cantidad de elementos más frecuentes a devolver
     * @return los {@code k} números más frecuentes
     */
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
