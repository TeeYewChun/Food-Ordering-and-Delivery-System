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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.KeyStroke;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OrderingSystem{
	
	// Create component classes
	protected static ArrayList<String> email = new ArrayList<String>(); 
	protected static ArrayList<String> password = new ArrayList<String>();
	protected static ArrayList<String> username = new ArrayList<String>();
	protected static ArrayList<String> phonenum = new ArrayList<String>();
	protected static ArrayList<String> address = new ArrayList<String>();
	protected static ArrayList<Double> ewallet = new ArrayList<Double>();
	protected static int index;
	protected static JFrame frame;
	protected static JPanel panel;
	protected static JLabel lbltitle;
	protected static JLabel box_Foods;
	protected static JLabel box_Drinks;
	protected static JLabel box_Desserts;
	protected static JLabel box_CalculateSubTotal;
	private static JLabel Foods;
	private static JLabel Drinks;
	private static JLabel Desserts;

	protected static JCheckBox[] Foods_Name;
	protected static JSpinner[] Foods_Num;
	private static ImageIcon[] Foods_Image;
	private static JLabel[] lblFoodsImg;
	protected static double[] Foods_Price;
	
	protected static JCheckBox[] Drinks_Name;
	protected static JSpinner[] Drinks_Num;
	private static ImageIcon[] Drinks_Image;
	private static JLabel[] lblDrinksImg;
	protected static double[] Drinks_Price;
	
	protected static JCheckBox[] Desserts_Name;
	protected static JSpinner[] Desserts_Num;
	private static ImageIcon[] Desserts_Image;
	private static JLabel[] lblDessertsImg;
	protected static double[] Desserts_Price;
	
	final protected static int Foods_ELEMENTS = 7; // Set the number of foods at 7
	final protected static int Drinks_ELEMENTS = 6; // Set the number of drinks at 6
	final protected static int Desserts_ELEMENTS = 4; // Set the number of dessert at 4
	final protected static double DeliveryFee = 4; // Set the delivery fee at RM4

	private static double totalPrice = 0;
	protected static double subtotal = 0;
	private static double food1, food2, food3, food4, food5, food6, food7;
    private static double drink1, drink2, drink3, drink4, drink5, drink6;
	private static double dessert1, dessert2, dessert3, dessert4;
	private static double totalForFoods, totalForDrinks, totalForDesserts;
	private static JLabel lblSubTotal;
	private static JLabel txtSubTotal;
	private static JButton btnconfirmation;
	private static JButton btnReset;
	private static JButton btnExit;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem CheckOut;
	private static JMenuItem Reset;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	protected static ImageIcon imgIcon;
	private static ImageIcon imgEnjoyMeal;
	private static JLabel lblimgEnjoyMeal;
	
	// Accept the infomation from RegistrationSystem class or SignInSystem class
	public OrderingSystem(int index, double totalPrice){
		this.index = index;
		this.totalPrice = totalPrice;
		readFile();
		
	}
	
	public static void CreateMenuBar() {
		
		// Create a new JMenuBar
		// Add action listener and key event on it
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		CheckOut = new JMenuItem("Check Out", KeyEvent.VK_C);
		CheckOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.BUTTON1_DOWN_MASK));
		CheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnconfirmation.doClick();
			}
		});
		
		Reset = new JMenuItem("Reset", KeyEvent.VK_R);
		Reset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.BUTTON1_DOWN_MASK));
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReset.doClick();
			}
		});
		
		Exit = new JMenuItem("Exit", KeyEvent.VK_E);
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.BUTTON1_DOWN_MASK));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExit.doClick();
			}
		});
		
		Help = new JMenuItem("Help", KeyEvent.VK_P);
		Help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.BUTTON1_DOWN_MASK));
		Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Help, "Select the items you want to choose and press the quantity you want." + "\n" + "After confirm, you can continue with payment by press on 'Check out' button." + "\n" + "You may reset your meal by press on 'Reset' button" , "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		FileMenu.add(CheckOut);
		FileMenu.add(Reset);
		FileMenu.addSeparator();
		FileMenu.add(Exit);
		HelpMenu.add(Help);
		
		MenuBar.add(FileMenu);
		MenuBar.add(HelpMenu);
		
	}

	// Launch the program
	public static void main(String[] args) {
		
		CreateMenuBar();
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(0, 0, 1550, 850);
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
		AddFoods();
		AddDrinks();
		AddDesserts();
		
		// Set the frame visible
		frame.setVisible(true);
		
		// After press on Confirm button, it will move to ConfirmationSystem class
		btnconfirmation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean order = false;
				for (int a = 0; a < Foods_ELEMENTS; a++) {
					if(Foods_Name[a].isSelected()) {
						int quantity = (int) (Foods_Num[a].getValue());
						if(quantity != 0) {
							order = true;
						}
						
					}
				}
				
				for (int a = 0; a < Drinks_ELEMENTS; a++) {
					if(Drinks_Name[a].isSelected()) {
						int quantity = (int) (Drinks_Num[a].getValue());
						if(quantity != 0) {
							order = true;
						}
						
					}
				}
				
				for (int a = 0; a < Desserts_ELEMENTS; a++) {
					if(Desserts_Name[a].isSelected()) {
						int quantity = (int) (Desserts_Num[a].getValue());
						if(quantity != 0) {
							order = true;
						}
						
					}
				}
				if(order) {
					if(JOptionPane.showConfirmDialog(frame, "Cofirm if you want to check out your order", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
						ConfirmationSystem info = new ConfirmationSystem();
						info.main(null);	
						frame.dispose();
					}	
				}
				else {
					JOptionPane.showMessageDialog(null, "Please order at least one item!", "Order Error", JOptionPane.WARNING_MESSAGE);
				}
		}});

		// After press on Reset button, the infomation entered will be cleared
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtotal = 0;
				frame.dispose();
				OrderingSystem order = new OrderingSystem(index, 0.00);
				order.main(null);
				
		}});
		
		// After press on Exit button, the system will be quit
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					frame.dispose();
				}

			}});
		}
		
	// Calculate subtotal price of items that user selected
	public static void calculate_SubTotal() {
		subtotal = totalForFoods + totalForDrinks + totalForDesserts;
		txtSubTotal.setText(String.format("RM %.2f", subtotal));
		
	}
	
	// Create new JLabel, JButton and ImageIcon
	public	static void addBox() {
			
		// Create a new JLabel and set it up
		lbltitle = new JLabel("Let's start ordering!");
		lbltitle.setBounds(660, 20, 220, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		Foods = new JLabel("Foods");
		Foods.setBounds(30, 70, 80, 25);
		Foods.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(Foods);
		
		// Create a new JLabel and set it up
		Drinks = new JLabel("Drinks");
		Drinks.setBounds(530, 70, 80, 25);
		Drinks.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(Drinks);
		
		// Create a new JLabel and set it up
		Desserts = new JLabel("Desserts");
		Desserts.setBounds(1050, 70, 100, 25);
		Desserts.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(Desserts);
		
		// Create a new JLabel and set it up
		lblSubTotal = new JLabel("Sub Total: ");
		lblSubTotal.setBounds(1040, 610, 80, 25);
		lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblSubTotal);
		
		// Create a new JLabel and set it up
		txtSubTotal = new JLabel("");
		txtSubTotal.setBounds(1150, 610, 80, 25);
		txtSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtSubTotal);
		
		// Create a new JLabel and set it up
		box_Foods = new JLabel();
		box_Foods.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Foods.setBounds(10, 60, 490, 700);
		panel.add(box_Foods);
		
		// Create a new JLabel and set it up
		box_Desserts = new JLabel();
		box_Desserts.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Desserts.setBounds(510, 60, 490, 700);
		panel.add(box_Desserts);
			
		// Create a new JLabel and set it up
		box_Drinks = new JLabel();
		box_Drinks.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Drinks.setBounds(1020, 60, 490, 520);
		panel.add(box_Drinks);
			
		// Create a new JLabel and set it up
		box_CalculateSubTotal = new JLabel();
		box_CalculateSubTotal.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_CalculateSubTotal.setBounds(1020, 600, 230, 160);
		panel.add(box_CalculateSubTotal);
			
		// Create a 'Check out' JButton for user to check the bill and set it up
		btnconfirmation = new JButton("Check out");
		btnconfirmation.setBounds(1050, 640, 150, 25);
		btnconfirmation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnconfirmation.setFocusable(false);
		btnconfirmation.setMnemonic(KeyEvent.VK_C);
		panel.add(btnconfirmation);
			
		// Create a 'Reset' JButton for user to clear ordered item and set it up
		btnReset = new JButton("Reset");
		btnReset.setBounds(1050, 680, 150, 25);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setFocusable(false);
		btnReset.setMnemonic(KeyEvent.VK_R);
		panel.add(btnReset);
			
		// Create a 'Exit' JButton for user to quit the system and set it up
		btnExit = new JButton("Exit");
		btnExit.setBounds(1050, 720, 150, 25);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setFocusable(false);
		btnExit.setMnemonic(KeyEvent.VK_E);
		panel.add(btnExit);
			
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		imgEnjoyMeal = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\enjoymeal.jpg");
		lblimgEnjoyMeal = new JLabel();
		lblimgEnjoyMeal.setIcon(imgEnjoyMeal);
		lblimgEnjoyMeal.setBounds(1260, 580, 400, 200);
		panel.add(lblimgEnjoyMeal);
		
	}
	
	// Create JLabel, JCheckBox, JSpinner and ImageIcon of Foods
	static void AddFoods() {
		
		Foods_Name = new JCheckBox[Foods_ELEMENTS];
		Foods_Num = new JSpinner[Foods_ELEMENTS];
		Foods_Image = new ImageIcon[Foods_ELEMENTS];
		Foods_Price = new double[Foods_ELEMENTS];
		Foods_Name[0] = new JCheckBox("Nasi Lemak");
		Foods_Name[1] = new JCheckBox("Chicken Rice");
		Foods_Name[2] = new JCheckBox("Roti Canai");
		Foods_Name[3] = new JCheckBox("Chicken Chop");
		Foods_Name[4] = new JCheckBox("Hamburger");
		Foods_Name[5] = new JCheckBox("Salad");
		Foods_Name[6] = new JCheckBox("Fries");
		Foods_Price[0] = 3.00;
		Foods_Price[1] = 4.00;
		Foods_Price[2] = 1.50;
		Foods_Price[3] = 10.50;
		Foods_Price[4] = 9.50;
		Foods_Price[5] = 5.50;
		Foods_Price[6] = 4.00;
		Foods_Image[0] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\NasiLemak.jpg");
		Foods_Image[1] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\ChickenRice.jpg");
		Foods_Image[2] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\RotiCanai.jpg");
		Foods_Image[3] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\ChickenChop.jpg");
		Foods_Image[4] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Hamburger.jpg");
		Foods_Image[5] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Salad.jpg");
		Foods_Image[6] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Fries.jpg");
		lblFoodsImg = new JLabel[Foods_ELEMENTS];
		lblFoodsImg[0] = new JLabel("RM 3.00/qty");
		lblFoodsImg[1] = new JLabel("RM 4.00/qty");
		lblFoodsImg[2] = new JLabel("RM 1.50/qty");
		lblFoodsImg[3] = new JLabel("RM10.50/qty");
		lblFoodsImg[4] = new JLabel("RM 9.50/qty");
		lblFoodsImg[5] = new JLabel("RM 5.50/qty");
		lblFoodsImg[6] = new JLabel("RM 4.00/qty");
		
		int a = 100;
		for (int i = 0; i < Foods_ELEMENTS; i++) {
			Foods_Name[i].setBounds(15, a, 150, 25);
			Foods_Name[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 100, 1); // value, minimum, maximun, step size
			Foods_Num[i] = new JSpinner(spnummodel);
			Foods_Num[i].setBounds(375, a, 100, 25);
			Foods_Num[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			Foods_Num[i].addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) { 
						for (int i = 0; i < Foods_ELEMENTS; i++) {
							if(Foods_Name[i].isSelected()) {
								Foods_Num[i].setEnabled(true);
								txtSubTotal.setText("0.00");
							}
							else {
								Foods_Num[i].setEnabled(false);
							}
						}							

						if(Foods_Name[0].isSelected()) {
							int quantity = (int) (Foods_Num[0].getValue());
							food1 = Foods_Price[0] * (double)quantity;
						}
						
						if(Foods_Name[1].isSelected()) {
							int quantity = (int) (Foods_Num[1].getValue());
							food2 = Foods_Price[1] * (double)quantity;
						}
						
						if(Foods_Name[2].isSelected()) {
							int quantity = (int) (Foods_Num[2].getValue());
							food3 = Foods_Price[2] * (double)quantity;
						}
						
						if(Foods_Name[3].isSelected()) {
							int quantity = (int) (Foods_Num[3].getValue());
							food4 = Foods_Price[3] * (double)quantity;
						}
					    if(Foods_Name[4].isSelected()) {
							int quantity = (int) (Foods_Num[4].getValue());
							food5 = Foods_Price[4] * (double)quantity;
						}
					    
						if(Foods_Name[5].isSelected()) {
							int quantity = (int) (Foods_Num[5].getValue());
							food6 = Foods_Price[5] * (double)quantity;
						}
						
						if(Foods_Name[6].isSelected()) {
							int quantity = (int) (Foods_Num[6].getValue());
							food7 = Foods_Price[6] * (double)quantity;
						}
						totalForFoods = food1 + food2 + food3 + food4 + + food5 + food6 + + food7;
						calculate_SubTotal();
				}});
			panel.add(Foods_Name[i]);
			panel.add(Foods_Num[i]);
			a += 90;
		}
		
		lblFoodsImg[0].setIcon(Foods_Image[0]);
		lblFoodsImg[0].setBounds(150, 100, 250, 80);
		lblFoodsImg[0].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[0].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[0].setIconTextGap(5);
		panel.add(lblFoodsImg[0]);
		
		lblFoodsImg[1].setIcon(Foods_Image[1]);
		lblFoodsImg[1].setBounds(150, 190, 250, 80);
		lblFoodsImg[1].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[1].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[1].setIconTextGap(5);
		panel.add(lblFoodsImg[1]);
		
		lblFoodsImg[2].setIcon(Foods_Image[2]);
		lblFoodsImg[2].setBounds(150, 280, 250, 80);
		lblFoodsImg[2].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[2].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[2].setIconTextGap(5);
		panel.add(lblFoodsImg[2]);
		
		lblFoodsImg[3].setIcon(Foods_Image[3]);
		lblFoodsImg[3].setBounds(150, 370, 250, 80);
		lblFoodsImg[3].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[3].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[3].setIconTextGap(5);
		panel.add(lblFoodsImg[3]);
		
		lblFoodsImg[4].setIcon(Foods_Image[4]);
		lblFoodsImg[4].setBounds(150, 460, 250, 80);
		lblFoodsImg[4].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[4].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[4].setIconTextGap(5);
		panel.add(lblFoodsImg[4]);
		
		lblFoodsImg[5].setIcon(Foods_Image[5]);
		lblFoodsImg[5].setBounds(150, 550, 250, 80);
		lblFoodsImg[5].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[5].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[5].setIconTextGap(5);
		panel.add(lblFoodsImg[5]);
		
		lblFoodsImg[6].setIcon(Foods_Image[6]);
		lblFoodsImg[6].setBounds(150, 640, 250, 80);
		lblFoodsImg[6].setHorizontalTextPosition(JLabel.LEFT);
		lblFoodsImg[6].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblFoodsImg[6].setIconTextGap(5);
		panel.add(lblFoodsImg[6]);
	}
	
	// Create JLabel, JCheckBox, JSpinner and ImageIcon of Drinks
	static void AddDrinks() {
		Drinks_Name = new JCheckBox[Drinks_ELEMENTS];
		Drinks_Num = new JSpinner[Drinks_ELEMENTS];
		Drinks_Price = new double[Drinks_ELEMENTS];
		Drinks_Name[0] = new JCheckBox("Coffee");
		Drinks_Name[1] = new JCheckBox("Orange Juice");
		Drinks_Name[2] = new JCheckBox("Tea");
		Drinks_Name[3] = new JCheckBox("Bubble Milk Tea");
		Drinks_Name[4] = new JCheckBox("Lemon Tea");
		Drinks_Name[5] = new JCheckBox("Strawberry Smoothie");
		Drinks_Price[0] = 3.00;
		Drinks_Price[1] = 4.00;
		Drinks_Price[2] = 3.00;
		Drinks_Price[3] = 7.50;
		Drinks_Price[4] = 3.50;
		Drinks_Price[5] = 8.50;
		Drinks_Image = new ImageIcon[Drinks_ELEMENTS];
		Drinks_Image[0] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Coffee.jpg");
		Drinks_Image[1] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\OrangeJuice.jpg");
		Drinks_Image[2] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Tea.jpg");
		Drinks_Image[3] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\BubbleMilkTea.jpg");
		Drinks_Image[4] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\LemonTea.jpg");
		Drinks_Image[5] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\StrawberrySmoothie.jpg");
		lblDrinksImg = new JLabel[Drinks_ELEMENTS];
		lblDrinksImg[0] = new JLabel("RM 3.00/qty");
		lblDrinksImg[1] = new JLabel("RM 4.00/qty");
		lblDrinksImg[2] = new JLabel("RM 3.00/qty");
		lblDrinksImg[3] = new JLabel("RM 7.50/qty");
		lblDrinksImg[4] = new JLabel("RM 3.50/qty");
		lblDrinksImg[5] = new JLabel("RM 8.50/qty");
		
		int b = 100;
		for (int i = 0; i < Drinks_ELEMENTS; i++) {
			Drinks_Name[i].setBounds(515, b, 175, 25);
			Drinks_Name[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 100, 1); // value, minimum, maximum, step size
			Drinks_Num[i] = new JSpinner(spnummodel);
			Drinks_Num[i].setBounds(880, b, 100, 25);
			Drinks_Num[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			Drinks_Num[i].addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					for (int i = 0; i < Drinks_ELEMENTS; i++) {
					if(Drinks_Name[i].isSelected()) {
						Drinks_Num[i].setEnabled(true);
						txtSubTotal.setText("0.00");
					}
					else {
						Drinks_Num[i].setEnabled(false);
						}
					}
						
					if(Drinks_Name[0].isSelected()) {
						int quantity = (int) (Drinks_Num[0].getValue());
						drink1 = Drinks_Price[0] * (double)quantity;
					}
					 
					if(Drinks_Name[1].isSelected()) {
						int quantity = (int) (Drinks_Num[1].getValue());	
						drink2 = Drinks_Price[1] * (double)quantity;
						}
					
					if(Drinks_Name[2].isSelected()) {
						int quantity = (int) (Drinks_Num[2].getValue());
						drink3 = Drinks_Price[2] * (double)quantity;
					}
					
					if(Drinks_Name[3].isSelected()) {
						int quantity = (int) (Drinks_Num[3].getValue());
						drink4 = Drinks_Price[3] * (double)quantity;
					}
					
					if(Drinks_Name[4].isSelected()) {
						int quantity = (int) (Drinks_Num[4].getValue());	
						drink5 = Drinks_Price[4] * (double)quantity;
					}
					
					if(Drinks_Name[5].isSelected()) {
						int quantity = (int) (Foods_Num[5].getValue());
						drink6 = Drinks_Price[5] * (double)quantity;
					}
					totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5 + drink6;
					calculate_SubTotal();
				}});
			panel.add(Drinks_Name[i]);		
			panel.add(Drinks_Num[i]);
			b += 110;
		}
		
		lblDrinksImg[0].setIcon(Drinks_Image[0]);
		lblDrinksImg[0].setBounds(655, 100, 250, 80);
		lblDrinksImg[0].setHorizontalTextPosition(JLabel.LEFT);
		lblDrinksImg[0].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDrinksImg[0].setIconTextGap(5);
		panel.add(lblDrinksImg[0]);
		
		lblDrinksImg[1].setIcon(Drinks_Image[1]);
		lblDrinksImg[1].setBounds(655, 210, 250, 80);
		lblDrinksImg[1].setHorizontalTextPosition(JLabel.LEFT);
		lblDrinksImg[1].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDrinksImg[1].setIconTextGap(20);
		panel.add(lblDrinksImg[1]);
		
		lblDrinksImg[2].setIcon(Drinks_Image[2]);
		lblDrinksImg[2].setBounds(655, 320, 250, 80);
		lblDrinksImg[2].setHorizontalTextPosition(JLabel.LEFT);
		lblDrinksImg[2].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDrinksImg[2].setIconTextGap(5);
		panel.add(lblDrinksImg[2]);
		
		lblDrinksImg[3].setIcon(Drinks_Image[3]);
		lblDrinksImg[3].setBounds(655, 430, 250, 80);
		lblDrinksImg[3].setHorizontalTextPosition(JLabel.LEFT);
		lblDrinksImg[3].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDrinksImg[3].setIconTextGap(5);
		panel.add(lblDrinksImg[3]);
		
		lblDrinksImg[4].setIcon(Drinks_Image[4]);
		lblDrinksImg[4].setBounds(655, 540, 250, 80);
		lblDrinksImg[4].setHorizontalTextPosition(JLabel.LEFT);
		lblDrinksImg[4].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDrinksImg[4].setIconTextGap(4);
		panel.add(lblDrinksImg[4]);
		
		lblDrinksImg[5].setIcon(Drinks_Image[5]);
		lblDrinksImg[5].setBounds(655, 650, 250, 80);
		lblDrinksImg[5].setHorizontalTextPosition(JLabel.LEFT);
		lblDrinksImg[5].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDrinksImg[5].setIconTextGap(5);
		panel.add(lblDrinksImg[5]);
	}
	
	// Create JLabel, JCheckBox, JSpinner and ImageIcon of Desserts
	static void AddDesserts() {
		Desserts_Name = new JCheckBox[Desserts_ELEMENTS];
		Desserts_Num = new JSpinner[Desserts_ELEMENTS];
		Desserts_Price = new double[Desserts_ELEMENTS];
		Desserts_Name[0] = new JCheckBox("Chocolate Muffin");
		Desserts_Name[1] = new JCheckBox("Ice Cream Waffle");
		Desserts_Name[2] = new JCheckBox("Oreo Cheese Cake");
		Desserts_Name[3] = new JCheckBox("Pancake with Syrup");
		Desserts_Price[0] = 5.00;
		Desserts_Price[1] = 5.50;
		Desserts_Price[2] = 9.00;
		Desserts_Price[3] = 6.50;
		Desserts_Image = new ImageIcon[Desserts_ELEMENTS];
		Desserts_Image[0] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\ChocolateMuffin.jpg");
		Desserts_Image[1] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\WaffleIceCream.jpg");
		Desserts_Image[2] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\OreoCheeseCake.jpg");
		Desserts_Image[3] = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\PancakewithSyrup.jpg");
		lblDessertsImg = new JLabel[Desserts_ELEMENTS];
		lblDessertsImg[0] = new JLabel("RM 5.00/qty");
		lblDessertsImg[1] = new JLabel("RM 5.50/qty");
		lblDessertsImg[2] = new JLabel("RM 9.00/qty");
		lblDessertsImg[3] = new JLabel("RM 6.50/qty");
		
		int c = 100;
		for (int i = 0; i < Desserts_ELEMENTS; i++) {
			Desserts_Name[i].setBounds(1025, c, 165, 25);
			Desserts_Name[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 100, 1); // value, minimum, maximum, step size
			Desserts_Num[i] = new JSpinner(spnummodel);
			Desserts_Num[i].setBounds(1385, c, 100, 25);
			Desserts_Num[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			Desserts_Num[i].addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					for (int i = 0; i < Desserts_ELEMENTS; i++) {
						if(Desserts_Name[i].isSelected()) {
							Desserts_Num[i].setEnabled(true);
							txtSubTotal.setText("0.00");
						}
						else {
							Desserts_Num[i].setEnabled(false);
						}
					}
					
					if(Desserts_Name[0].isSelected()) {
						int quantity = (int) (Desserts_Num[0].getValue());
						dessert1 = Desserts_Price[0] * (double)quantity;
					}
					
					if(Desserts_Name[1].isSelected()) {
						int quantity = (int) (Desserts_Num[1].getValue());
						dessert2 = Desserts_Price[1] * (double)quantity;
					}
					
					if(Desserts_Name[2].isSelected()) {
						int quantity = (int) (Desserts_Num[2].getValue());
						dessert3 = Desserts_Price[2] * (double)quantity;
					}
						
					if(Desserts_Name[3].isSelected()) {
						int quantity = (int) (Desserts_Num[3].getValue());
						dessert4 = Desserts_Price[3] * (double)quantity;
					}
					totalForDesserts = dessert1 + dessert2 + dessert3 + dessert4;
					calculate_SubTotal();		
				}});
			panel.add(Desserts_Name[i]);
			panel.add(Desserts_Num[i]);
			c += 115;
		}
		
		lblDessertsImg[0].setIcon(Desserts_Image[0]);
		lblDessertsImg[0].setBounds(1160, 100, 250, 80);
		lblDessertsImg[0].setHorizontalTextPosition(JLabel.LEFT);
		lblDessertsImg[0].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDessertsImg[0].setIconTextGap(5);
		panel.add(lblDessertsImg[0]);
		
		lblDessertsImg[1].setIcon(Desserts_Image[1]);
		lblDessertsImg[1].setBounds(1160, 215, 250, 80);
		lblDessertsImg[1].setHorizontalTextPosition(JLabel.LEFT);
		lblDessertsImg[1].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDessertsImg[1].setIconTextGap(5);
		panel.add(lblDessertsImg[1]);
		
		lblDessertsImg[2].setIcon(Desserts_Image[2]);
		lblDessertsImg[2].setBounds(1160, 330, 250, 80);
		lblDessertsImg[2].setHorizontalTextPosition(JLabel.LEFT);
		lblDessertsImg[2].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDessertsImg[2].setIconTextGap(5);
		panel.add(lblDessertsImg[2]);
		
		lblDessertsImg[3].setIcon(Desserts_Image[3]);
		lblDessertsImg[3].setBounds(1160, 445, 250, 80);
		lblDessertsImg[3].setHorizontalTextPosition(JLabel.LEFT);
		lblDessertsImg[3].setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblDessertsImg[3].setIconTextGap(5);
		panel.add(lblDessertsImg[3]);
		
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
			JOptionPane.showMessageDialog(null, "File not found!", "File Reading Error", JOptionPane.ERROR_MESSAGE);
		    e.printStackTrace();
		}
	}
	
}
	
	




