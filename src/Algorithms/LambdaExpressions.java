package Algorithms;

import com.sun.tools.javac.util.ArrayUtils;
import com.sun.tools.javac.util.StringUtils;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

class LambdaExpressions {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }


    public static class Solution {

        public static void main(String[] args) throws IOException {
            LambdaExpressions ob = new LambdaExpressions();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            PerformOperation op;
            boolean ret;
            String ans = null;
            while (T-- > 0) {
                String s = br.readLine().trim();
                StringTokenizer st = new StringTokenizer(s);
                int ch = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                if (ch == 1) {
                    op = ob.isOdd();
                    ret = checker(op, num);
                    ans = (ret) ? "ODD" : "EVEN";
                } else if (ch == 2) {
                    op = ob.isPrime();
                    ret = checker(op, num);
                    ans = (ret) ? "PRIME" : "COMPOSITE";
                } else if (ch == 3) {
                    op = ob.isPalindrome();
                    ret = checker(op, num);
                    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

                }
                System.out.println(ans);
            }
        }
    }

    private PerformOperation isOdd() {
        return x -> x % 2 != 0;
    }

    private PerformOperation isPrime() {
        return x -> {
            if (x < 2) {
                return false;
            }

            if (x == 2) {
                return true;
            }

            if (x % 2 == 0) {
                return false;
            }

            for (int i = 3; i < Math.sqrt(x); i += 2) {
                if (x % i == 0) {
                    return false;
                }
            }

            return true;
        };
    }

    private PerformOperation isPalindrome() {
        return x -> {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
            String leftToRight = stringBuilder.toString();
            String rightToLeft = stringBuilder.reverse().toString();

            return leftToRight.equals(rightToLeft);
        };
    }

    interface PerformOperation {

        boolean check(int a);
    }
}
