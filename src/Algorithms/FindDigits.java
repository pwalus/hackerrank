package Algorithms;

public class FindDigits {
    public static int findDigits(int n) {
        int result = 0;
        int[] number = explodeNumber(n);
        for (int i = 0; i < number.length; i++) {
            if (number[i] != 0 && n % number[i] == 0) {
                result++;
            }
        }

        return result;
    }

    public static int[] explodeNumber(int n) {
        char[] chars = Integer.toString(n).toCharArray();
        int[] digits = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = Integer.parseInt(String.valueOf(chars[i]));
        }

        return digits;
    }
}
