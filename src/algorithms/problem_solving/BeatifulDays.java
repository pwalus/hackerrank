package algorithms.problem_solving;

import java.util.Scanner;

public class BeatifulDays {
    static int beautifulDays(int i, int j, int k) {
        int count = 0;
        while (i <= j) {
            if ((i - reverse(i)) % k == 0) {
                count++;
            }
            i++;
        }

        return count;
    }

    private static int reverse(int i) {
        char[] integer = Integer.toString(i).toCharArray();
        StringBuffer reversedString = new StringBuffer();
        for (int j = integer.length - 1; j > 0; j--) {
            reversedString.append(integer[j]);
        }

        return Integer.parseInt(reversedString.toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int j = in.nextInt();
        int k = in.nextInt();
        int result = beautifulDays(i, j, k);
        System.out.println(result);
        in.close();
    }
}
