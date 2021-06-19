package FoodOrderingAndDeliverySystem;

//Import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CardTopUp {

	// Create component classes
	private static double totalPrice;
	private static double amount;
	private static int index;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lbltitle;
	private static JLabel box_TopUp;
	private static ImageIcon imgVisa;
	private static JLabel lblimgVisa;
	private static ImageIcon imgMaster;
	private static JLabel lblimgMaster;
	private static ImageIcon imgAMEX;
	private static JLabel lblimgAMEX;
	private static JLabel lblCardNum;
	private static JTextField txtCardNum;
	private static JLabel lblCardName;
	private static JTextField txtCardName;
	private static JLabel lblDate;
	private static String month[] = {"Month", "January(01)", "February(02)", "March(03)", "April(04)", "May(05)", "June(06)", "July(07)", "August(08)", "September(09)", "October(10)", "November(11)", "December(12)"}; // set the month of card
	private static String year[] = {"Year", "2020","2021", "2022", "2023", "2024", "2025", "2026"}; // Set the year of card
	private static JComboBox txtMonth;
	private static JComboBox txtYear;
	private static JLabel lblCode;
	private static JPasswordField txtCode;
	private static JButton btnCode;
	private static JFrame myFrame;
	private static JPanel myPanel;
	private static ImageIcon imgCode;
	private static JLabel lblimgCode;
	private static JButton btnPay;
	private static JButton btnCancel;
	private static ImageIcon imgIcon;
	
	// Accept the infomation from TopUpSystem class
	public CardTopUp(double totalPrice, double amount, int index) {
		this.totalPrice = totalPrice;
		this.index = index;
		this.amount = amount;
		
	}
	
	// Launch the program
	public static void main(String[] args) {
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(570, 270, 400, 350);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the JPanel and add it to frame
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		// Create a new ImageIcon
		// Add it into JFrame and set it as ImageIcon of JFrame
		imgIcon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Logo.jpg");
		frame.setIconImage(imgIcon.getImage());
		
		AddDetails();
		
		// Set the frame visible
		frame.setVisible(true);
		
		// After press on ? button, it will show an image that show the location of security code on user's card
		btnCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myFrame = new JFrame();
				myFrame.setTitle("Where is Security Code on card?");
				myFrame.setBounds(570, 270, 420, 380);
				myFrame.setResizable(false);
				myPanel = new JPanel();
				myFrame.add(myPanel);
				myPanel.setLayout(null);
				
				imgCode =  new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\SecurityCode.jpg");
				lblimgCode = new JLabel();
				lblimgCode.setIcon(imgCode);
				lblimgCode.setBounds(0, 0, 400, 350);
				myPanel.add(lblimgCode);
				
				myFrame.setVisible(true);
			}});
		
		// After press Pay button, it will move to Payment class
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CardNum = txtCardNum.getText();
				String CardName = txtCardName.getText();
				String month = (String)txtMonth.getSelectedItem();
				String year = (String)txtYear.getSelectedItem();
				char[]p = txtCode.getPassword();
				String S_Code = "";
				for(int i = 0; i < p.length; i++) {
					S_Code += p[i];
				}
				
				
				if(CardNum.length() == 16 && !(CardName.isEmpty()) && month != "Month" && year != "Year") {
					if((S_Code.length() == 3 || S_Code.length() == 4)) {
						JOptionPane.showMessageDialog(null, "Top Up with credit card successfully! Will automatic return to eWallet payment page and continue your payment!");
						Payment order = new Payment(totalPrice, amount, index, true);
						order.main(null);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Security Code! Please make sure your security code is correct!", "Top Up Error", JOptionPane.ERROR_MESSAGE);
						txtCode.setText(null);
					}
				}
				else if(CardNum.isEmpty()|| CardName.isEmpty() || S_Code.isEmpty() || month == "Month" || year == "Year") {
					JOptionPane.showMessageDialog(null, "Please key in all your card details!", "Top Up Error", JOptionPane.ERROR_MESSAGE);
					
				}				 
				else {
					JOptionPane.showMessageDialog(null, "Invalid Card Number! Please make sure your card number is correct!", "Top Up Error", JOptionPane.ERROR_MESSAGE);
					txtCardNum.setText(null);
				}
		}});
				
		
		// After press the Cancel button, it will return to TopUpSystem
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to cancel the Card Top Up System", "Card Top Up System", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
					TopUpSystem order = new TopUpSystem(totalPrice, index);
					order.main(null);
					frame.dispose();
		}
				
		}
		});
	}
	
	// Create JLabel, ImageIcon, JTextField, JComboBox, JPasswordField and JButton
	public static void AddDetails() {
		
		// Create a new JLabel and set it up
		lbltitle = new JLabel("Invoice");
		lbltitle.setBounds(25, 20, 300, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		box_TopUp = new JLabel();
		box_TopUp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_TopUp.setBounds(10, 10, 350, 270);
		panel.add(box_TopUp);
		
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		imgVisa =  new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\visa.jpg");
		lblimgVisa = new JLabel();
		lblimgVisa.setIcon(imgVisa);
		lblimgVisa.setBounds(30, 30, 200, 80);
		panel.add(lblimgVisa);
		
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		imgMaster =  new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\master.jpg");
		lblimgMaster = new JLabel();
		lblimgMaster.setIcon(imgMaster);
		lblimgMaster.setBounds(150, 30, 200, 80);
		panel.add(lblimgMaster);
		
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		imgAMEX =  new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\AMEX.jpg");
		lblimgAMEX = new JLabel();
		lblimgAMEX.setIcon(imgAMEX);
		lblimgAMEX.setBounds(260, 30, 200, 80);
		panel.add(lblimgAMEX);
		
		// Create a new JLabel and set it up
		lblCardNum = new JLabel("Card Number");
		lblCardNum.setBounds(20, 100, 200, 25);
		lblCardNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCardNum);
		
		// Create a new JTextField for user input and set it up
		txtCardNum = new JTextField();
		txtCardNum.setBounds(140, 100, 200, 25);
		txtCardNum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtCardNum);
		
		// Create a new JLabel and set it up
		lblCardName = new JLabel("Name on Card");
		lblCardName.setBounds(20, 130, 200, 25);
		lblCardName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCardName);
		
		// Create a new JTextField for user input and set it up
		txtCardName = new JTextField();
		txtCardName.setBounds(140, 130, 200, 25);
		txtCardName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtCardName);
		
		// Create a new JLabel and set it up
		lblDate = new JLabel("Expiry Date");
		lblDate.setBounds(20, 160, 200, 25);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDate);
		
		// Create a new JComboBox with array string of month and set it up
		txtMonth = new JComboBox(month);
		txtMonth.setBounds(140, 160, 130, 25);
		txtMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtMonth);
		
		// Create a new JComboBox with array string of year and set it up
		txtYear = new JComboBox(year);
		txtYear.setBounds(280, 160, 60, 25);
		txtYear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtYear);
		
		// Create a new JLabel and set it up
		lblCode = new JLabel("Security Code");
		lblCode.setBounds(20, 190, 200, 25);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCode);
		
		// Create a new JPasswordField for user input and set it up
		txtCode = new JPasswordField();
		txtCode.setBounds(140, 190, 100, 25);
		txtCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtCode);
		
		// Create a '?' JButton for show user location of security code and set it up
		btnCode = new JButton("?");
		btnCode.setBounds(250, 200, 40, 15);
		btnCode.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCode.setFocusable(false);
		panel.add(btnCode);
		
		// Create a 'Pay' JButton for let user continue with payment and set it up
		btnPay = new JButton("Pay");
		btnPay.setBounds(40, 240, 120, 25);
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPay.setFocusable(false);
		btnPay.setMnemonic(KeyEvent.VK_P);
		panel.add(btnPay);
		
		// // Create a 'Cancel' JButton for user to choose again the ways to top up and set it up
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(200, 240, 120, 25);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setFocusable(false);
		btnCancel.setMnemonic(KeyEvent.VK_C);
		panel.add(btnCancel);
		
	}
	
}
