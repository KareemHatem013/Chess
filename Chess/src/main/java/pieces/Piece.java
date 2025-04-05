package pieces;

import java.awt.*;
import java.util.ArrayList;

import static org.example.Grid.BOARD_SIZE;

abstract public class Piece{
    protected int row;
    protected int col;
    protected Color playerColor;
    protected String pieceIcon;
    protected Piece(int row, int col, Color playerColor, String pieceIcon){
        this.row = row;
        this.col = col;
        this.playerColor = playerColor;
        this.pieceIcon = pieceIcon;
    }
    public boolean validCell(int r,int c){
        return (r>=0 && c >=0 && r < BOARD_SIZE && c < BOARD_SIZE);
    }
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
