package com.haleluqe.problems.others.new_year_chaos;

import java.io.IOException;
import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;

        for (int i = 0; i < q.size(); i++) {
            // Someone moved more than 2 positions ahead of their original place
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count how many larger stickers ended up in front of this person.
            // Because nobody can move forward more than 2, only a small window matters.
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) throws IOException {
        List<Integer> q = List.of(2,1,5,3,4);
        minimumBribes(q);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, t).forEach(tItr -> {
//            try {
//                int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                minimumBribes(q);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
    }
}
