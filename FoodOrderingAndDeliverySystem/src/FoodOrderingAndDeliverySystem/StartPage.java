package FoodOrderingAndDeliverySystem;

// OOP Java Group Assignment 
// Food Ordering and Delivery System

// Welcome page of Food Ordering and Delivery System

// Import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class StartPage {

	// Create component classes
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lblImage;
	private static ImageIcon imgIcon;
	private static JButton btnStart;
	private static JLabel box_Details;

	// Launch the program
	public static void main(String[] args) {
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(550, 200, 379, 530);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		// Create a new ImageIcon
		// Add it into JFrame and set it as ImageIcon of JFrame
		imgIcon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Logo.jpg");
		frame.setIconImage(imgIcon.getImage());
		
		// Create a new ImageIcon
		// Create a new JLabel and and ImageIcon into it
		lblImage = new JLabel("Welcome to 1988 Café!");
		lblImage.setIcon(imgIcon);
		lblImage.setBounds(5, 0, 400, 440);
		lblImage.setHorizontalTextPosition(JLabel.CENTER);
		lblImage.setVerticalTextPosition(JLabel.TOP);
		lblImage.setFont(new Font("Algerian", Font.ITALIC, 15));
		lblImage.setIconTextGap(5);
		panel.add(lblImage);
		
		// Create a 'Start Ordering' button and set it up
		btnStart = new JButton("Start Ordering");
		btnStart.setBounds(110, 450, 150, 25);
		btnStart.setFont(new Font("MV Boli", Font.PLAIN, 15));
		btnStart.setFocusable(false);
		btnStart.setMnemonic(KeyEvent.VK_S);
		panel.add(btnStart);
		
		// Create a new JLabel at set it up
		box_Details = new JLabel();
		box_Details.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Details.setBounds(0, 0, 365, 490);
		panel.add(box_Details);
		
		// After press the Start Orddering button, it will move to SignInSystem class
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignInSystem order = new SignInSystem();
				order.main(null);
				frame.dispose();
			}
		});
		
		// Set the frame visible
		frame.setVisible(true);
	}

}
