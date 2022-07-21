package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Calculator implements ActionListener {

	Dimension BIG = new Dimension(400, 400);	
	Dimension MID = new Dimension(70, 30);	
	JButton Button = new JButton();
	JButton Button2 = new JButton();
	JButton Button3 = new JButton();
	JButton Button4 = new JButton();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField field = new JTextField();
	JTextField field2 = new JTextField();
	public void setup() {
		frame.setPreferredSize(BIG);
		field.setPreferredSize(MID);
		field2.setPreferredSize(MID);
		
		frame.add(panel);
		frame.setVisible(true);
		Button.addActionListener(this);
		Button2.addActionListener(this);
		Button3.addActionListener(this);
		Button4.addActionListener(this);
		panel.add(field);
		panel.add(field2);
		panel.add(Button);
		panel.add(Button2);
		panel.add(Button3);
		panel.add(Button4);
		Button.setText("Add");
		Button2.setText("Multiply");
		Button3.setText("Subtract");
		Button4.setText("Divide");
		frame.setTitle("Calculator");
		frame.pack();
		
		
	}
	
	public void add() {
	String a = field.getText();
	String a1 = field2.getText();
	int x = Integer.parseInt(a);
	int x1 = Integer.parseInt(a1);
	int z = x + x1;
	JLabel label = new JLabel(""+z);
	label.setVisible(true);
	label.setLocation(200,300);
	label.setSize(30, 30);
	panel.add(label);
	frame.pack();	
	} 
	
	public void multiply() {
		String m = field.getText();
		String m1 = field2.getText();	
		int b = Integer.parseInt(m);
		int b1 = Integer.parseInt(m1);
		int multiply = b * b1;
		JLabel label = new JLabel(""+multiply);
		label.setVisible(true);
		label.setLocation(200,300);
		label.setSize(30, 30);
		panel.add(label);
		frame.pack();	
	}
	public void subtract() {
		String s = field.getText();
		String s1 = field2.getText();
		int e = Integer.parseInt(s);
		int e1 = Integer.parseInt(s1);
		int subtract = e - e1;
		JLabel label = new JLabel(""+subtract);
		label.setVisible(true);
		label.setLocation(200,300);
		label.setSize(30, 30);
		panel.add(label);
		frame.pack();	
	}
	public void divide() {
		String d = field.getText();
		String d1 = field2.getText();	
		int j = Integer.parseInt(d);
		int j1 = Integer.parseInt(d1);
		int divide = j / j1;
		JLabel label = new JLabel(""+divide);
		label.setVisible(true);
		label.setLocation(200,300);
		label.setSize(30, 30);
		panel.add(label);
		frame.pack();	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == Button) {
			add();
		}
		if(buttonPressed == Button2) {
			multiply();
		}
		if(buttonPressed == Button3) {
			subtract();
		}
		if(buttonPressed == Button4) {
			divide();
		}
		
	}
	
}
