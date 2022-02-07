package GuessingGamePackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGameFrame {

	// code insert 1 - instance variables of the main class
	private int numberOfGuesses = 0;
	private RandomValue randomValue;
	
	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessingGameFrame window = new GuessingGameFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GuessingGameFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("The Guessing Game");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel.setBounds(10, 77, 396, 139);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess the value:");
		lblNewLabel_1.setLabelFor(textField);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setBounds(30, 34, 193, 48);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfGuesses = 0;
				randomValue.setRandomValue();
				textField.setText("");
				lblNewLabel_1.setText("Can you guess my new value?");
				textField.setEnabled(true);
				btnNewButton.setEnabled(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(160, 195, 116, 21);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfGuesses++;
				int guess = Integer.parseInt(textField.getText());
				if (randomValue.isCorrectValue(guess)) {
					String guessStr = " guess"; 
					if (numberOfGuesses > 1) {
						guessStr = " guesses";
					}
					lblNewLabel.setText("Correct in " + numberOfGuesses + guessStr);
					textField.setEnabled(false);
					btnNewButton.setEnabled(true);
					return;
				}
				
				// if here then incorrect guess
				int difference = randomValue.compareTo(guess);
				if (difference > 0) {
					lblNewLabel.setText(guess + " is too low");
				}
				else {
					lblNewLabel.setText(guess + " is too high");
					textField.setText("");
				}
			}
		});
		textField.setFont(new Font("Arial", Font.PLAIN, 24));
		textField.setBounds(233, 34, 121, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		// code insert 2 - initialization
		randomValue = new RandomValue();
		btnNewButton.setEnabled(false);
	}
}
