package algorithms.problem_solving;

import java.util.*;

public class PickingNumber {

    private static final int LIMIT = 100;

    static int pickingNumbers(int[] a) {
        int[] counts = new int[LIMIT];
        for (int number : a) {
            counts[number]++;
        }

        int result = Arrays.stream(counts).max().getAsInt();
        for (int i = 0; i + 1 < counts.length; i++) {
            result = Math.max(result, counts[i] + counts[i + 1]);
        }
        return result;


//        List<List<Integer>> pairs = new ArrayList<>();
//        Map<Integer, Integer> frequency = new HashMap<>();
//        for (int i = 0; i < a.length; i++) {
//            frequency.put(a[i], frequency.getOrDefault(a[i], 0) + 1);
//
//            for (int j = 0; j < a.length; j++) {
//                if (a[i] != a[j] && (Math.abs(a[i] - a[j]) <= 1)) {
//                    pairs.add(Arrays.asList(a[i], a[j]));
//                }
//            }
//        }
//
//        int counter = 0;
//        for (Map.Entry<Integer, Integer> set : frequency.entrySet()) {
//            int key = set.getKey();
//            int value = set.getValue();
//            boolean flag = true;
//            for (List<Integer> item : pairs) {
//                if (item.get(0) != key && item.get(1) != key) {
//                    flag = false;
//                    break;
//                }
//            }
//
//            if (flag) {
//                counter += value;
//            }
//
//        }
//
//        System.out.println(frequency.toString());
//        System.out.println(pairs.toString());
//
//        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }

}
