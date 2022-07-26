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
	Dimension BIG = new Dimension(1000, 300);
	Dimension MID = new Dimension(70, 30);
	Dimension MID2 = new Dimension(270, 30);

	public void run() {
		frame.setPreferredSize(BIG);
		field.setPreferredSize(MID2);
		field2.setPreferredSize(MID2);
		Button.setPreferredSize(MID);
		Button1.setPreferredSize(MID);
		Button2.setPreferredSize(MID);
		frame.pack();
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

	/**
	 * Method to test whether a character is a letter or not.
	 * 
	 * @param c The character to test
	 * @return True if it's a letter
	 */
	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	/**
	 * Method to translate one word into pig latin.
	 * 
	 * @param word The word in english
	 * @return The pig latin version
	 */
	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	/**
	 * Method to translate a sentence word by word.
	 * 
	 * @param s The sentence in English
	 * @return The pig latin version
	 */
	public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {
			// Take care of punctuation and spaces
			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}
			// If there aren't any words left, stop.
			if (i >= s.length())
				break;
			// Otherwise we're at the beginning of a word.
			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			// Now we're at the end of a word, so translate it.
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	/**
	 * Method to find the index of the first vowel in a word.
	 * 
	 * @param word The word to search
	 * @return The index of the first vowel
	 */
	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}
	 public static String translatePigLatinToEnglish(String s) {
	        String english = "";
	        
	        String[] words = s.split(" ");
	        
	        for( String word : words ) {
	            String[] hyphenSplit = word.split("-");
	            String translatedWord = word;
	            String punctuation = "";
	            
	            if( hyphenSplit.length == 2 ) {
	                if( hyphenSplit[1].startsWith("ay")) {
	                    // Started with a vowel
	                    
	                    translatedWord = hyphenSplit[0];
	                } else {
	                    // Started with a consonant
	                    
	                    translatedWord = hyphenSplit[1].substring(0, firstVowel(hyphenSplit[1])) + hyphenSplit[0];
	                }
	                
	                // Handle punctuation at the end of a word
	                int lastLetterIndex = hyphenSplit[1].length() - 1;
	                
	                while( !Character.isLetter(hyphenSplit[1].charAt(lastLetterIndex)) ){
	                    lastLetterIndex -= 1;
	                }
	                
	                punctuation = hyphenSplit[1].substring(lastLetterIndex + 1);
	            }
	            
	            // Add word
	            if( english.isEmpty() ) {
	                english += translatedWord + punctuation;
	            } else {
	                english = english + " " + translatedWord + punctuation;
	            }
	        }
	        
	        return english;
	    }
	 static void speak(String words) {
			
			if (System.getProperty("os.name").contains("Windows")) {
				String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
						+ words + "');\"";
				try {
					Runtime.getRuntime().exec(cmd).waitFor();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					Runtime.getRuntime().exec("say " + words).waitFor();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == Button) {
			String text = field.getText();
			String result = translate(text);
			field2.setText(result);
			
		}
		if (buttonPressed == Button1) {
			String text2 = field2.getText();
			String result2 = translatePigLatinToEnglish(text2);
			field.setText(result2);

		}
		if (buttonPressed == Button2) {
			String answer = field2.getText();
			speak(answer);

		}

	}
}
