package Algorithms;

import java.util.Scanner;

public class ViralAdvertising {

    static int viralAdvertising(int n) {
        int sum = 2;
        int liked = 2;
        int people;
        for (int i = 2; i <= n; i++) {
            people = liked * 3;
            liked = (int)Math.floor(people/2);
            sum += liked;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = viralAdvertising(n);
        System.out.println(result);
        in.close();
    }

}
