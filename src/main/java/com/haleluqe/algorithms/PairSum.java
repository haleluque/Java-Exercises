package com.haleluqe.algorithms;

import java.util.HashSet;

public class PairSum {
    /**
     * Dado un arreglo de números enteros llamado nums y un número entero objetivo, identifica si existen dos números
     * dentro del arreglo que, al sumarse, den como resultado exacto el valor de objetivo.
     * Reglas del juego:
     * No puedes usar el mismo elemento dos veces (es decir, no puedes sumar el número en la posición i consigo mismo).
     * Para esta primera etapa, solo necesito que determines si existen (un simple "Verdadero" o "Falso").
     * Asume que el arreglo no está ordenado.
     */
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{10,5,2,3,7,5,11,25,30,4,99,16,64};
        Integer objetivo = 35;

        PairSum.alternativa2(arr, objetivo);
    }

    /**
     * Cuando no se puede ordenar, se usa
     **/
    public static void alternativa2(Integer[] arr, Integer objetivo) {
        HashSet<Integer> bolsa = new HashSet<>();
        boolean isPresent = false;
        for (Integer integer : arr) {
            int complemento = objetivo - integer;
            if (bolsa.contains(complemento)) {
                isPresent = true;
                break;
            }
            else {
                bolsa.add(integer);
            };
        }
        System.out.println(isPresent ? "YES" : "NO");
    }

    /**
     * Se ordena el array si es posible y se usan punteros en cada esquina
     **/
    public static void alternativa1(Integer[] arr, Integer objetivo) {
        //Sort the array
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        //Practical way
        //Arrays.sort(arr);

        //Arrays.stream(arr).forEach(System.out::println);

        int izq = 0;
        int der = arr.length - 1;
        boolean isPresent = false;
        while(!isPresent){
            int tempSum = arr[izq] + arr[der];
            if(tempSum == objetivo){
                isPresent = true;
            }
            else if(tempSum < objetivo){
                izq = izq + 1;
            }
            else {
                der = der - 1;
            }

            if(izq == der){
                break;
            }
        }

        System.out.println(isPresent ? "YES" : "NO");
    }
}
