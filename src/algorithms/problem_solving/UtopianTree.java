package algorithms.problem_solving;

import java.util.Scanner;

public class UtopianTree {

    protected final static int INITIAL_HEIGHT = 1;

    static int utopianTree(int n) {
        int height = INITIAL_HEIGHT;
        boolean isSpring = true;
        for (int i = 0; i < n; i++) {
            if(isSpring){
                height = height * 2;
            }else{
                height++;
            }

            isSpring = !isSpring;
        }

        return height;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int result = utopianTree(n);
            System.out.println(result);
        }
        in.close();
    }
}
