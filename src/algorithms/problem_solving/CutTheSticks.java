package algorithms.problem_solving;

import java.util.ArrayList;
import java.util.List;

public class CutTheSticks {

    public static int[] cutTheSticks(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int cutLength;
        int cutted;
        boolean end;
        while(true){
            cutted= 0;
            cutLength = findMin(arr);
            end = true;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > 0){
                    int cuttedLength = getLength(arr[i] - cutLength);
                    arr[i] = cuttedLength;
                    cutted++;
                    end = false;
                }
            }

            if(end){
                break;
            }

            list.add(cutted);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    private static int getLength(int cuttedLength) {
        if (cuttedLength < 0) {
            cuttedLength = 0;
        }

        return cuttedLength;
    }

    private static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min && arr[i] > 0) {
                min = arr[i];
            }
        }

        return min;
    }

}
