package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartActivity extends JFrame {
    public StartActivity() {
        super("StartActivity");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 900);
        setResizable(false);
        setLayout(null); // Disable layout manager
        setLocationRelativeTo(null); // Center the window
        JButton startButton = new JButton("Start");
        startButton.setBounds(390, 390, 120, 60); // x, y, width, height
        add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameActivity(); // Open the new activity (window)
                dispose(); // Close the current window
            }
        });
        setVisible(true);
    }
}