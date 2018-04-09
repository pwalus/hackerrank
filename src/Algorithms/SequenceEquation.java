package Algorithms;

import java.util.Scanner;

public class SequenceEquation {

    public static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            result[i] = findValue(findValue(i + 1, p), p);
        }

        return result;
    }

    public static int findValue(int value, int[] p) {
        for (int i = 0; i < p.length; i++) {
            if (value == p[i]) {
                return i + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
