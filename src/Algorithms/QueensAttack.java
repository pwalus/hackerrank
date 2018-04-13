package Algorithms;

public class QueensAttack {
    protected static int n;
    protected static int[][] obstacles;

    public static void setData(int n, int[][] obstacles) {
        QueensAttack.n = n;
        QueensAttack.obstacles = obstacles;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        QueensAttack.setData(n, obstacles);
        int result = 0;
        result += goLeft(r_q, c_q, true);
        result += goRight(r_q, c_q, true);
        result += goTop(r_q, c_q, true);
        result += goBottom(r_q, c_q, true);
        result += goDiagonal(r_q, c_q);

        return result;
    }

    public static int goLeft(int row, int column, boolean checkObstacles) {
        int obstacle = 0;
        if (checkObstacles) {
            for (int i = 0; i < obstacles.length; i++) {
                if (obstacles[i][0] == row && obstacles[i][1] > obstacle && obstacles[i][1] < column) {
                    obstacle = obstacles[i][1];
                }
            }
        }

        return column - (obstacle + 1);
    }

    public static int goRight(int row, int column, boolean checkObstacles) {
        int obstacle = n + 1;
        if (checkObstacles) {
            for (int i = 0; i < obstacles.length; i++) {
                if (obstacles[i][0] == row && obstacles[i][1] < obstacle && obstacles[i][1] > column) {
                    obstacle = obstacles[i][1];
                }
            }
        }
        return Math.abs(column - (obstacle - 1));
    }

    public static int goTop(int row, int column, boolean checkObstacles) {
        int obstacle = n + 1;
        if (checkObstacles) {
            for (int i = 0; i < obstacles.length; i++) {
                if (obstacles[i][1] == column && obstacles[i][0] < obstacle && obstacles[i][0] > row) {
                    obstacle = obstacles[i][0];
                }
            }
        }
        return Math.abs(row - (obstacle - 1));
    }

    public static int goBottom(int row, int column, boolean checkObstacles) {
        int obstacle = 0;
        if (checkObstacles) {
            for (int i = 0; i < obstacles.length; i++) {
                if (obstacles[i][1] == column && obstacles[i][0] > obstacle && obstacles[i][0] < row) {
                    obstacle = obstacles[i][0];
                }
            }
        }
        return row - (obstacle + 1);
    }

    public static int goDiagonal(int row, int column) {
        int result = 0;

        result += goLeftBottom(row, column);
        result += goRightBottom(row, column);
        result += goLeftTop(row, column);
        result += goRightTop(row, column);

        return result;
    }

    public static int goLeftBottom(int row, int column) {
        int diagonal = Math.min(goLeft(row, column, false), goBottom(row, column, false));
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
        int diagonal = Math.min(goRight(row, column, false), goBottom(row, column, false));
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
        int diagonal = Math.min(goLeft(row, column, false), goTop(row, column, false));
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
        int diagonal = Math.min(goRight(row, column, false), goTop(row, column, false));
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
