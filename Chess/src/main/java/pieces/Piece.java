package pieces;

import java.util.ArrayList;
import org.example.Globals;
abstract class Piece{
    protected int row;
    protected int col;
    protected Character playerColor;
    abstract ArrayList<ArrayList<Integer>> getValidMoves();
    abstract boolean canMoveTo(int row, int col);
    abstract void moveTo(int row,int col);
    abstract Character getPlayerColor();
}
