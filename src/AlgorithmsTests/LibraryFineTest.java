package AlgorithmsTests;

import Algorithms.LibraryFine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryFineTest {

    @Test
    void libraryFineBeforeDay() {
        int result = LibraryFine.libraryFine(1, 6 ,2015, 6 ,6, 2015);
        assertEquals(0, result);
    }

    @Test
    void libraryFineTheSameYearTheSameMonth() {
        int result = LibraryFine.libraryFine(9, 6 ,2015, 6 ,6, 2015);
        assertEquals(45, result);
    }

    @Test
    void libraryFineTheSameYearDifferentMonth() {
        int result = LibraryFine.libraryFine(9, 6 ,2015, 6 ,5, 2015);
        assertEquals(500, result);
    }

    @Test
    void libraryFineAfterYear() {
        int result = LibraryFine.libraryFine(9, 6 ,2015, 6 ,6, 2013);
        assertEquals(10000, result);
    }

    @Test
    void libraryFineBeforeYear() {
        int result = LibraryFine.libraryFine(9, 6 ,2015, 6 ,6, 2017);
        assertEquals(0, result);
    }

}