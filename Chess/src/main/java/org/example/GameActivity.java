package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static org.example.Grid.grid;

public class GameActivity extends JFrame {
    private static final int BOARD_SIZE = 8; // 8x8 Chessboard
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE]; // Store buttons
    private int lastClickedRow = -1,lastClickedCol = -1;
    GameActivity() {
        super("Game Activity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,900);
        setResizable(false);
        setLocationRelativeTo(null); // Center the window
        JPanel panel = new JPanel(new GridLayout(8, 8)); // 3x3 grid
        Color lightColor = new Color(240, 217, 181); // Light beige
        Color darkColor = new Color(181, 136, 99);  // Medium brown
        Color deepBlue = new Color(0x01, 0x32, 0x6C);
        Color onColor = new Color(1, 50, 108);
        for(int row = 0; row < 8;row++){
            for(int col =0; col< 8;col++){
                buttons[row][col] = new JButton();
                if((row+col)%2 == 0){
                    buttons[row][col].setBackground(lightColor);
                }else{
                    buttons[row][col].setBackground(darkColor);
                }
                if(grid[row][col] != null){
                    buttons[row][col].setText(grid[row][col].getPieceIcon());
                    buttons[row][col].setForeground(grid[row][col].getPlayerColor());
                }
                buttons[row][col].setFont(new Font("Serif", Font.PLAIN, 75));
                panel.add(buttons[row][col]);
                int finalRow = row;
                int finalCol = col;
                buttons[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(lastClickedRow == -1){
                            resetBold();
                            makeBold(finalRow, finalCol,deepBlue);
                            lastClickedRow = finalRow;
                            lastClickedCol = finalCol;
                        }else{
                            resetBold();
                            // not null and cant move
                            if(grid[lastClickedRow][lastClickedCol] != null){
                                if(grid[lastClickedRow][lastClickedCol].canMoveTo(finalRow, finalCol)){
                                    buttons[lastClickedRow][lastClickedCol].setText("");
                                    buttons[finalRow][finalCol].setForeground(grid[lastClickedRow][lastClickedCol].getPlayerColor());
                                    grid[lastClickedRow][lastClickedCol].moveTo(finalRow, finalCol);
                                    buttons[finalRow][finalCol].setText(grid[finalRow][finalCol].getPieceIcon());
                                }
                            }else if(grid[lastClickedRow][lastClickedCol]==null){
                                makeBold(finalRow, finalCol,deepBlue);
                            }
                            lastClickedRow = -1;
                            lastClickedCol = -1;
                        }
                        setVisible(true);
                    }
                });
            }
        }
        add(panel,BorderLayout.CENTER);
        setVisible(true);
    }
    private void resetBold(){
        for(int row = 0 ;row < 8;row++){
            for(int col = 0 ;col < 8;col++){
                buttons[row][col].setBorder(null);
            }
        }
    }
    private void makeBold(int row,int col,Color deepBlue){
        // getValidCells
        if(grid[row][col] == null){
            buttons[row][col].setBorder(BorderFactory.createLineBorder(deepBlue, 5));
            return;
        }
        ArrayList<ArrayList<Integer>>validMoves = grid[row][col].getValidMoves();
        for(ArrayList<Integer> move : validMoves){
            int x = move.get(0),y = move.get(1);
            buttons[x][y].setBorder(BorderFactory.createLineBorder(deepBlue, 5));
        }
    }
}
