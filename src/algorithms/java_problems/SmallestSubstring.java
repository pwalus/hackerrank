package algorithms.java_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SmallestSubstring {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'

        java.util.LinkedList<String> stringList = new java.util.LinkedList<>();
        for (int i = k; i <= s.length(); i++) {
            stringList.add(s.substring(i - k, i));
        }

        stringList.sort(String::compareTo);
        smallest = stringList.getFirst();
        largest = stringList.getLast();

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}