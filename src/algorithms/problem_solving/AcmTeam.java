package algorithms.problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class AcmTeam {

    static int[] acmTeam(String[] topic) {
        int max = Integer.MIN_VALUE;
        int[] frequency = new int[topic[0].toCharArray().length + 1];
        int m = topic[0].toCharArray().length;
        int temp = 0;
        for (int i = 0; i < topic.length; i++) {
            for (int j = i + 1; j < topic.length; j++) {
                temp = 0;
                for (int k = 0; k < m; k++) {
                    if ((topic[i].toCharArray()[k] == '1') || (topic[j].toCharArray()[k] == '1')) {
                        temp++;
                    }
                }
            }

            System.out.println(temp);
            if (temp > max) {
                max = temp;
            }

            frequency[temp]++;
        }

        System.out.println(Arrays.toString(frequency));
        int[] result = {max, frequency[max]};

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] topic = new String[n];
        for (int topic_i = 0; topic_i < n; topic_i++) {
            topic[topic_i] = in.next();
        }
        int[] result = acmTeam(topic);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }

}
