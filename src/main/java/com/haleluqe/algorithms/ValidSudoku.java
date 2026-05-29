package com.haleluqe.algorithms;

import java.util.HashSet;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        HashSet<String> repeated = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        boolean isValid = isValid(board, repeated, builder);

        System.out.println(isValid ? "VALID" : "INVALID");
    }

    /**
     * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
     * - Each row must contain the digits 1-9 without repetition.
     * - Each column must contain the digits 1-9 without repetition.
     * - Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * Note:A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     */
    public static boolean isValid(char[][] board, HashSet<String> repeated, StringBuilder builder) {
        boolean isValid;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                String fila = buildText(builder, board[i][j], "fila", i);
                String columna = buildText(builder, board[i][j], "columna", j);
                String bloque = calculateBlock(builder, board[i][j], i, j);
                isValid = addItem(repeated, fila);
                if (!isValid) {
                    return false;
                }
                isValid = addItem(repeated, columna);
                if (!isValid) {
                    return false;
                }
                isValid = addItem(repeated, bloque);
                if (!isValid) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String calculateBlock(StringBuilder builder, char value, int i, int j) {
        builder.setLength(0);
        int filaInx = i / 3;
        int columnaInx = j / 3;
        return builder.append(value).append(" en bloque").append(filaInx).append("-").append(columnaInx).toString();
    }

    public static String buildText(StringBuilder builder, char value, String rowOrCol, int index) {
        builder.setLength(0);
        return builder.append(value).append(" en ").append(rowOrCol).append(" ").append(index).toString();
    }

    public static boolean addItem(HashSet<String> lista, String value) {
        if (lista.contains(value)) {
            return false;
        }
        else {
            lista.add(value);
            return true;
        }
    }
}
