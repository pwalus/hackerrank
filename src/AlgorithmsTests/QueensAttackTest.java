package AlgorithmsTests;

import Algorithms.QueensAttack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueensAttackTest {

    @Test
    void testMain() {
        int n = 5;
        int row = 4;
        int column = 3;

        int k = 3;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 5;
        obstacles[0][1] = 5;
        obstacles[1][0] = 4;
        obstacles[1][1] = 2;
        obstacles[2][0] = 2;
        obstacles[2][1] = 3;

        int result = QueensAttack.queensAttack(n, k, row, column, obstacles);
        assertEquals(10, result);
    }

    @Test
    void testLeftMoveWithoutObstacles() {
        int row = 3;
        int column = 3;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 10;
        obstacles[0][1] = 10;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goLeft(row, column, true);
        assertEquals(2, result);
    }

    @Test
    void testLeftMoveWithObstacles() {
        int row = 4;
        int column = 4;
        int n = 4;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 4;
        obstacles[0][1] = 2;

        QueensAttack.setData(n, obstacles);
        int result = QueensAttack.goLeft(row, column, true);
        assertEquals(1, result);
    }

    @Test
    void testRightMoveWithoutObstacles() {
        int row = 3;
        int column = 3;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 0;
        obstacles[0][1] = 0;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goRight(row, column, true);
        assertEquals(1, result);
    }

    @Test
    void testRightMoveWithObstacles() {
        int row = 3;
        int column = 3;
        int n = 4;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 3;
        obstacles[0][1] = 4;

        QueensAttack.setData(n, obstacles);
        int result = QueensAttack.goRight(row, column, true);
        assertEquals(0, result);
    }

    @Test
    void testTopMoveWithoutObstacles() {
        int row = 3;
        int column = 3;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 20;
        obstacles[0][1] = 20;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goTop(row, column, true);
        assertEquals(1, result);
    }

    @Test
    void testTopMoveWithObstacles() {
        int row = 3;
        int column = 3;
        int n = 4;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 4;
        obstacles[0][1] = 3;

        QueensAttack.setData(n, obstacles);
        int result = QueensAttack.goTop(row, column, true);
        assertEquals(0, result);
    }

    @Test
    void testBottomMoveWithoutObstacles() {
        int row = 3;
        int column = 3;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 100;
        obstacles[0][1] = 100;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goBottom(row, column, true);
        assertEquals(2, result);
    }

    @Test
    void testBottomMoveWithObstacles() {
        int row = 4;
        int column = 4;
        int n = 4;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 1;
        obstacles[0][1] = 4;

        QueensAttack.setData(n, obstacles);
        int result = QueensAttack.goBottom(row, column, true);
        assertEquals(2, result);
    }

    @Test
    void testDiagonalMoveWithoutObstacles() {
        int row = 4;
        int column = 4;
        int[][] obstacles = new int[1][1];
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goDiagonal(row, column);
        assertEquals(3, result);
    }

    @Test
    void testDiagonalMoveWithoutObstacles33() {
        int row = 3;
        int column = 3;
        int[][] obstacles = new int[1][1];
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goDiagonal(row, column);
        assertEquals(5, result);
    }

    @Test
    void goLeftBottomWithoutObstacles() {
        int row = 4;
        int column = 4;
        int[][] obstacles = new int[1][1];
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goLeftBottom(row, column);
        assertEquals(3, result);
    }

    @Test
    void goLeftBottomWithObstacles() {
        int row = 4;
        int column = 4;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 2;
        obstacles[0][1] = 2;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goLeftBottom(row, column);
        assertEquals(1, result);
    }


    @Test
    void goRightBottomWithoutObstacles() {
        int row = 4;
        int column = 4;
        int[][] obstacles = new int[1][1];
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goRightBottom(row, column);
        assertEquals(0, result);
    }

    @Test
    void goRightBottomWithObstacles() {
        int row = 4;
        int column = 1;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 2;
        obstacles[0][1] = 3;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goRightBottom(row, column);
        assertEquals(1, result);
    }

    @Test
    void goLeftTopWithoutObstacles() {
        int row = 4;
        int column = 4;
        int[][] obstacles = new int[1][1];
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goLeftTop(row, column);
        assertEquals(0, result);
    }

    @Test
    void goLeftTopWithObstacles() {
        int row = 3;
        int column = 3;
        int k = 1;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 1;
        obstacles[0][1] = 1;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goLeftTop(row, column);
        assertEquals(1, result);
    }

    @Test
    void goRightTopWithoutObstacles() {
        int row = 4;
        int column = 4;
        int[][] obstacles = new int[1][1];
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goRightTop(row, column);
        assertEquals(0, result);
    }

    @Test
    void goRightTopWithObstacles() {
        int row = 1;
        int column = 1;
        int k = 2;
        int[][] obstacles = new int[k][2];
        obstacles[0][0] = 3;
        obstacles[0][1] = 3;
        obstacles[1][0] = 4;
        obstacles[1][1] = 4;
        QueensAttack.setData(4, obstacles);
        int result = QueensAttack.goRightTop(row, column);
        assertEquals(1, result);
    }


}