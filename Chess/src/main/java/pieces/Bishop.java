package pieces;

import java.util.ArrayList;
import org.example.Globals;
public class Bishop extends Piece{

    @Override
    ArrayList<ArrayList<Integer>> getValidMoves() {
        return null;
    }

    @Override
    boolean canMoveTo(int row, int col) {
        return false;
    }

    @Override
    void moveTo(int row, int col) {

    }

    @Override
    Character getPlayerColor() {
        return null;
    }
}
