package com.haleluqe.problems.others.grid_challenge;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        for (int i = 0; i < grid.size(); i++) {
            char[] separated = grid.get(i).toCharArray();
            Arrays.sort(separated);
            grid.set(i, new String(separated));
        }

        for (int i = 0; i < grid.size() - 1; i++) {
            for (int j = 0; j < grid.get(i).length(); j++) {
                if (grid.get(i).charAt(j) > grid.get(i+1).charAt(j)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .toList();

                String result = gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
