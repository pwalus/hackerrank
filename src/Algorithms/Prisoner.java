package Algorithms;

import java.util.Scanner;

public class Prisoner {
    static int saveThePrisoner(int n, int m, int s) {
        int a = s+m-1;
        if(a>n){
            if(a%n==0){
                return n;
            }
            return a%n;
        }

        return a;
//        int value = (((m + s) % n) - 1);
//        if (value == 0)
//            return n;
//        else if (value == -1)
//            return n - 1;
//        else
//            return  value;


//        return (((m + s) % n) - 1) == 0 || (((m + s) % n) - 1) == -1 ? n : (((m + s) % n) - 1);

//        if (((m + s) % n) == 0) {
//            return n;
//        } else if (((m + s) % n) == -1) {
//            return n - 1;
//        }
//        ret/urn ((m + s) % n) - 1;
//        int prod;
//        if (m + s > n) {
//            prod = m % n;
//            return Math.abs(prod - (m + s)) - 1;
//        }
//        return (m + s) - 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int s = in.nextInt();
            int result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}
