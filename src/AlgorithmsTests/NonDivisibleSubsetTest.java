package AlgorithmsTests;

import Algorithms.NonDivisibleSubset;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonDivisibleSubsetTest {

    @Test
    public void testCase() {
        int[] in = {1, 7, 2, 4};
        int result = NonDivisibleSubset.nonDivisibleSubset(3, in);

        assertEquals(3, result);
    }

    @Test
    public void testCaseTwo() {
        int[] in = {770528134, 663501748, 384261537, 800309024, 103668401, 538539662, 385488901, 101262949, 557792122, 46058493};
        int result = NonDivisibleSubset.nonDivisibleSubset(5, in);

        assertEquals(6, result);
    }

    @Test
    public void testCaseThree() {
        int[] in = {1, 2, 3, 4, 5};
        int result = NonDivisibleSubset.nonDivisibleSubset(1, in);

        assertEquals(1, result);
    }

}

