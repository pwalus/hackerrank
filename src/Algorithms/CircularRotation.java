package Algorithms;

import java.io.*;
import java.util.*;

public class CircularRotation {

    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] rotated = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            rotated[((i + (k % a.length)) % a.length)] = a[i];
        }

        for (int i = 0; i < queries.length; i++) {
            queries[i] = rotated[queries[i]];
        }

        return queries;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nkq = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nkq[0]);
        int k = Integer.parseInt(nkq[1]);
        int q = Integer.parseInt(nkq[2]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] queries = new int[q];
        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);
        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
