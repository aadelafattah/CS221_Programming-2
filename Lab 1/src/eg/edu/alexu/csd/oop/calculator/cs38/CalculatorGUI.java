package eg.edu.alexu.csd.oop.calculator.cs38;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class CalculatorGUI extends JPanel{
	
	String input = "";
	Calculator calculate = new SimpleCalculator();
	JTextField screen = new JTextField();
	JButton b0 = new JButton("0");
	JButton b1 = new JButton("1");
	JButton b2 = new JButton("2");
	JButton b3 = new JButton("3");
	JButton b4 = new JButton("4");
	JButton b5 = new JButton("5");
	JButton b6 = new JButton("6");
	JButton b7 = new JButton("7");
	JButton b8 = new JButton("8");
	JButton b9 = new JButton("9");
	JButton bDot = new JButton(".");
	JButton bPlus = new JButton("+");
	JButton bMinus = new JButton("-");
	JButton bTimes = new JButton("*");
	JButton bDivided = new JButton("/");
	JButton bEqual = new JButton("=");
	JButton bPrev = new JButton("Prev");
	JButton bCur = new JButton("Current");
	JButton bNex = new JButton("Next");
	JButton bSave = new JButton("Save");
	JButton bLoad = new JButton("Load");
	JButton bClear = new JButton("Clear");

	public CalculatorGUI() {
		
		JPanel panelC = new JPanel(new GridLayout(2,3));

	    panelC.add(bSave);
	    panelC.add(bLoad);
	    panelC.add(bClear);
	    panelC.add(bPrev);
	    panelC.add(bCur);
	    panelC.add(bNex);
	    
	    JPanel panel1 = new JPanel(new GridLayout(4,4));
	    panel1.add(b7);
	    panel1.add(b8);
	    panel1.add(b9);
	    panel1.add(bTimes);
	    panel1.add(b4);
	    panel1.add(b5);
	    panel1.add(b6);
	    panel1.add(bMinus);
	    panel1.add(b1);
	    panel1.add(b2);
	    panel1.add(b3);
	    panel1.add(bPlus);
	    panel1.add(b0);
	    panel1.add(bDot);
	    panel1.add(bDivided);
	    panel1.add(bEqual);
	    

	    ButtonListener listener = new ButtonListener();
	    
	    
	    b0.setFont(b0.getFont().deriveFont(22.0f));
	    b1.setFont(b0.getFont().deriveFont(22.0f));
	    b2.setFont(b0.getFont().deriveFont(22.0f));
	    b3.setFont(b0.getFont().deriveFont(22.0f));
	    b4.setFont(b0.getFont().deriveFont(22.0f));
	    b5.setFont(b0.getFont().deriveFont(22.0f));
	    b6.setFont(b0.getFont().deriveFont(22.0f));
	    b7.setFont(b0.getFont().deriveFont(22.0f));
	    b8.setFont(b0.getFont().deriveFont(22.0f));
	    b9.setFont(b0.getFont().deriveFont(22.0f));
	    bDot.setFont(b0.getFont().deriveFont(22.0f));
	    bPlus.setFont(b0.getFont().deriveFont(22.0f));
	    bMinus.setFont(b0.getFont().deriveFont(22.0f));
	    bTimes.setFont(b0.getFont().deriveFont(22.0f));
	    bDivided.setFont(b0.getFont().deriveFont(22.0f));
	    bEqual.setFont(b0.getFont().deriveFont(22.0f));
	    
	    b0.addActionListener(listener);
	    b1.addActionListener(listener);
	    b2.addActionListener(listener);
	    b3.addActionListener(listener);
	    b4.addActionListener(listener);
	    b5.addActionListener(listener);
	    b6.addActionListener(listener);
	    b7.addActionListener(listener);
	    b8.addActionListener(listener);
	    b9.addActionListener(listener);
	    bDot.addActionListener(listener);
	    bPlus.addActionListener(listener);
	    bMinus.addActionListener(listener);
	    bTimes.addActionListener(listener);
	    bDivided.addActionListener(listener);
	    bPrev.addActionListener(listener);
	    bCur.addActionListener(listener);
	    bNex.addActionListener(listener);
	    bSave.addActionListener(listener);
	    bLoad.addActionListener(listener);
	    bClear.addActionListener(listener);
	    bEqual.addActionListener(listener);
	    
	    JPanel p1= new JPanel();
	    p1.setLayout(new BorderLayout());
	    p1.add(screen, BorderLayout.NORTH);
	    p1.add(panelC, BorderLayout.CENTER);

	    setLayout(new BorderLayout());
	    add(p1, BorderLayout.NORTH);
	    add(panel1, BorderLayout.CENTER);
	    screen.setHorizontalAlignment(SwingConstants.RIGHT);
	    screen.setPreferredSize(new Dimension(300, 100));
	    screen.setFont(screen.getFont().deriveFont(30.0f));

	}

	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {

	        public void run() {
	        	JFrame.setDefaultLookAndFeelDecorated(true);
	            JFrame frame = new JFrame("Calculator");
	            frame.add(new CalculatorGUI());
	            frame.setSize(350, 500);
	            frame.isResizable();
	            frame.setVisible(true);

	        }
	    });
	}

	class ButtonListener implements ActionListener {

	    @Override
	    public void actionPerformed(ActionEvent e) {
	    	if (e.getSource() == b0) {
	            input += "0";
	            screen.setText(input);
	    	} else if (e.getSource() == b1) {
	            input += "1";
	            screen.setText(input);
	        } else if (e.getSource() == b2) {
	            input += "2";
	            screen.setText(input);
	        } else if (e.getSource() == b3) {
	            input += "3";
	            screen.setText(input);
	        } else if (e.getSource() == b4) {
	            input += "4";
	            screen.setText(input);
	        } else if (e.getSource() == b5) {
	            input += "5";
	            screen.setText(input);
	        } else if (e.getSource() == b6) {
	            input += "6";
	            screen.setText(input);
	        } else if (e.getSource() == b7) {
	            input += "7";
	            screen.setText(input);
	        } else if (e.getSource() == b8) {
	            input += "8";
	            screen.setText(input);
	        } else if (e.getSource() == b9) {
	            input += "9";
	            screen.setText(input);
	        } else if (e.getSource() == bPlus) {
	            input += "+";
	            screen.setText(input);
	        }else if (e.getSource() == bDot) {
	        	int size=input.length();
	        	if(size>=2) {
	        		if(input.charAt(size-1)=='.') {
			        	input="";
			        	screen.setText("ERROR");
			        }
	        	}
	        	if(size==0 || input.charAt(size-1)=='+'||input.charAt(size-1)=='-'||input.charAt(size-1)=='*'||input.charAt(size-1)=='/') {
	        		input+="0";
	       		}
	       		input += ".";
	       		screen.setText(input);
	        } else if (e.getSource() == bMinus) {
	            input += "-";
	            screen.setText(input);
	        } else if (e.getSource() == bTimes) {
	            input += "*";
	            screen.setText(input);
	        }else if (e.getSource() == bDivided) {
	            input += "/";
	            screen.setText(input);
	        } else if (e.getSource() == bClear) {
	            input="";
	            screen.setText(input);
	        } else if (e.getSource() == bPrev) {
	        	input="";
	            screen.setText(calculate.prev());
	        }
	         else if (e.getSource() == bCur) {
		         screen.setText(calculate.current());
	        }
	         else if (e.getSource() == bNex) {
		         input="";
		         screen.setText(calculate.next());
	        }else if (e.getSource() == bSave) {
	        	calculate.save();
		        input="";
		        screen.setText("SAVED");
	        }
	         else if (e.getSource() == bLoad) {
	        	 calculate.load();
			     input="";
			     screen.setText("LOADED");
	        }
	         else if (e.getSource() == bEqual) {
	            calculate.input(input);
	            input="";
	            screen.setText(calculate.getResult());
	        }
	    }

	}
    
}