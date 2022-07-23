package _10_pig_latin;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatin implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField field = new JTextField();
	JTextField field2 = new JTextField();
	JButton Button = new JButton();
	JButton Button1 = new JButton();
	JButton Button2 = new JButton();
	Dimension BIG = new Dimension(400, 400);	
	Dimension MID = new Dimension(70, 30);
	Dimension MID2 = new Dimension(270, 30);
	public void run() {
		frame.setPreferredSize(BIG);
		field.setPreferredSize(MID2);
		field2.setPreferredSize(MID2);
		Button.setPreferredSize(MID);
		Button1.setPreferredSize(MID);
		Button2.setPreferredSize(MID);
		frame.add(panel);
		frame.setVisible(true);
		panel.add(field);
		panel.add(Button);
		panel.add(Button1);
		panel.add(field2);
		panel.add(Button2);
		Button.setText(">>");
		Button1.setText("<<");
		Button2.setText("Speak");
		frame.setTitle("Pig Latin Translator");
		Button.addActionListener(this);
		Button1.addActionListener(this);
		Button2.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == Button) {
			//translateEnglishToPigLatin();
			
		}
		if(buttonPressed == Button1) {
			
			
		}
		if(buttonPressed == Button2) {
			String answer = field2.getText();
			//Sound.speak(answer);
			
		}
		
	}
}
