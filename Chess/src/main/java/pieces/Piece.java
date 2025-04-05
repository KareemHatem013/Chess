package pieces;

import java.awt.*;
import java.util.ArrayList;

abstract public class Piece{
    protected int row;
    protected int col;
    protected Color playerColor;
    protected String pieceIcon;
    abstract public ArrayList<ArrayList<Integer>> getValidMoves();
    abstract public boolean canMoveTo(int row, int col);
    abstract public void moveTo(int row,int col);
    public Color getPlayerColor(){
        return playerColor;
    }
    public String getPieceIcon(){
        return pieceIcon;
    }
}
