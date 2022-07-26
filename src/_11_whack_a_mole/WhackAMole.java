package _11_whack_a_mole;



import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import  java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class WhackAMole implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton moles;	
	int whacked;
	int missed;
	Date date = new Date();
	void run(){
		frame.setPreferredSize(new Dimension(400,500));
		frame.add(panel);
		frame.setVisible(true);
		frame.setTitle("Whack a Button for Fame and Glory");
		int ran =  new Random().nextInt(24);
		drawButtons(ran);
		frame.pack();
		
		
	}
	
	 static void speak(String words) {
	        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
	            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
	                    + words + "');\"";
	            try {
	                Runtime.getRuntime().exec( cmd ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        } else {
	            try {
	                Runtime.getRuntime().exec( "say " + words ).waitFor();
	            } catch( Exception e ) {
	                e.printStackTrace();
	            }
	        }
	    }
	
	 private void endGame(Date timeAtStart, int molesWhacked) { 
		    Date timeAtEnd = new Date();
		    JOptionPane.showMessageDialog(null, "Your whack rate is "
		            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
		                  + " moles per second.");
		}

	
	 private void playSound(String fileName) { 
		   // AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		    //sound.play();
		 try 
		    {
		        
		        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fileName).getAbsoluteFile());
		        Clip clip = AudioSystem.getClip();
		        clip.open(audioInputStream);
		        clip.start();
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }

		}
	public void drawButtons(int randomN) {
		 for (int i = 0; i < 24; i++) {
				
				if (i == randomN) {
					JButton moles = new JButton("mole!");
					moles.addActionListener(this);
					panel.add(moles);
					frame.add(panel);
					
				
				}
				
				
				
				else {	
					JButton button = new JButton("    ");
					button.addActionListener(this);
					
					panel.add(button);
					
					frame.add(panel);
					
					frame.setSize(300, 500);
				}

		
			
			
			
		
	}
}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.getText().equals("    ")) {
			missed++;
			int ran2 =  new Random().nextInt(24);
			speak("You missed!");
			frame.remove(panel);
			panel = new JPanel();
			drawButtons(ran2);
			frame.add(panel);
			frame.pack();

			if(missed == 5) {
				endGame(date, missed);
				System.exit(0);
			}
			
			
			
		}
		if (buttonPressed.getText().equals("mole!")) {
			whacked++;
			int ran3 = new Random().nextInt(24);
			frame.remove(panel);
			panel = new JPanel();
			drawButtons(ran3);
			frame.add(panel);
			frame.pack();
			playSound("src\\_11_whack_a_mole\\643921__suddendice__as054715-short-physical-exortion.wav");
			if(whacked == 10) {
				endGame(date, whacked);
				System.exit(0);
			}
			
			
			
			
		}
		
	}
}

