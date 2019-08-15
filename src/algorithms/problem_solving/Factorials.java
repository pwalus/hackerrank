package algorithms.problem_solving;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorials {

    static void extraLongFactorials(int n) {
        BigInteger big = new BigInteger(String.valueOf(n));
        System.out.println(calculate(big).toString());
    }

    static BigInteger calculate(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) == 0) {
            return BigInteger.ONE;
        }

        return n.multiply(calculate(n.subtract(BigInteger.ONE)));
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }

}
