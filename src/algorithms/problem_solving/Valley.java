package algorithms.problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class Valley {
    static int countingValleys(int n, String s) {
        int[] steps = Arrays.stream(s.split("(?!^)")).mapToInt((item) -> item.contains("U") ? 1 : -1).toArray();
        int level = 0;
        int valleys = 0;
        boolean flag = false;
        for (int step : steps) {
            level += step;
            if (level < 0) {
                flag = true;
            }

            if (level == 0 && flag) {
                valleys++;
                flag = false;
            }
        }

        return valleys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int result = countingValleys(n, s);
        System.out.println(result);
        in.close();
    }
}
