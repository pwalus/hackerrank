package AlgorithmsTests;

import Algorithms.Squres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquresTest {

    @Test
    void squares() {
        int result = Squres.squares(3,9);
        assertEquals(2, result);

    }

    @Test
    void squarestwo() {
        int result = Squres.squares(17,24);
        assertEquals(0, result);

    }

}