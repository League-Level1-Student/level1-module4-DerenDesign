package _01_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClass  implements ActionListener  {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button2 = new JButton();
public void makeButtons() {
	
	button.addActionListener(this);
	button2.addActionListener(this);
	frame.add(panel);
	frame.setVisible(true);
	panel.add(button);
	panel.add(button2);
	button.setText("Joke");
	button2.setText("Punchline");
	frame.setTitle("Chuckle Clicker");
	frame.pack();
	
	
	
	
}

@Override
public void actionPerformed(ActionEvent arg0) {
	JButton buttonPressed = (JButton) arg0.getSource();
	if(buttonPressed == button || buttonPressed == button2) {
		JOptionPane.showMessageDialog(null, "Hi!");
		
	}
	if(buttonPressed == button) {
		JOptionPane.showMessageDialog(null, "What’s the best thing about Switzerland?\r\n"
				+ "I don’t know, but the flag is a big plus.");
		
	}
	if(buttonPressed == button2) {
		JOptionPane.showMessageDialog(null, "Why does Waldo wear stripes?\r\n"
				+ "\r\n"
				+ "Because he doesn’t want to be spotted.");
	}
	
	
}
}
