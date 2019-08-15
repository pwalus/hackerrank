package algorithms.problem_solving;

import java.util.*;

public class Alice {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> list = new ArrayList<>();
        list.add(scores[0]);

        int rank = 0;
        for (int i = 1; i < scores.length; i++) {
            if (list.get(rank) != scores[i]) {
                rank++;
                list.add(rank, scores[i]);
            }
        }

        int[] result = new int[alice.length];
        int value = 0;
        for (int i = 0; i < alice.length; i++) {
            int j = list.size() - 1;
            while (j > 0 && alice[i] > list.get(j)) {
                j--;
            }

            if(alice[i] > list.get(j)){
                value = j + 1;
            }else if(alice[i] < list.get(j)){
                value = j + 2;
            }else{
                value = j + 1;
            }

            result[i] = value;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int scores_i = 0; scores_i < n; scores_i++) {
            scores[scores_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for (int alice_i = 0; alice_i < m; alice_i++) {
            alice[alice_i] = in.nextInt();
        }
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
