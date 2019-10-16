package eg.edu.alexu.csd.oop.calculator.cs38;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class CalculatorGUI {
	
	final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    
    public static void addToPane(Container pane) {
    	
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        
        

        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            c.fill = GridBagConstraints.BOTH;
        }

        JTextField screen= new JTextField();
        if (shouldWeightX) {
            c.weightx = 0.5;
            c.weighty = 0.5;
        }
        c.gridx=0;
        c.gridy=0;
        c.gridwidth= 5;
        pane.add(screen);
        
        button = new JButton("SAVE");
        c.gridwidth=2;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(button, c);
        
        button = new JButton("LOAD");
        c.gridx = 2;
        c.gridy = 1;
        pane.add(button, c);
        
        button = new JButton("PREV");
        c.gridwidth=1;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("CURRENT");
        c.gridx = 1;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("NEXT");
        c.gridx = 2;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("/");
        c.gridx = 3;
        c.gridy = 2;
        pane.add(button, c);
        
        button = new JButton("7");
        c.gridx = 0;
        c.gridy = 3;
        pane.add(button, c);

        button = new JButton("8");
        c.gridx = 1;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("9");
        c.gridx = 2;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("*");
        c.gridx = 3;
        c.gridy = 3;
        pane.add(button, c);
        
        button = new JButton("4");
        c.gridx = 0;
        c.gridy = 4;
        pane.add(button, c);

        button = new JButton("5");
        c.gridx = 1;
        c.gridy = 4;
        pane.add(button, c);
        
        button = new JButton("6");
        c.gridx = 2;
        c.gridy = 4;
        pane.add(button, c);
        
        button = new JButton("-");
        c.gridx = 3;
        c.gridy = 4;
        pane.add(button, c);
        
        button = new JButton("1");
        c.gridx = 0;
        c.gridy = 5;
        pane.add(button, c);

        button = new JButton("2");
        c.gridx = 1;
        c.gridy = 5;
        pane.add(button, c);
        
        button = new JButton("3");
        c.gridx = 2;
        c.gridy = 5;
        pane.add(button, c);
        
        button = new JButton("+");
        c.gridx = 3;
        c.gridy = 5;
        pane.add(button, c);

        button = new JButton("0");
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 6;
        pane.add(button, c);
        
        button = new JButton(".");
        c.gridwidth=1;
        c.gridx = 2;
        c.gridy = 6;
        pane.add(button, c);
        
        button = new JButton("=");
        c.gridheight=2;
        c.gridx = 3;
        c.gridy = 6;
        pane.add(button, c);

    }
	
  
    private static void createGUI() {
    	
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }
    
}