import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator {

	JFrame frame;
	JPanel panel;
	JTextField baseNum;
	JTextField exponent;
	JButton operation;
	JLabel output;
	JLabel errorTxt;
	
	double base;
	double exp;
	
	public static void main (String[] args){
		Calculator calc = new Calculator();
	}
	
	public Calculator() {
		//Frame
		frame = new JFrame();
		frame.setSize(500, 250);
		
		//Panel
		panel = new JPanel(new BorderLayout());
		frame.add(panel);
		
		//Input base
		baseNum = new JTextField("Input base number (a) : ", 20);
		baseNum.addActionListener(new TxtFldListener());
		panel.add(baseNum, BorderLayout.WEST);
		
		//Input exp
		exponent = new JTextField("Input exponent (b) : ", 20);
		exponent.addActionListener(new TxtFldListener());
		panel.add(exponent, BorderLayout.CENTER);
		
		//Button operation
		operation = new JButton("a^b");
		operation.addActionListener(new ButtonListener());
		panel.add(operation, BorderLayout.EAST);
		
		//Label output
		output = new JLabel("Output: ");
		panel.add(output, BorderLayout.SOUTH);
		
		//Label error message
		errorTxt = new JLabel("Please type input after messages");
		panel.add(errorTxt, BorderLayout.NORTH);
		
		frame.setVisible(true);
	}
	
	private class TxtFldListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JTextField eventSource = (JTextField) e.getSource();

			String text = eventSource.getText();
		    
			try {
		    	if (eventSource.equals(baseNum)){
			    	text = text.substring(24);//Not ideal solution if user types before message
			    	//System.out.println(text);
			    	base = Double.parseDouble(text);

		    	} else if (eventSource.equals(exponent)) {
		    		text = text.substring(21);
		    		System.out.println(text);

		    		exp = Double.parseDouble(text);
		    	}
		    } catch (NumberFormatException err) {
		    	
		    	errorTxt.setText("Error: Input in both text fields must be of type double or int.");
		    }
		}
	}
	
	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			output.setText("Output: " + Math.pow(base, exp));
		}
		
	}
}
