package Week3.GameOfLife;

import java.util.HashSet;

public class MyGameOfLife implements GameOfLife{

    private record Point(int row, int column) {}

    private HashSet<Point> points;

    private final int rows;
    private final int cols;

    public MyGameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        points = new HashSet<>();
    }


    /**
     * Sets the cell at the given row and column to alive.
     *
     * @param row
     * @param col
     */
    @Override
    public void setAlive(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            points.add(new Point(row, col));
        }
    }

    /**
     * Evolves the board for the given number of generations.
     *
     * @param generations
     */
    @Override
    public void evolve(int generations) {
        for (int gen = 0; gen < generations; gen++) {

            // gather info on points to add and to remove
            HashSet<Point> pointsToAdd = new HashSet<>();
            HashSet<Point> pointsToRemove = new HashSet<>();
            for (Point point : points) {
                // // the point itself
                // if (!has2Or3Surrounding(point.row, point.column)) pointsToRemove.add(point);
                // the surrounding points
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        Point checkingPoint = new Point(point.row+i, point.column+j);

                        if (points.contains(checkingPoint) && !pointsToRemove.contains(checkingPoint)) {
                            //check if it should be removed
                            int surrCells = getSurroundingCells(checkingPoint.row, checkingPoint.column);
                            if (surrCells != 2 && surrCells != 3) pointsToRemove.add(checkingPoint);

                        } else if (!points.contains(checkingPoint) && !pointsToAdd.contains(checkingPoint)) {
                            // check if point should be added
                            if (getSurroundingCells(checkingPoint.row, checkingPoint.column) == 3) pointsToAdd.add(checkingPoint);
                        }

                    }
                }
            }

            // add or remove the requested points
            points.removeAll(pointsToRemove);
            pointsToAdd.forEach(p -> setAlive(p.row, p.column));
        }
    }

    private int getSurroundingCells(int r, int c) {

        int surrCount = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if ( i != 0 || j != 0) {
                    surrCount += (points.contains(new Point(r+i, c+j)) ? 1 : 0);
                }
            }
        }

        return surrCount;
    }



    /**
     * Returns a 2D array of booleans representing the current state of the board.
     * A cell is alive if the corresponding boolean is true, and dead if it is false.
     */
    @Override
    public boolean[][] getBoard() {
        boolean[][] board = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c] = points.contains(new Point(r, c));
            }
        }
        return board;
    }

    /**
     * Returns the total number of alive cells on the board.
     */
    @Override
    public int countAlive() {
        return points.size();
    }
}
