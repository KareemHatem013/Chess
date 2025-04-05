package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameActivity extends JFrame {
    private static final int BOARD_SIZE = 8; // 8x8 Chessboard
    private JButton[][] buttons = new JButton[BOARD_SIZE][BOARD_SIZE]; // Store buttons
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
        String[] firstRow = {"♜", "♞", "♝", "♛", "♚", "♝", "♞", "♜"};
        String pawn = "♟";
        int lastRowToggled = -1;
        int lastColToggled = -1;
        for(int row = 0; row < 8;row++){
            for(int col =0; col< 8;col++){
                buttons[row][col] = new JButton();
                if((row+col)%2 == 0){
                    buttons[row][col].setBackground(lightColor);
                }else{
                    buttons[row][col].setBackground(darkColor);
                }
                if(row == 0 || row == 7){
                    buttons[row][col].setText(firstRow[col]);
                }else if(row == 1 || row == 6){
                    buttons[row][col].setText(pawn);
                }
                if(row <= 1)buttons[row][col].setForeground(Color.BLACK);
                else if(row >= 6)buttons[row][col].setForeground(deepBlue);
                buttons[row][col].setFont(new Font("Serif", Font.PLAIN, 75));
                panel.add(buttons[row][col]);
            }
        }
        add(panel,BorderLayout.CENTER);
        setVisible(true);
        for(int col = 0;col < 8;col++){
            int finalRow = 6;
            int finalCol = col;
            buttons[6][col].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resetBold();
                    makeBold(finalRow, finalCol,deepBlue);
                }
            });
        }
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
        buttons[row][col].setBorder(BorderFactory.createLineBorder(deepBlue, 5));
        buttons[row-1][col].setBorder(BorderFactory.createLineBorder(deepBlue, 5));
        buttons[row-2][col].setBorder(BorderFactory.createLineBorder(deepBlue, 5));
    }
    private void setSelected(JButton button,int row,int col,Color onColor){
        button.setBackground(onColor); // Set to "on" color
    }
    private void reset(JButton button,int row,int col,Color lightColor,Color darkColor){
        if ((row + col) % 2 == 0) {
            button.setBackground(lightColor);
        } else {
            button.setBackground(darkColor);
        }
    }
}
