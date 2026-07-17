package com.haleluqe.problems.flipping_matrix;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlippingMatrix {
    public static int getSumOfQuadrant(List<List<Integer>> matrix) {
        //calcular el tamaño del cuadrante (nxn)
        int upperLeftQuadrantSize = matrix.size() / 2;
        //calcular cada uno de los candidatos de cada pocision dentro del cuadrante
        int counter = 0;
        for (int i = 0; i < upperLeftQuadrantSize; i++) {
            for (int j = 0; j < upperLeftQuadrantSize; j++) {
                List<Integer> candidates = Arrays.asList(
                        matrix.get(i).get(j),
                        matrix.get(i).get(2 * upperLeftQuadrantSize - 1 - j),
                        matrix.get(2 * upperLeftQuadrantSize - 1 - i).get(j),
                        matrix.get(2 * upperLeftQuadrantSize - 1 - i).get(2 * upperLeftQuadrantSize - 1 - j)
                );
                //elegir el mayor y pasar a la siguiente pocision
                //ir sumando el candidato mayor de cada iteracion
                counter += Collections.max(candidates);
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        List<List<Integer>> sampleMatrix = Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108)
        );

        int result = getSumOfQuadrant(sampleMatrix);
        System.out.println(result); // expected: 414
    }
}
