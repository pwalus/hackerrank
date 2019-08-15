package algorithms_test;

import algorithms.problem_solving.JumpingOnTheClouds;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpingOnTheCloudsTest {

    @Test
    void jumpingOnCloudsOne() {
        int[] c = {0, 0, 1, 0};
        int k = 2;

        int result = JumpingOnTheClouds.jumpingOnClouds(c, k);
        assertEquals(96, result);
    }

    @Test
    void jumpingOnCloudsTwo() {
        int[] c = {0, 0, 1, 0, 0, 1, 1, 0};
        int k = 2;

        int result = JumpingOnTheClouds.jumpingOnClouds(c, k);
        assertEquals(92, result);
    }
}