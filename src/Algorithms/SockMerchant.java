package Algorithms;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SockMerchant {

    public static final int MAX = 101;

    static int sockMerchant(int n, int[] ar) {
        int[] pairs = new int[MAX];
        for (int i = 0; i < ar.length; i++) {
            pairs[ar[i]]++;
        }

        return Arrays.stream(pairs).map(item -> {
            if(item > 0)
                return (int)Math.floor(item / 2);
            else
                return 0;
        }).sum();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
