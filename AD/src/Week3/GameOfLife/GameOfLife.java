package Week3.GameOfLife;

import java.util.List;

public interface GameOfLife {
    /**
     * Sets the cell at the given row and column to alive.
     */
    void setAlive(int row, int col);

    /**
     * Evolves the board for the given number of generations.
     */
    void evolve(int generations);

    /**
     * Returns a 2D array of booleans representing the current state of the board.
     * A cell is alive if the corresponding boolean is true, and dead if it is false.
     */
    boolean[][] getBoard();

    /**
     * Returns the total number of alive cells on the board.
     */
    int countAlive();

    /**
     * Returns a string representation of the board with alive cells represented by 'O' and dead cells by '.'
     * Useful for debugging.
     */
    default String asString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : getBoard()) {
            for (boolean cell : row) {
                sb.append(cell ? 'O' : '.');
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Sets the board to the given string representation.
     *
     * @param content a string with 'O' for alive cells and '.' for dead cells
     * @param offsetRows the number of rows to offset the board
     * @param offsetColumns the number of columns to offset the board
     */
    default void fromString(String content, int offsetRows, int offsetColumns) {
        List<String> lines = content.lines().toList();
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == 'O') {
                    setAlive(i + offsetRows, j + offsetColumns);
                }
            }
        }
    }
}
