package Algorithms;

import java.util.Scanner;

public class JavaLoops {

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            for (int x = 0; x < n; x++) {
                int value = a;
                for (int j = x; j >= 0; j--) {
                    value += Math.pow(2, j) * b;
                }
                System.out.print(value + " ");
            }
            System.out.println();
        }
        in.close();
    }


}
