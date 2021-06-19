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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class ConfirmationSystem extends OrderingSystem{

	// Create component classes
	private static double totalPrice;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lbltitle;
	private static JLabel box_Detail;
	private static JLabel lblreferno;
	private static JLabel txtreferno;
	private static JLabel lblPersonalDetail;
	private static JLabel lblo_username;
	private static JLabel txto_username;
	private static JLabel lblo_phonenum;
	private static JLabel txto_phonenum;
	private static JLabel lblo_address;
	private static JLabel txto_address;
	private static JLabel lblOrderDetail;
	private static JTable tblOrder_Item;
	private static int randomnum;
	private static JButton btnpayment;
	private static JLabel lblDeliveryFee;
	private static JLabel txtDeliveryFee;
	private static JLabel lblServiceTax;
	private static JLabel txtServiceTax;
	private static JLabel lblRoundingAdjust;
	private static JLabel txtRoundingAdjust;
	private static JLabel lblTotalPrice;
	private static JLabel txtTotalPrice;
	private static JButton btnreturn;
	private static double ServiceTax = 0;
	private static double RoundingAdjust = 0;
	final private static String[] tblHeader = {"Item", "Qty", "Price"};
	private static DefaultTableModel model;
	private final static int upperbound = 100000;
	private static JButton btnEdit;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem Payment;
	private static JMenuItem Return;
	private static JMenuItem Edit;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	
	// Accept the infomation from EditPersonalDetails class
	public ConfirmationSystem(boolean edit) {
		super(index, totalPrice);
		
		if(edit) {
			email.clear();
			username.clear();
			phonenum.clear();
			address.clear();
			password.clear();
			ewallet.clear();
			readFile();
		}
		
	}
	
	// Accept the infomation from OrderingSystem class
	public ConfirmationSystem() {
		super(index, totalPrice);
		
	}

	public static void createMenuBar() {
		
		// Create a new JMenuBar
		// Add action listener and key event on it
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		Payment = new JMenuItem("Payment", KeyEvent.VK_P);
		Payment.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.BUTTON1_DOWN_MASK));
		Payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnpayment.doClick();
			}
		});
		
		Return = new JMenuItem("Return", KeyEvent.VK_N);
		Return.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.BUTTON1_DOWN_MASK));
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnreturn.doClick();
			}
		});
		
		Edit = new JMenuItem("Edit", KeyEvent.VK_E);
		Edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.BUTTON1_DOWN_MASK));
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.doClick();
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
				JOptionPane.showMessageDialog(Help, "Check your personal details and order details." + "\n" + "If all the infomation are correct, press on 'Continue with payment' button. " + "\n" + "If got the error in personal details, press on the 'Edit' button to fill in your new personal details." + "\n" + "If you are not satisfied with this order, press the 'Return' button to replace a new order.", "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
			
		FileMenu.add(Payment);
		FileMenu.add(Return);
		FileMenu.add(Edit);
		FileMenu.addSeparator();
		FileMenu.add(Exit);
		HelpMenu.add(Help);
		
		MenuBar.add(FileMenu);
		MenuBar.add(HelpMenu);
		
	}
	
	// Print the Ordered Items in OrderingSystem class into JTable
	public static void printTable() {
		for(int a = 0; a < Foods_ELEMENTS; a++) {
			if (Foods_Name[a].isSelected()) {
				int quantity = (int) (Foods_Num[a].getValue());
				if(quantity != 0) {
					model.addRow(new Object[] { Foods_Name[a].getText(), quantity, String.format("RM %.2f", Foods_Price[a]*quantity)});
				}
			}
		}

		for(int a = 0; a < Drinks_ELEMENTS; a++) {
			if (Drinks_Name[a].isSelected()) {
				int quantity = (int) (Drinks_Num[a].getValue());
				if(quantity != 0) {
				model.addRow(new Object[] { Drinks_Name[a].getText(), quantity, String.format("RM %.2f", Drinks_Price[a]*quantity)});
				}
			}
		}
		
		for(int a = 0; a < Desserts_ELEMENTS; a++) {
			if (Desserts_Name[a].isSelected()) {
				int quantity = (int) (Desserts_Num[a].getValue());
				if(quantity != 0) {
				model.addRow(new Object[] { Desserts_Name[a].getText(), quantity, String.format("RM %.2f", Desserts_Price[a]*quantity)});
				}
			}
		}
	}
	
	// Launch the program
	public static void main(String[] args) {
		
		createMenuBar();
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setBounds(400, 20, 750, 780);
		frame.setTitle("1988 Café");
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
		
		add_box();
		
		// Set text of JLabel
		Random rand = new Random();
		randomnum = rand.nextInt(upperbound); 
		txtreferno.setText(String.valueOf(randomnum));
		String o_username = username.get(index);
		txto_username.setText(o_username);
		String o_phonenum = phonenum.get(index);
		txto_phonenum.setText(o_phonenum);
		String o_address = convertUnderScore(address.get(index));
		txto_address.setText(o_address);
		
		CalculateTotal();
		double d = DeliveryFee;
		double servicetax = ServiceTax;
		double roundingadjust = RoundingAdjust;
		double totalprice = totalPrice;
		txtDeliveryFee.setText(String.format("RM %.2f", d));
		txtServiceTax.setText(String.format("RM %.2f", servicetax));
		txtRoundingAdjust.setText(String.format("RM %.2f", roundingadjust));
		txtTotalPrice.setText(String.format("RM %.2f", totalprice));
		
		// Set the frame visible
		frame.setVisible(true);
		
		// After press on Edit button, it will move to EditPersonalDetails class
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPersonalDetails order = new EditPersonalDetails(index, totalPrice);
				order.main(null);
				frame.dispose();
			}
		});
		
		// After press on Payment button, it will move to Payment class
		btnpayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to continue with payment", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					Payment order = new Payment(totalPrice, index);
					order.main(null);
					frame.dispose();
				}
		}});
		
		// After press on Return button, it will return to OrderingSystem and user can replace a new order
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to return to Order Menu page and replace a new order", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					subtotal = 0;
					OrderingSystem order = new OrderingSystem(index, 0.00);
					order.main(null);
					frame.dispose();
				
			}
		}});
	}

	// Create JLabel and JButton
	private static void add_box() { 
		
		// Create a new JLabel and set it up
		lbltitle = new JLabel("Confirm Your Order");
		lbltitle.setBounds(280, 20, 200, 25);	
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		lblreferno = new JLabel("Reference No:");
		lblreferno.setBounds(15, 50, 100, 25);
		lblreferno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblreferno);
		
		// Create a new JLabel and set it up
		txtreferno = new JLabel("");
		txtreferno.setBounds(130, 50, 100, 25);
		txtreferno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtreferno);
		
		// Create a new JLabel and set it up
		lblPersonalDetail = new JLabel("Please confirm your personal details");
		lblPersonalDetail.setBounds(15, 90, 350, 25);
		lblPersonalDetail.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblPersonalDetail);
		
		// Create a new JLabel and set it up
		lblo_username = new JLabel("Username: ");
		lblo_username.setBounds(20, 120, 150, 25);
		lblo_username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblo_username);
		
		// Create a new JLabel and set it up
		txto_username = new JLabel("");
		txto_username.setBounds(150, 120, 150, 25);
		txto_username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txto_username);
		
		// Create a new JLabel and set it up
		lblo_phonenum = new JLabel("Phone Number:");
		lblo_phonenum.setBounds(20, 150, 150, 25);
		lblo_phonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblo_phonenum);
		
		// Create a new JLabel and set it up
		txto_phonenum = new JLabel("");
		txto_phonenum.setBounds(150, 150, 100, 25);
		txto_phonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txto_phonenum);
		
		// Create a new JLabel and set it up
		lblo_address = new JLabel("Address: ");
		lblo_address.setBounds(20, 180, 150, 25);
		lblo_address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblo_address);
		
		// Create a new JLabel and set it up
		txto_address = new JLabel("");
		txto_address.setBounds(150, 180, 750, 25);
		txto_address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txto_address);
		
		// Create a 'Edit' JButton for user to edit personal details and set it up
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(630, 210, 60, 25);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEdit.setFocusable(false);
		btnEdit.setMnemonic(KeyEvent.VK_E);
		panel.add(btnEdit);
		
		// Create a new JLabel and set it up
		lblOrderDetail = new JLabel("Order Detail");
		lblOrderDetail.setBounds(15, 240, 150, 25);
		lblOrderDetail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblOrderDetail);
		
		// Create a new JTable and set it up
		tblOrder_Item = new JTable();
		model = new DefaultTableModel(0, 0);
		model.setColumnIdentifiers(tblHeader);
		model.addRow(tblHeader);
		tblOrder_Item.setModel(model);
		tblOrder_Item.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblOrder_Item.setBounds(150, 270, 1, 1);
		tblOrder_Item.setSize(450, 300);
		tblOrder_Item.getColumnModel().getColumn(0).setPreferredWidth(300);
		tblOrder_Item.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblOrder_Item.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblOrder_Item.setShowGrid(false);
		panel.add(tblOrder_Item);
		printTable();
		 
		// Create a new JLabel and set it up
		lblDeliveryFee = new JLabel("Derivery Fees: ");
		lblDeliveryFee.setBounds(350, 570, 150, 25);
		lblDeliveryFee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDeliveryFee);
	
		// Create a new JLabel and set it up
		txtDeliveryFee = new JLabel("");
		txtDeliveryFee.setBounds(510, 570, 80, 25);
		txtDeliveryFee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtDeliveryFee);
	
		// Create a new JLabel and set it up
		lblServiceTax = new JLabel("Service Tax(6%): ");
		lblServiceTax.setBounds(350, 590, 150, 25);
		lblServiceTax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblServiceTax);
	
		// Create a new JLabel and set it up
		txtServiceTax = new JLabel("");
		txtServiceTax.setBounds(510, 590, 80, 25);
		txtServiceTax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtServiceTax);
	
		// Create a new JLabel and set it up
		lblRoundingAdjust = new JLabel("Rounding Adjustment: ");
		lblRoundingAdjust.setBounds(350, 610, 180, 25);
		lblRoundingAdjust.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblRoundingAdjust);
	
		// Create a new JLabel and set it up
		txtRoundingAdjust = new JLabel("");
		txtRoundingAdjust.setBounds(510, 610, 80, 25);
		txtRoundingAdjust.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtRoundingAdjust);
	
		// Create a new JLabel and set it up
		lblTotalPrice = new JLabel("Total Price: ");
		lblTotalPrice.setBounds(350, 630, 150, 25);
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTotalPrice);
	
		// Create a new JLabel and set it up
		txtTotalPrice = new JLabel("");
		txtTotalPrice.setBounds(510, 630, 80, 25);
		txtTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtTotalPrice);
		
		// Create a 'Continue with paymet' JButton for user to pay the bill and set it up
		btnpayment = new JButton("Continue with Payment");
		btnpayment.setBounds(110, 670, 200, 25);
		btnpayment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnpayment.setFocusable(false);
		btnpayment.setFocusable(false);
		btnpayment.setMnemonic(KeyEvent.VK_P);
		panel.add(btnpayment);
		
		// Create a 'Return' JButton for user to delete order and start ordering again and set it up
		btnreturn = new JButton("Return");
		btnreturn.setBounds(430, 670, 200, 25);
		btnreturn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnreturn.setFocusable(false);
		btnreturn.setMnemonic(KeyEvent.VK_N);
		panel.add(btnreturn);
		
		// Create a new JLabel and set it up
		box_Detail = new JLabel();
		box_Detail.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Detail.setBounds(10, 45, 700, 660);
		panel.add(box_Detail);
		
	}
	
	// Calculate total price of bill
	public static void CalculateTotal() {
		double rounded_totalPrice = 0;
		double b4round_totalPrice = 0;
		ServiceTax = (subtotal * 0.06);
		b4round_totalPrice = subtotal + ServiceTax + DeliveryFee;
		rounded_totalPrice = Math.round(b4round_totalPrice * 10.0) / 10.0;
		RoundingAdjust = (rounded_totalPrice - b4round_totalPrice);
		totalPrice = subtotal + DeliveryFee + ServiceTax + RoundingAdjust;
	}
	
	// Method to get the index of the user
	public int getIndex(String user) {
		int index = email.indexOf(user);
		return index;
	}
	
	// Method to remove space when get the infomation in 'UserDetails.txt' file
	public String removeSpace(String pass) {
		String p = "";
		char space = ' ';
		if(pass.charAt(0) == space) {
			for(int a = 1; a < pass.length(); a++) {
				p += pass.charAt(a);
			}
		}
		
		return p;
	}
	
	// Method to convert address in 'UserDetails.txt' file from underscore into coma
	public static String convertUnderScore(String a) {
		String n = "";
		for(int b = 0; b < a.length(); b++) {
			if(a.charAt(b) == '_') {
				n += ',';
			}
			else if (a.charAt(b) == '#') {
				n += ' ';
			}
			else {
				n += a.charAt(b);
			}
		}
		return n;
	}

}

		
