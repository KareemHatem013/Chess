package pieces;

import java.awt.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(int row, int col, Color color,String icon){
            playerColor = color;
            pieceIcon = icon;
    }
    @Override
    public ArrayList<ArrayList<Integer>> getValidMoves() {
        return null;
    }

    @Override
    public boolean canMoveTo(int row, int col) {
        return false;
    }

    @Override
    public void moveTo(int row, int col) {

    }
}
