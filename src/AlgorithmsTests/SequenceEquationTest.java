package AlgorithmsTests;

import Algorithms.SequenceEquation;

import static org.junit.jupiter.api.Assertions.*;

class SequenceEquationTest {

    @org.junit.jupiter.api.Test
    void findFirstValue() {
        int[] testCase = {2, 3, 1};
        int value = 1;
        int result = SequenceEquation.findValue(value, testCase);

        assertEquals(3, result);
    }

    @org.junit.jupiter.api.Test
    void findFirstAndSecondValue() {
        int[] testCase = {2, 3, 1};
        int value = 1;
        int result = SequenceEquation.findValue(SequenceEquation.findValue(value, testCase), testCase);

        assertEquals(2, result);
    }

    @org.junit.jupiter.api.Test
    void permutationEquation() {
        int[] testCase = {2, 3, 1};
        int[] result = SequenceEquation.permutationEquation(testCase);
        int[] expected = {2, 3, 1};
        assertArrayEquals(expected, result);
    }
}