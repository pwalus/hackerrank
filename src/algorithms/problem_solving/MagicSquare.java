//package algorithms;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class MagicSquare {
//
//    static int formingMagicSquare(int[][] s) {
//        int[] rows = new int[s.length];
//        int[] columns = new int[s[0].length];
//        int[] diagonals = new int[2];
//
//        int[] analyzed = new int[8];
//        int idx = 0;
//
//        int column = 0;
//        int diagonalA = 0;
//        int diagonalB = 0;
//
//        for (int i = 0; i < s.length; i++) {
//            analyzed[idx] = Arrays.stream(s[i]).sum();
//            idx++;
//
//            column = 0;
//            for (int j = 0; j < s.length; j++) {
//                column += s[j][i];
//            }
//            analyzed[idx] = temp;
//            idx++;
//
//            tempA += s[i][i];
//            tempB += s[s.length - 1 - i][i];
//        }
//
//        return 1;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int[][] s = new int[3][3];
//        for (int s_i = 0; s_i < 3; s_i++) {
//            for (int s_j = 0; s_j < 3; s_j++) {
//                s[s_i][s_j] = in.nextInt();
//            }
//        }
//        int result = formingMagicSquare(s);
//        System.out.println(result);
//        in.close();
//    }
//
//}
