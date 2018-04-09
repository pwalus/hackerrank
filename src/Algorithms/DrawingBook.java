package Algorithms;

import java.util.Scanner;

public class DrawingBook {

    static int solve(int n, int p) {
        int countFromLeft = 0;
        int countFromRight = 0;

        for (int i = 1; i <= n; i += 2) {
            if (i == p || i - 1 == p) {
                break;
            }

            countFromLeft++;
        }

        if(n % 2 == 0 && n - 1 == p){
            return 0;
        }
        for (int i = n; i >= 1; i -= 2) {
            if (i == p || i - 1 == p) {
                break;
            }

            countFromRight++;
        }

        return countFromLeft < countFromRight ? countFromLeft : countFromRight;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
