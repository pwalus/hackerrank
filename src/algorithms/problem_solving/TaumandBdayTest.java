package algorithms.problem_solving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaumandBdayTest {

    @Test
    void getEqualityPrices() {
        int result = TaumandBday.taumBday(10, 10, 1, 1, 1);
        assertEquals(20, result);
    }

    @Test
    void testNotZ() {
        int result = TaumandBday.taumBday(5, 9, 2, 3, 4);
        assertEquals(37, result);
    }

    @Test
    void testConvertingB() {
        int result = TaumandBday.taumBday(3, 6, 9, 1, 1);
        assertEquals(12, result);
    }

    @Test
    void testConvertingW() {
        int result = TaumandBday.taumBday(7, 7, 4, 2, 1);
        assertEquals(35, result);
    }

    @Test
    void testConvertingWTwo() {
        int result = TaumandBday.taumBday(3, 3, 1, 9, 2);
        assertEquals(12, result);
    }

    @Test
    void testConvertingWB() {
        int result = TaumandBday.taumBday(384, 887, 2778, 6916, 7794);
        assertEquals(7201244, result);
    }

    @Test
    void testConvertingWBC() {
        int result = TaumandBday.taumBday(2568 ,6430 ,5783, 531, 863);
        assertEquals(2917086, result);
    }


}