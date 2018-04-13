package Algorithms;

import java.util.Scanner;

public class JumpingOnTheCloudsSecond {
    static int jumpingOnClouds(int[] c) {
        int result = 0;
        int i = 0;
        while (i < c.length) {
            int end = 0;
            for (int j = 2; j > 0; j--) {
                if (i + j >= c.length) {
                    end++;
                    continue;
                }

                if (c[i + j] == 0) {
                    i += j;
                    result++;
                    break;
                }
            }
            if (end > 1) {
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
