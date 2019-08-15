package algorithms.data_structures.array;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

    private static class Result {

        private static Integer lastAnswer = 0;

        private static List<List<Integer>> sequenceList;

        private static List<Integer> toPrint;


        /*
         * Complete the 'dynamicArray' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. 2D_INTEGER_ARRAY queries
         */

        public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
            initialize(n);
            for (List<Integer> query : queries) {
                if (query.get(0) == 1) {
                    addByFirstMethod(query.get(1), query.get(2), n);
                } else {
                    addBySecondMethod(query.get(1), query.get(2), n);
                }
            }

            return toPrint;
        }

        private static void addByFirstMethod(Integer x, Integer y, Integer n) {
            int index = ((x ^ lastAnswer) % n);
            sequenceList.get(index).add(y);
        }

        private static void addBySecondMethod(Integer x, Integer y, Integer n) {
            int index = ((x ^ lastAnswer) % n);
            List<Integer> sequence = sequenceList.get(index);
            lastAnswer = sequence.get(y % sequence.size());
            toPrint.add(lastAnswer);
        }

        private static void initialize(int n) {
            sequenceList = new ArrayList<>(n);
            toPrint = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                sequenceList.add(i, new ArrayList<>());
            }
        }

    }
}
