package Algorithms;

import Algorithms.LambdaExpressions.PerformOperation;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;

import static java.lang.System.in;


public class PrimeChecker {

    static class Prime {

        public void checkPrime(int... integers) {
            for (int integer : integers) {
                if (isPrime(integer)) {
                    System.out.print(integer + " ");
                }
            }
            System.out.println();
        }

        private boolean isPrime(int x) {
            if (x <= 1) {
                return false;
            }

            if (x == 2) {
                return true;
            }

            if (x % 2 == 0) {
                return false;
            }

            for (int i = 3; i <= Math.sqrt(x); i += 2) {
                if (x % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            Prime ob = new Prime();
            ob.checkPrime(n1);
            ob.checkPrime(n1, n2);
            ob.checkPrime(n1, n2, n3);
            ob.checkPrime(n1, n2, n3, n4, n5);
            Method[] methods = Prime.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (Method method : methods) {
                if (set.contains(method.getName())) {
                    overload = true;
                    break;
                }
                set.add(method.getName());

            }
            if (overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}


