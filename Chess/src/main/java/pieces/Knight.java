package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Grid.BOARD_SIZE;
import static org.example.Grid.grid;

public class Knight extends Piece {
    private static int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

    public Knight(int row, int col, Color color, String icon) {
        super(row, col, color, icon);
    }

    @Override
    public ArrayList<ArrayList<Integer>> getValidMoves() {
        ArrayList<ArrayList<Integer>> validMoves = new ArrayList<>();
        for (int k = 0; k < 8; k++) {
            int curRow = row + dx[k], curCol = col + dy[k];
            if (!validCell(curRow, curCol)) continue;
            if (grid[curRow][curCol] == null) {
                validMoves.add(new ArrayList<>(Arrays.asList(curRow, curCol)));
            } else if (grid[curRow][curCol].playerColor != playerColor) {
                validMoves.add(new ArrayList<>(Arrays.asList(curRow, curCol)));;
            }
        }
        return validMoves;
    }

    @Override
    public boolean canMoveTo(int row2, int col2) {
        ArrayList<ArrayList<Integer>> validMoves = getValidMoves();
        return validMoves.contains(new ArrayList<>(Arrays.asList(row2, col2)));
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
