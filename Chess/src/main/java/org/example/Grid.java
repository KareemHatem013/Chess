package org.example;
import pieces.*;

import java.awt.*;

public class Grid {
    public static Piece [][]grid = new Piece [8][8];
    public static Color firstPlayerColor = Color.BLACK;
    public static Color secondPlayerColor = new Color(0x01, 0x32, 0x6C);
    private static final String[] piecesIcon = {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"};
    private static final String pawn = "♟";
    public static void initializeGrid() {
        // Example: Initialize with null or specific pieces
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if(row == 0 || row == 7){
                    Color playerColor = (row == 0 ? secondPlayerColor : firstPlayerColor);
                    if(col == 0 || col == 7){
                        grid[row][col] = new Rook(row, col,playerColor,piecesIcon[col]);
                    }else if(col == 1 || col == 6){
                        grid[row][col] = new Knight(row, col,playerColor,piecesIcon[col]);
                    }else if(col == 2 || col == 5){
                        grid[row][col] = new Bishop(row,col,playerColor,piecesIcon[col]);
                    }else if(col == 3){
                        grid[row][col] = new King(row,col,playerColor,piecesIcon[col]);
                    }else{
                        grid[row][col] = new Queen(row,col,playerColor,piecesIcon[col]);
                    }
                }else if(row == 1 || row == 6){
                    Color playerColor = (row == 1 ? secondPlayerColor : firstPlayerColor);
                    grid[row][col] = new Pawn(row,col,playerColor,pawn);
                }else{
                    grid[row][col] = null;
                }
            }
        }
    }
}
