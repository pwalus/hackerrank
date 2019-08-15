package algorithms.data_structures.array;

import java.io.*;
import java.util.*;

public class TwoDArray {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] sum = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum[i][j] = sumArray(arr, i, j);
            }
        }

        return find(sum);
    }

    private static int find(int[][] sum) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum.length; j++) {
                if (sum[i][j] > max) {
                    max = sum[i][j];
                }
            }
        }

        return max;
    }

    private static int sumArray(int[][] arr, int i, int j) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2]
            + arr[i + 1][j + 1]
            + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
