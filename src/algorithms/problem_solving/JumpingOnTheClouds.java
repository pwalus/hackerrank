package algorithms.problem_solving;

public class JumpingOnTheClouds {

    public static int jumpingOnClouds(int[] c, int k) {
        int i = k;
        int energy = 100;
        while (k % c.length != 0) {
            energy = decreaseEnergy(c[k], energy);
            k += i;
        }
        return decreaseEnergy(c[0], energy);
    }

    protected static int decreaseEnergy(int value, int energy) {
        if (value == 1) {
            energy -= 2;
        }

        return --energy;
    }
}
