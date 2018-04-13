package AlgorithmsTests;

import Algorithms.EqualizeTheArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualizeTheArrayTest {

    @Test
    void equalizeArray() {
        int[] in = {1,2,2,3};
        int result = EqualizeTheArray.equalizeArray(in);
        assertEquals(2, result);
    }

    @Test
    void equalizeArrayTwo() {
        int[] in = {3, 3, 2, 1, 3};
        int result = EqualizeTheArray.equalizeArray(in);
        assertEquals(2, result);
    }

}