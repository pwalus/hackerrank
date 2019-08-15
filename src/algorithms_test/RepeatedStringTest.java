package algorithms_test;

import algorithms.problem_solving.RepeatedString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepeatedStringTest {

    @Test
    public void testFirstCase() {
        long n = 10;
        String text = "abcac";
        long result = RepeatedString.repeatedString(text, n);
        assertEquals(4, result);
    }

    @Test
    public void testSecondCase() {
        long n = 10;
        String text = "aba";
        long result = RepeatedString.repeatedString(text, n);
        assertEquals(7, result);
    }

    @Test
    public void testThirdCase() {
        long n = 100000000;
        String text = "a";
        long result = RepeatedString.repeatedString(text, n);
        assertEquals(100000000, result);
    }

//    @Test
//    public void testFourthCase() {
//        long n = 0;
//        String text = "bbbb";
//        long result = RepeatedString.repeatedString(text, n);
//        assertEquals(4, result);
//    }
//

}