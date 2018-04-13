package Algorithms;

public class EqualizeTheArray {

    public static int equalizeArray(int[] arr) {
        int[] frequnecy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            frequnecy[arr[i]]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < frequnecy.length; i++) {
            if (frequnecy[i] > max) {
                max = frequnecy[i];
            }
        }

        return arr.length - max;
    }

}
