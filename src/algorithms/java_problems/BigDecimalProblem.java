package algorithms.java_problems;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

class BigDecimalProblem {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        Arrays.sort(s, (x, y) -> {
            if (x == null || y == null) {
                return Integer.MAX_VALUE;
            }
            BigDecimal xD = new BigDecimal(x);
            BigDecimal yD = new BigDecimal(y);

            return yD.compareTo(xD);
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}