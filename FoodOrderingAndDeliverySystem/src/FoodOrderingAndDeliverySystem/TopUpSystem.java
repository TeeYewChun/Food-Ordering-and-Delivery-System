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
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class TopUpSystem{
	
	// Create component classes
	private static ArrayList<String> email = new ArrayList<String>(); 
	private static ArrayList<String> password = new ArrayList<String>();
	private static ArrayList<String> username = new ArrayList<String>();
	private static ArrayList<String> phonenum = new ArrayList<String>();
	private static ArrayList<String> address = new ArrayList<String>();
	private static ArrayList<Double> ewallet = new ArrayList<Double>();
	private static double totalPrice;
	private static int index;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lbltitle;
	private static JLabel box_TopUp;
	private static JLabel lblAmountTopUp;
	private static JTextField txtAmountTopUp;
	private static JLabel lblWaysTopUp;
	private static JRadioButton lblFPX;
	private static JRadioButton lblCard;
	private static ButtonGroup btnGroup;
	private static JButton btnConfirmation;
	private static JButton btnReturn;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem Confirm;
	private static JMenuItem Return;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	private static ImageIcon imgIcon;
	
	// Accept the infomation from Payment class
	public TopUpSystem(double totalPrice, int index) {
		this.totalPrice = totalPrice;
		this.index = index;
		readFile();
	
	}
	
	public static void createMenuBar() {
		
		// Create a new JMenuBar
		// Add action listener and key event on it
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		Confirm = new JMenuItem("Confirm", KeyEvent.VK_C);
		Confirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.BUTTON1_DOWN_MASK));
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirmation.doClick();
				
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
				JOptionPane.showMessageDialog(Help, "Select the way to top up that you more preferred" + "\n" + "If you choose the 'FPX' button and press on 'Confirm' button, it will move to FPX payment page." + "\n" + "If you choose 'Card' button and press on 'Confirm' button, it will move to Card payment page." , "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		FileMenu.add(Confirm);
		FileMenu.add(Return);
		FileMenu.addSeparator();
		FileMenu.add(Exit);
		HelpMenu.add(Help);
		
		MenuBar.add(FileMenu);
		MenuBar.add(HelpMenu);
		
	}

	// Launch the program
	public static void main(String[] args) {
		
		readFile();
		createMenuBar();
		
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
		
		add_Details();
		
		// Set the frame visible
		frame.setVisible(true);
		
		// After press on Confirm button, if the ways to top up choose is FPX, it will move to Ebanking class
		// if the ways to top up choose is Card, it will move to CardTopUp class
		btnConfirmation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String amt = txtAmountTopUp.getText();
				double amount = 0.00;
				boolean approve = true;
				try {
					amount = Double.parseDouble(amt);
					if(!amt.isEmpty() && !(amount == 0)) {
						if(lblFPX.isSelected()) {
							Ebanking order = new Ebanking(totalPrice, amount, index);
							order.main(null);
							frame.dispose();
						}
						else if(lblCard.isSelected()) {
							CardTopUp order = new CardTopUp(totalPrice, amount, index);
							order.main(null);
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Please choose the ways to top up your eWallet!");
						}
					}
				}catch(Exception e1){
					approve = false;
					JOptionPane.showMessageDialog(null, "Amount Top Up must key in number!", "Amount Top Up Error", JOptionPane.ERROR_MESSAGE);
					txtAmountTopUp.setText(null);
				}
			}
		});
				
		// After press the Return button, it will return to Payment class
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to return to Payment page", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				frame.dispose();
				Payment order = new Payment(totalPrice, index);
				order.main(null);
		}}});
	

	}
	
	// Create JLabel, JRadioButton, JTextField and JButton
	public static void add_Details() {
		
		// Create a new JLabel and set it up
		lbltitle = new JLabel("Top Up Your Account");
		lbltitle.setBounds(90, 20, 300, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		box_TopUp = new JLabel();
		box_TopUp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_TopUp.setBounds(10, 45, 350, 130);
		panel.add(box_TopUp);
		
		// Create a new JLabel and set it up
		lblAmountTopUp = new JLabel("Top Up amount");
		lblAmountTopUp.setBounds(20, 60, 150, 25);
		lblAmountTopUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAmountTopUp);
		
		// Create a new JTextField for user input and set it up
		txtAmountTopUp = new JTextField();
		txtAmountTopUp.setBounds(160, 60, 150, 25);
		txtAmountTopUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtAmountTopUp);
		
		// Create a new JLabel and set it up
		lblWaysTopUp = new JLabel("Ways to Top Up");
		lblWaysTopUp.setBounds(20, 90, 150, 25);
		lblWaysTopUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblWaysTopUp);
		
		// Create a 'FPX' JRadioButton for user to choose FPX as the ways to top up and set it up
		lblFPX = new JRadioButton("FPX");
		lblFPX.setBounds(160, 90, 50, 25);
		lblFPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblFPX);
		
		// Create a 'Card' JRadioButton for user to choose card as the ways to top up and set it up
		lblCard = new JRadioButton("Card");
		lblCard.setBounds(230, 90, 100, 25);
		lblCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblCard);
		
		// Create a new ButtonGroup to limit only one ways to top up can be choosen
		btnGroup = new ButtonGroup();
		btnGroup.add(lblFPX);
		btnGroup.add(lblCard);
		
		// Create a 'Confirm' JButton to let user continue top up with card or FPX and set it up
		btnConfirmation = new JButton("Confirm");
		btnConfirmation.setBounds(40, 140, 130, 25);
		btnConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmation.setFocusable(false);
		btnConfirmation.setMnemonic(KeyEvent.VK_C);
		panel.add(btnConfirmation);
		
		// Create a 'Return' JButton to let user change the payment method and set it up
		btnReturn = new JButton("Return");
		btnReturn.setBounds(200, 140, 130, 25);
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
}
