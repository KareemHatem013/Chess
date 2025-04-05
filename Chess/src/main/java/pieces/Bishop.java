package pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.example.Grid.BOARD_SIZE;
import static org.example.Grid.grid;


public class Bishop extends Piece{
    // valid directions for Bishop
    private static int dx[] = {-1,-1,1,1};
    private static int dy[] = {-1, 1,-1,1};
    public Bishop(int row, int col, Color color,String icon){
            super(row,col,color,icon);
    }
    @Override
    public ArrayList<ArrayList<Integer>> getValidMoves() {
        ArrayList<ArrayList<Integer>> validMoves = new ArrayList<>();
        for(int k = 0; k < 4;k++){
            for(int c = 1; c < BOARD_SIZE;c++){
                int curRow = row + c*dx[k],curCol = col + c*dy[k];
                if(!validCell(curRow,curCol))break;
                if(grid[curRow][curCol] == null){
                    validMoves.add(new ArrayList<>(Arrays.asList(curRow, curCol)));
                }else if(grid[curRow][curCol].playerColor != playerColor){
                    validMoves.add(new ArrayList<>(Arrays.asList(curRow, curCol)));
                    break;
                }else break;
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
