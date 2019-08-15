package algorithms_test;

import algorithms.problem_solving.CutTheSticks;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CutTheSticksTest {

    @Test
    void testSticksOne() {
        int[] arr = {5, 4, 4, 2, 2, 8};
        int[] result = CutTheSticks.cutTheSticks(arr);
        int[] expected = {6, 4, 2, 1};

        assertArrayEquals(expected, result);

    }

    @Test
    void testSticksTwo() {
        int[] arr = {1, 2, 3, 4, 3, 3, 2, 1};
        int[] result = CutTheSticks.cutTheSticks(arr);
        int[] expected = {8,6,4,1};

        assertArrayEquals(expected, result);
    }

}