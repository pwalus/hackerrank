package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class CircularRotation {

    protected static boolean outOfRange;

    protected static int moved = 0;

    static int[] circularArrayRotation(int[] a, int[] m, int k) {
        int temp;
        int idx = 0;
        int x;
        int nextIdx;
        while(moved < a.length){
            temp = a[idx];
//            outOfRange = false;
//            while (!outOfRange) {
                nextIdx = getNextIdx(idx, k, a.length);
                x = a[nextIdx];
                a[nextIdx] = temp;
                temp = x;
                idx = nextIdx;
//            }
        }

        System.out.println(Arrays.toString(a));

        int[] cos = new int[2];
        return cos;
    }

    public static int getNextIdx(int idx, int k, int n) {
        idx += k;
        if (idx > n - 1) {
            outOfRange = true;
            return Math.abs(n - idx);
        }

        return idx;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] m = new int[q];
        for (int m_i = 0; m_i < q; m_i++) {
            m[m_i] = in.nextInt();
        }
        int[] result = circularArrayRotation(a, m, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
