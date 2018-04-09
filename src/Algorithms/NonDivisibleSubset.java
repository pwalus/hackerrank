package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class NonDivisibleSubset {

    protected static List<List<Integer>> sets = new ArrayList<>();

    public static int nonDivisibleSubset(int k, int[] S) {
        createList(S);
        int result;

        for (int i = S.length; i > 0; i--) {
            for (int j = 0; j < sets.size(); j++) {
                if(sets.get(j) == null){
                    continue;
                }
                if (i == sets.get(j).size()) {
                    result = goThroughArray(k, j);

                    if (result == 0) {
                        return i;
                    }
                }
            }

            createSets();
        }

        return 0;
    }

    private static int goThroughArray(int k, int j) {
        int result = 0;

        for (int l = 0; l < sets.get(j).size(); l++) {
            for (int m = 0; m < sets.get(j).size(); m++) {
                if (l != m) {
                    if(sets.get(j).size() == 1 && sets.get(j).get(l) == k){
                        return 1;
                    }
                    if ((sets.get(j).get(l) + sets.get(j).get(m)) % k == 0) {
                        result++;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private static void createList(int[] S) {
        List<Integer> list = new ArrayList<>(S.length);
        for (int i = 0; i < S.length; i++) {
            list.add(S[i]);
        }

        sets.add(list);
    }

    protected static void createSets() {
        if (sets.size() == 2) {
            return;
        }

        int size = sets.size();
        for (int x = 0; x < size; x++) {
            if(sets.get(x) == null){
                continue;
            }
            for (int i = 0; i < sets.get(x).size(); i++) {
                List<Integer> simpleSet = new ArrayList<>();
                for (int j = 0; j < sets.get(x).size(); j++) {
                    if (i != j) {
                        simpleSet.add(sets.get(x).get(j));
                    }
                }

                addToSets(simpleSet);
            }

            sets.set(x, null);
        }
    }

    private static void addToSets(List<Integer> simpleSet) {
        boolean alreadyInSets = false;
        for (int i = 0; i < sets.size(); i++) {
            if(sets.get(i) == null){
                continue;
            }
            if (sets.get(i).equals(simpleSet)) {
                alreadyInSets = true;
            }
        }

        if (!alreadyInSets) {
            sets.add(simpleSet);
        }
    }

}
