package pieces;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Grid.firstPlayerColor;
import static org.example.Grid.grid;

public class Pawn extends Piece{
    public Pawn(int row, int col, Color color, String icon){
        super(row,col,color,icon);
    }
    @Override
    public ArrayList<ArrayList<Integer>> getValidMoves() {
        ArrayList<ArrayList<Integer>> validMoves = new ArrayList<>();
        int direction = (playerColor == firstPlayerColor) ? -1 : 1;

        if (isInBounds(row + direction, col) && grid[row + direction][col] == null) {
             validMoves.add(new ArrayList<>(Arrays.asList(row+direction, col)));
            int startRow = (playerColor == firstPlayerColor) ? 6 : 1;
            if (row == startRow && isInBounds(row + 2 * direction, col) && grid[row + 2 * direction][col] == null) {
                validMoves.add(new ArrayList<>(Arrays.asList(row + 2 * direction,col)));
            }
        }
        if (isInBounds(row + direction, col-1) &&grid[row + direction][col-1]!=null&& grid[row + direction][col-1].getPlayerColor()!=grid[row ][col].getPlayerColor() ) {
            validMoves.add(new ArrayList<>(Arrays.asList(row+direction, col-1)));
        }
        if (isInBounds(row + direction, col+1) &&grid[row + direction][col+1]!=null&& grid[row + direction][col+1].getPlayerColor()!=grid[row ][col].getPlayerColor() ) {
            validMoves.add(new ArrayList<>(Arrays.asList(row+direction, col+1)));
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
        if(row2!=0&&row2!=7)
        grid[row][col] = this;
        else grid[row][col] = new King(row2,col2,playerColor,"♛");
        grid[tempRow][tempCol] = null;
    }
}
