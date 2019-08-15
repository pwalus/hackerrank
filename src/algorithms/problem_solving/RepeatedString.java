package algorithms.problem_solving;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RepeatedString {

    public static long repeatedString(String s, long n) {
        long length = s.length();
        long howManyAs = getHowManyAs(s);
        System.out.println(howManyAs);
        long counts = (long) Math.floor(n / length);
        long numberOfAs = (counts * howManyAs);

        if (length * counts < n) {
            long lasted = n - (length * counts);
            for (char item : s.toCharArray()) {
                if (lasted == 0) {
                    return numberOfAs;
                }
                if (item == 'a') {
                    numberOfAs++;
                }
                lasted--;
            }
        } else {
            return numberOfAs;
        }

        return length;
    }

    private static long getHowManyAs(String s) {
        Pattern p = Pattern.compile("(a)");
        Matcher m = p.matcher(s);
        int count = 0;
        while (m.find())
            count++;

        return count;
    }

}
