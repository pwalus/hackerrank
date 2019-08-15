package algorithms.problem_solving;

import java.util.Scanner;

public class BonApetit {

    protected static void getCost(int[] itemsCost, int k, int cost) {
        int sum = 0;
        for (int i = 0; i < itemsCost.length; i++) {
            if (i != k) {
                sum += itemsCost[i];
            }
        }

        sum = sum / 2;

        if (sum == cost) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(cost - sum);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] itemsCost = new int[n];
        for (int i = 0; i < n; i++) {
            itemsCost[i] = in.nextInt();
        }

        int cost = in.nextInt();

        getCost(itemsCost, k, cost);
    }
}
