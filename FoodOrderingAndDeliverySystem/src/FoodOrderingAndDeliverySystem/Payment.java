package FoodOrderingAndDeliverySystem;

//Import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class Payment{
	
	// Create component classes
	private static ArrayList<String> email = new ArrayList<String>(); 
	private static ArrayList<String> password = new ArrayList<String>();
	private static ArrayList<String> username = new ArrayList<String>();
	private static ArrayList<String> phonenum = new ArrayList<String>();
	private static ArrayList<String> address = new ArrayList<String>();
	private static ArrayList<Double> ewallet = new ArrayList<Double>();
	private static double  totalPrice;
	private static int index;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lbltitle;
	private static JLabel box_payment;
	private static JLabel price;
	private static JLabel txtprice;
	private static JLabel lblpayment_method;
	private static String[] payment_method = {"Cash on Delivery(COD)", "eWallet"}; // Set payment method with Cash on Delivery(COD) and eWallet
	private static JComboBox listPayment_method;
	private static JButton btnPay;
	private static JButton btnTopUp;
	private static JButton btnReturn;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem Pay;
	private static JMenuItem TopUp;
	private static JMenuItem Return;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	private static ImageIcon imgIcon;
	private static boolean doneTopUp;
	private static double leftOverMoney;
	private static double currentMoney;
	private static double amount;
	private static JFrame myFrame;
	private static JPanel myPanel;
	private static ImageIcon imgDelivered;
	private static JLabel lblimgDelivered;
	private static JLabel box_Details;

	// Accept the infomation from ConfirmationSystem class
	public Payment(double totalPrice, int index) {
		this.totalPrice = totalPrice;
		this.index = index;
		readFile();
		this.leftOverMoney = ewallet.get(index);
		
	}
	
	// Accept the infomation from CardTopUp class and Ebanking class
	public Payment(double totalPrice, double amount, int index, boolean doneTopUp) {
		readFile();
		this.totalPrice = totalPrice;
		this.index = index;
		this.doneTopUp = doneTopUp;
		this.leftOverMoney = ewallet.get(index);
		this.amount = amount;
		
	}
	
	public static void Create_MenuBar() {
		
		// Create a new JMenuBar
		// Add action listener and key event on it
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		Pay = new JMenuItem("Pay", KeyEvent.VK_P);
		Pay.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.BUTTON1_DOWN_MASK));
		Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPay.doClick();
			}
		});
		
		TopUp = new JMenuItem("Top Up", KeyEvent.VK_T);
		TopUp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.BUTTON1_DOWN_MASK));
		TopUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTopUp.doClick();
			}
		});
		
		Return = new JMenuItem("Return", KeyEvent.VK_N);
		Return.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.BUTTON1_DOWN_MASK));
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReturn.doClick();
				
			}
		});
		
		Exit = new JMenuItem("Exit", KeyEvent.VK_E);
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.BUTTON1_DOWN_MASK));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		Help = new JMenuItem("Help", KeyEvent.VK_P);
		Help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.BUTTON1_DOWN_MASK));
		Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Help, "Select the payment method you more preferred." + "\n" + "If you choose 'Cash on Delivery(COD)' method and press on 'Pay' button, it will show message that successful to place the order." + "\n" + "If you choose 'eWallet' method and press on 'Top Up' button, it will move to Top Up System." , "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		FileMenu.add(Pay);
		FileMenu.add(TopUp);
		FileMenu.add(Return);
		FileMenu.addSeparator();
		FileMenu.add(Exit);
		HelpMenu.add(Help);
		
		MenuBar.add(FileMenu);
		MenuBar.add(HelpMenu);
		
		if(doneTopUp) {
			currentMoney = leftOverMoney + amount;
		}
		else {
			currentMoney = leftOverMoney;
		}
		
	}

	// Launch the program
	public static void main(String[] args) {
		
		Create_MenuBar();
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(570, 290, 400, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setJMenuBar(MenuBar);
		
		// Create the JPanel and add it to frame
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		// Create a new ImageIcon
		// Add it into JFrame and set it as ImageIcon of JFrame
		imgIcon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Logo.jpg");
		frame.setIconImage(imgIcon.getImage());
		
		addBox();
		
		// set text of JLabel 
		txtprice.setText(String.format("RM %.2f", totalPrice));
		
		// If user select on Cash on Delivery(COD), the Top Up button cannot be press 
		listPayment_method.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				String SelectedMethod;
				x = listPayment_method.getSelectedIndex();
				SelectedMethod = payment_method[x];
				if(SelectedMethod.equals("Cash on Delivery(COD)")) {
					btnTopUp.setEnabled(false);
				}
				else {
					btnTopUp.setEnabled(true);
				}
				
			}
		});

		// After press on Pay button, if user choose the Cash on Delivery(COD), it will show order successful.
		// If user choose eWallet and the amount of eWallet is not enough to pay, it will show a message that let user top up eWallet.
		// If user choose eWallet and the amount of eWallet is enough to pay, it will show order successful.
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				String SelectedMethod;
				x = listPayment_method.getSelectedIndex();
				SelectedMethod = payment_method[x];
				
				if(SelectedMethod.equals("Cash on Delivery(COD)")) {
					JOptionPane.showMessageDialog(null, "Your order has been received.");
					myFrame = new JFrame();
					myFrame.setTitle("Preparing......");
					myFrame.setBounds(450, 200, 660, 510);
					myFrame.setResizable(false);
					myPanel = new JPanel();
					myFrame.add(myPanel);
					myPanel.setLayout(null);
					
					box_Details = new JLabel();
					box_Details.setBorder(new LineBorder(new Color(0, 0, 0), 2));
					box_Details.setBounds(0, 0, 645, 470);
					myPanel.add(box_Details);
					
					imgDelivered =  new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\MealDelivered.jpg");
					lblimgDelivered = new JLabel("Your meal is preparing. Will be delivered within an hour");
					lblimgDelivered.setIcon(imgDelivered);
					lblimgDelivered.setBounds(5, 0, 700, 500);
					lblimgDelivered.setHorizontalTextPosition(JLabel.CENTER);
					lblimgDelivered.setVerticalTextPosition(JLabel.TOP);
					lblimgDelivered.setFont(new Font("MV Boli", Font.BOLD, 20));
					lblimgDelivered.setIconTextGap(5);
					myPanel.add(lblimgDelivered);
					
					myFrame.setVisible(true);
					frame.dispose();
					
				}
				else {
					if(currentMoney < totalPrice) {
						ewallet.set(index, Double.parseDouble(String.format("%.2f", currentMoney)));
						writeFile();
						JOptionPane.showConfirmDialog(frame, "Your eWallet balance is low! Please top up your account before do the payment","Pay Error", JOptionPane.OK_OPTION);{
						}
						
					}
					else {
						double a = currentMoney - totalPrice;
						ewallet.set(index, Double.parseDouble(String.format("%.2f", a)));
						JOptionPane.showMessageDialog(null, "Your order has been received.");
						writeFile();
						myFrame = new JFrame();
						myFrame.setTitle("Preparing......");
						myFrame.setBounds(450, 200, 660, 510);
						myFrame.setResizable(false);
						myPanel = new JPanel();
						myFrame.add(myPanel);
						myPanel.setLayout(null);
						
						box_Details = new JLabel();
						box_Details.setBorder(new LineBorder(new Color(0, 0, 0), 2));
						box_Details.setBounds(0, 0, 645, 470);
						myPanel.add(box_Details);
						
						imgDelivered =  new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\MealDelivered.jpg");
						lblimgDelivered = new JLabel("Your meal is preparing. Will be delivered within an hour");
						lblimgDelivered.setIcon(imgDelivered);
						lblimgDelivered.setBounds(5, 0, 700, 500);
						lblimgDelivered.setHorizontalTextPosition(JLabel.CENTER);
						lblimgDelivered.setVerticalTextPosition(JLabel.TOP);
						lblimgDelivered.setFont(new Font("MV Boli", Font.BOLD, 20));
						lblimgDelivered.setIconTextGap(5);
						myPanel.add(lblimgDelivered);
						
						myFrame.setVisible(true);
						frame.dispose();
					}
				}
				
			}});
		
		// After press on Top Up button, it will move to TopUpSystem
		btnTopUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x;
				String SelectedMethod;
				x = listPayment_method.getSelectedIndex();
				SelectedMethod = payment_method[x];
				if(SelectedMethod.equals("eWallet")) {
					email.clear();
					password.clear();
					username.clear();
					phonenum.clear();
					address.clear();
					ewallet.clear();
					TopUpSystem order = new TopUpSystem(totalPrice, index);
					order.main(null);
					frame.dispose();
				}
				
			}
		});
		
		// After press on  Return button, it will return to ConfirmationSystem class
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to return to Confirmation page", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				ConfirmationSystem order = new ConfirmationSystem();
				order.main(null);
				frame.dispose();
				
			}}});
		
		// Set the frame visible
		frame.setVisible(true);
		
	}

	// Create JLabel, JComboBox and JButton
	public static void addBox() {
		
		// Create a new JLabel and set it up
		lbltitle = new JLabel("Payment");
		lbltitle.setBounds(150, 20, 250, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		price = new JLabel("Total Price");
		price.setBounds(20, 50, 100, 25);
		price.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(price);
		
		// Create a new JLabel and set it up
		txtprice = new JLabel("");
		txtprice.setBounds(150, 50, 100, 25);
		txtprice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtprice);
		
		// Create a new JLabel and set it up
		box_payment = new JLabel();
		box_payment.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_payment.setBounds(10, 45, 350, 120);
		panel.add(box_payment);
		
		// Create a new JLabel and set it up
		lblpayment_method = new JLabel("Payment Method");
		lblpayment_method.setBounds(20, 80, 150, 25);
		lblpayment_method.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblpayment_method);
		
		// Create a new JComboBox with array string of payment method and set it up
		listPayment_method = new JComboBox(payment_method);
		listPayment_method.setBounds(150, 80, 200, 25);
		listPayment_method.setFont(new Font("Tahoma", Font.PLAIN, 15));
		listPayment_method.setSelectedItem("eWallet");
		panel.add(listPayment_method);
		
		// Create a 'Pay' JButton for user to pay the bill and set it up
		btnPay = new JButton("Pay");
		btnPay.setBounds(30, 120, 90, 25);
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPay.setFocusable(false);
		btnPay.setMnemonic(KeyEvent.VK_P);
		panel.add(btnPay);
		
		// Create a 'Top Up' JButton for user to top up eWallet and set it up
		btnTopUp = new JButton("Top Up");
		btnTopUp.setBounds(140, 120, 90, 25);
		btnTopUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTopUp.setFocusable(false);
		btnTopUp.setMnemonic(KeyEvent.VK_T);
		panel.add(btnTopUp);
		
		// Create a 'Return' JButton for user to delete order and start ordering again and set it up
		btnReturn = new JButton("Return");
		btnReturn.setBounds(250, 120, 90, 25);
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReturn.setFocusable(false);
		btnReturn.setMnemonic(KeyEvent.VK_N);
		panel.add(btnReturn);
		
		
	}
	
	// Method to read the infomation in 'UserDetails.txt' file
	public static void readFile() {
		try {
		    File file = new File("UserDetails.txt");
		    
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			
			while ((st = br.readLine()) != null) {
				String[] line = st.split(",");
				email.add(line[0]);
				password.add(line[1]);
				username.add(line[2]);
				phonenum.add(line[3]);
				address.add(line[4]);
				ewallet.add(Double.parseDouble(line[5]));
				
			}
			br.close();
		}		
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found!", "File Reading Error!", JOptionPane.ERROR_MESSAGE);
		    e.printStackTrace();
		}
	}
	
	// Method to write the new infomation that user key in into the 'UserDetails.txt' file
	public static void writeFile() {
		try {
			FileWriter writef = new FileWriter("UserDetails.txt"); 
			for (int a = 0; a < email.size(); a++) {
			
				writef.write(email.get(a) + "," + password.get(a) + "," + username.get(a) + "," + phonenum.get(a) + "," + address.get(a) + "," + ewallet.get(a) + "\n");
			}
		    writef.close();
		} 
		catch (IOException e1) {
		    e1.printStackTrace();
		}
	}	
}
