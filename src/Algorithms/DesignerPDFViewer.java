package Algorithms;

import java.util.*;

public class DesignerPDFViewer {

    protected static String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    static int designerPdfViewer(int[] h, String word) {
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < h.length; i++) {
            map.put(letters[i], h[i]);
        }

        String[] chars = word.split("(?!^)");
        int max = Integer.MIN_VALUE;
        for(String item : chars){
            if(map.get(item) > max){
                max = map.get(item);
            }
        }

        return max * chars.length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for (int h_i = 0; h_i < 26; h_i++) {
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}
