package _12_slot_machine;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton("SPIN");
	JLabel slotOne;
	JLabel slotTwo;
	JLabel slotThree;
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
    
	public SlotMachine() throws MalformedURLException {
		frame.add(panel);
		
		slotOne = createLabelImage("download.png");
		slotTwo = createLabelImage("download (1).jpg");
		slotThree = createLabelImage("images.jpg");
		slotOne.setSize(100,100);
		slotTwo.setSize(100,100);
		slotThree.setSize(100,100);
		panel.add(slotOne);
		panel.add(slotTwo);
		panel.add(slotThree);
		panel.add(button);
		button.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
		
		
		
	}
	public void trySpin() throws MalformedURLException {
		String[] files = {"download.png","download (1).jpg","images.jpg"};
		
		int ran = new Random().nextInt(3);
		int ran2 = new Random().nextInt(3);
		int ran3 = new Random().nextInt(3);
		
		panel.remove(slotOne);
		panel.remove(slotTwo);
		panel.remove(slotThree);
		
		slotOne = createLabelImage(files[ran]);
		slotTwo = createLabelImage(files[ran2]);
		slotThree = createLabelImage(files[ran3]);
		
		panel.add(slotOne);
		panel.add(slotTwo);
		panel.add(slotThree);
		
		if(ran == ran2 && ran2 == ran3 ) {
			JOptionPane.showMessageDialog(null,"You won!");
			
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			try {
				trySpin();
				frame.pack();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
		}
		
	}
	}}
