package algorithms.problem_solving;

public class Squres {

    public static int squares(int a, int b) {
        int result = 0;
        double square;
        int i = 1;
        do {
            square = Math.pow(i++, 2);
            if (square >= a && square <= b) {
                result++;
            }
        } while (square <= b);


        return result;
    }

}
