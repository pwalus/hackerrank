package AlgorithmsTests;

import Algorithms.FindDigits;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindDigitsTest {

    @Test
    void explodeInteger() {
        int n = 12212;
        int[] result = FindDigits.explodeNumber(n);
        int[] expected = {1, 2, 2, 1, 2};
        assertArrayEquals(expected, result);
    }


    @Test
    void findDigits() {
        int n = 1012;
        int result = FindDigits.findDigits(n);
        int expected = 3;
        assertEquals(expected, result);
    }
}