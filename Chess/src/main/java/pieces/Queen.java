package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import static org.example.Grid.BOARD_SIZE;
import static org.example.Grid.grid;

public class Queen extends Piece {
    private static final int[] dxKing = {-1, -1, 1, 1, 0, 0, 1, -1};
    private static final int[] dyKing = {-1, 1, -1, 1, -1, 1, 0, 0};
    private static final int[] dxKnight = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static final int[] dyKnight = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final int[] dxQueen = {-1, -1, 1, 1, 0, 0, 1, -1};
    private static final int[] dyQueen = {-1, 1, -1, 1, -1, 1, 0, 0};

    public Queen(int row, int col, Color color, String icon) {
        super(row, col, color, icon);
    }

    public boolean isItCheck() {
        for (int k = 0; k < 8; k++) {
            for (int c = 1; c < BOARD_SIZE; c++) {
                int curRow = row + c * dxKing[k], curCol = col + c * dyKing[k];
                if (!validCell(curRow, curCol)) break;
                if (grid[curRow][curCol] == null) {

                } else if (grid[curRow][curCol].playerColor != playerColor) {
                    // can Bishop catch me
                    if (k < 4 && (Objects.equals(grid[curRow][curCol].pieceIcon, "♝") || Objects.equals(grid[curRow][curCol].pieceIcon, "♛"))) {
                        return true;
                    } else if (k > 4 && (Objects.equals(grid[curRow][curCol].pieceIcon, "♜") || Objects.equals(grid[curRow][curCol].pieceIcon, "♛"))) {
                        return true;
                    }
                    break;
                } else break;
            }
        }
        // does Knight do a Check ?
        for (int k = 0; k < 8; k++) {
            int curRow = row + dxKnight[k], curCol = col + dyKnight[k];
            if (!validCell(curRow, curCol)) continue;
            if (grid[curRow][curCol] == null) {

            } else if (grid[curRow][curCol].playerColor != playerColor) {
                if (Objects.equals(grid[curRow][curCol].pieceIcon, "♞")) {
                    return true;
                }
            }
        }
        //does Pawn do a check
        for (int k = 0; k < 4; k++) {
            int curRow = row + dxQueen[k], curCol = col + dyQueen[k];
            if (!validCell(curRow, curCol)) continue;
            if (grid[curRow][curCol] == null) {

            } else if (grid[curRow][curCol].playerColor != playerColor) {
                if (grid[curRow][curCol].canMoveTo(row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ArrayList<ArrayList<Integer>> getValidMoves() {
        ArrayList<ArrayList<Integer>> validMoves = new ArrayList<>();
        for(int k = 0 ;k < 8;k++){
            int curRow = row + dxQueen[k], curCol = col + dyQueen[k];
            if (!validCell(curRow, curCol)) continue;
            if (grid[curRow][curCol] == null) {
                int tempRow = row,tempCol = col;
                row = curRow;
                col = curCol;
                grid[curRow][curCol] = grid[tempRow][tempCol];
                grid[tempRow][tempCol] = null;
                if(!isItCheck()){
                    validMoves.add(new ArrayList<>(Arrays.asList(curRow, curCol)));;
                }
                row = tempRow;
                col = tempCol;
                grid[row][col] = grid[curRow][curCol];
                grid[curRow][curCol] = null;
            } else if (grid[curRow][curCol].playerColor != playerColor) {
                Piece _7ad = grid[curRow][curCol];
                grid[curRow][curCol] = grid[row][col];
                int tempRow = row,tempCol = col;
                row = curRow;
                col = curCol;
                grid[row][col] = null;
                if(!isItCheck()){
                    validMoves.add(new ArrayList<>(Arrays.asList(curRow, curCol)));;
                }
                row = tempRow;
                col = tempCol;
                grid[row][col] = grid[curRow][curCol];
                grid[curRow][curCol] = _7ad;
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
