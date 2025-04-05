package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Grid.grid;

public class Rook extends Piece{
    public Rook(int row, int col, Color color, String icon){
        super(row, col, color, icon);
    }

    @Override
    public ArrayList<ArrayList<Integer>> getValidMoves() {
        ArrayList<ArrayList<Integer>> validMoves = new ArrayList<>();
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            while (isInBounds(newRow, newCol)) {
                if (grid[newRow][newCol] == null) {
                    validMoves.add(new ArrayList<>(Arrays.asList(newRow, newCol)));
                } else {
                    if (grid[newRow][newCol].getPlayerColor() != grid[row][col].getPlayerColor()) {
                        validMoves.add(new ArrayList<>(Arrays.asList(newRow, newCol)));
                    }
                    break;
                }
                newRow += dir[0];
                newCol += dir[1];
            }
        }

        return validMoves;
    }

    private boolean isInBounds(int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    @Override
    public boolean canMoveTo(int rowTo, int colTo) {
        ArrayList<ArrayList<Integer>> validMoves;
        validMoves=getValidMoves();
        return validMoves.contains(new ArrayList<>(Arrays.asList(rowTo, colTo)));
    }
    @Override
    public void moveTo(int row2, int col2) {
        int tempRow = row, tempCol = col;
        row = row2;
        col = col2;
        grid[row][col] = this;
        grid[tempRow][tempCol] = null;
    }
}
