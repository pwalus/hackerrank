package algorithms.problem_solving;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueensAttackOnThreads {
    protected static int n;
    protected static int[][] obstacles;

    public static void setData(int n, int[][] obstacles) {
        QueensAttackOnThreads.n = n;
        QueensAttackOnThreads.obstacles = obstacles;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        QueensAttackOnThreads.setData(n, obstacles);
        int result = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = executorService.submit(() -> {
            return QueensAttackOnThreads.getSimpleDirections(r_q, c_q);
        });

        Future<Integer> future2 = executorService.submit(() -> {
            return QueensAttackOnThreads.goDiagonal(r_q, c_q);
        });

        try {
            result += future1.get();
            result += future2.get();

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        return result;
    }

    public static int getSimpleDirections(int row, int column) {
        int obstacleLeft = 0;
        int obstacleRight = n + 1;
        int obstacleTop = n + 1;
        int obstacleBottom = 0;
        for (int i = 0; i < obstacles.length; i++) {
            //LEFT
            if (obstacles[i][0] == row && obstacles[i][1] > obstacleLeft && obstacles[i][1] < column) {
                obstacleLeft = obstacles[i][1];
            }
            //RIGHT
            if (obstacles[i][0] == row && obstacles[i][1] < obstacleRight && obstacles[i][1] > column) {
                obstacleRight = obstacles[i][1];
            }
            //TOP
            if (obstacles[i][1] == column && obstacles[i][0] < obstacleTop && obstacles[i][0] > row) {
                obstacleTop = obstacles[i][0];
            }
            //BOTTOM
            if (obstacles[i][1] == column && obstacles[i][0] > obstacleBottom && obstacles[i][0] < row) {
                obstacleBottom = obstacles[i][0];
            }
        }

        return goLeft(row, column, obstacleLeft) + goRight(row, column, obstacleRight) + goTop(row, column, obstacleTop) + goBottom(row, column, obstacleBottom);
    }

    public static int goLeft(int row, int column, int obstacle) {
        return column - (obstacle + 1);
    }

    public static int goRight(int row, int column, int obstacle) {
        return Math.abs(column - (obstacle - 1));
    }

    public static int goTop(int row, int column, int obstacle) {
        return Math.abs(row - (obstacle - 1));
    }

    public static int goBottom(int row, int column, int obstacle) {
        return row - (obstacle + 1);
    }

    public static int goDiagonal(int row, int column) {
        int result = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Integer> future = executorService.submit(() -> {
            return QueensAttackOnThreads.goLeftBottom(row, column);
        });
        Future<Integer> future1 = executorService.submit(() -> {
            return QueensAttackOnThreads.goRightBottom(row, column);
        });
        Future<Integer> future2 = executorService.submit(() -> {
            return QueensAttackOnThreads.goLeftTop(row, column);
        });
        Future<Integer> future3 = executorService.submit(() -> {
            return QueensAttackOnThreads.goRightTop(row, column);
        });
        try {
            result += future.get();
            result += future1.get();
            result += future2.get();
            result += future3.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        return result;
    }

    public static int goLeftBottom(int row, int column) {
        int diagonal = Math.min(goLeft(row, column, 0), goBottom(row, column, 0));
        int[][] squares = new int[diagonal][2];

        int end_row = 1;
        int end_column = 1;
        int idx = 0;
        int row_temp = row;
        int column_temp = column;
        while (row_temp > end_row && column_temp > end_column) {
            squares[idx][0] = --row_temp;
            squares[idx][1] = --column_temp;
            idx++;
        }

        end_row = 0;
        end_column = 0;
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < diagonal; j++) {
                if (obstacles[i][0] == squares[j][0] && obstacles[i][1] == squares[j][1] && obstacles[i][0] > end_row && obstacles[i][1] > end_column) {
                    end_row = obstacles[i][0];
                    end_column = obstacles[i][1];
                }
            }
        }

        return Math.min(column - (end_column + 1), row - (end_row + 1));
    }

    public static int goRightBottom(int row, int column) {
        int diagonal = Math.min(goRight(row, column, n + 1), goBottom(row, column, 0));
        int[][] squares = new int[diagonal][2];

        int end_row = 1;
        int end_column = n;
        int idx = 0;
        int row_temp = row;
        int column_temp = column;
        while (row_temp > end_row && column_temp < end_column) {
            squares[idx][0] = --row_temp;
            squares[idx][1] = ++column_temp;
            idx++;
        }

        end_row = 0;
        end_column = n + 1;
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < diagonal; j++) {
                if (obstacles[i][0] == squares[j][0] && obstacles[i][1] == squares[j][1] && obstacles[i][0] > end_row && obstacles[i][1] < end_column) {
                    end_row = obstacles[i][0];
                    end_column = obstacles[i][1];
                }
            }
        }

        return Math.min(Math.abs(column - (end_column - 1)), row - (end_row + 1));

    }

    public static int goLeftTop(int row, int column) {
        int diagonal = Math.min(goLeft(row, column, 0), goTop(row, column, n + 1));
        int[][] squares = new int[diagonal][2];


        int end_row = n;
        int end_column = 1;
        int idx = 0;
        int row_temp = row;
        int column_temp = column;
        while (row_temp < end_row && column_temp > end_column) {
            squares[idx][0] = ++row_temp;
            squares[idx][1] = --column_temp;
            idx++;
        }


        end_row = n + 1;
        end_column = 0;
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < diagonal; j++) {
                if (obstacles[i][0] == squares[j][0] && obstacles[i][1] == squares[j][1] && obstacles[i][0] < end_row && obstacles[i][1] > end_column) {
                    end_row = obstacles[i][0];
                    end_column = obstacles[i][1];
                }
            }
        }

        return Math.min(column - (end_column + 1), Math.abs(row - (end_row - 1)));
    }

    public static int goRightTop(int row, int column) {
        int diagonal = Math.min(goRight(row, column, n + 1), goTop(row, column, n + 1));
        int[][] squares = new int[diagonal][2];


        int end_row = n;
        int end_column = n;
        int idx = 0;
        int row_temp = row;
        int column_temp = column;
        while (row_temp < end_row && column_temp < end_column) {
            squares[idx][0] = ++row_temp;
            squares[idx][1] = ++column_temp;
            idx++;
        }


        end_row = n + 1;
        end_column = n + 1;
        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < diagonal; j++) {
                if (obstacles[i][0] == squares[j][0] && obstacles[i][1] == squares[j][1] && obstacles[i][0] < end_row && obstacles[i][1] < end_column) {
                    end_row = obstacles[i][0];
                    end_column = obstacles[i][1];
                }
            }
        }


        return Math.min(Math.abs(column - (end_column - 1)), Math.abs(row - (end_row - 1)));
    }
}
