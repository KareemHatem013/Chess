package pieces;

import java.awt.*;
import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(int row, int col, Color color, String icon){
        super(row, col, color, icon);
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
