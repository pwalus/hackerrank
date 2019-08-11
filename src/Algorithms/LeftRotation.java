package Algorithms;

import java.util.*;

public class LeftRotation {

    private static void rotate(int[] a, int d) {
        int[] rotated = new int[a.length];
        int k = d % a.length;
        for (int i = 0; i < a.length; i++) {
            rotated[(a.length + (i - k)) % a.length] = a[i];
        }

        for (int i = 0; i < rotated.length; i++) {
            System.out.print(rotated[i] + " ");
        }
    }

    private static int[] reverseArray(int[] a) {
        int[] reversed = new int[a.length];
        int index = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            reversed[index] = a[i];
            index++;
        }

        return reversed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        rotate(a, d);

        scanner.close();
    }
}
