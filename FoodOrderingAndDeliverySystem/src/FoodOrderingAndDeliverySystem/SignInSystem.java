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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class SignInSystem{

	// Create component classes
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel lblTitle;
	private static JLabel lblEmail;
	private static JTextField txtEmail;
	private static JLabel lblPassword;
	private static JPasswordField txtPassword;
	private static JCheckBox btnShowPassword;
	private static JButton btnLogin;
	private static JLabel lblcreatenewacc;
	private static JButton btncreatenewacc;
	private static JButton btnexit;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem Login;
	private static JMenuItem CreateNewAcc;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	private static ArrayList<String> email = new ArrayList<String>(); 
	private static ArrayList<String> password = new ArrayList<String>();
	private static ArrayList<String> username = new ArrayList<String>();
	private static ArrayList<String> phonenum = new ArrayList<String>();
	private static ArrayList<String> address = new ArrayList<String>();
	private static ArrayList<Double> ewallet = new ArrayList<Double>();
	private static int index;
	private static ImageIcon imgIcon;
	private static JLabel box_Details;
	
	public SignInSystem() {
		
		// Create a new JMenuBar
		// Add action listener and key event on it
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		Login = new JMenuItem("Sign In", KeyEvent.VK_S);
		Login.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.BUTTON1_DOWN_MASK));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
			}
		});
		
		CreateNewAcc = new JMenuItem("Create Acc", KeyEvent.VK_C);
		CreateNewAcc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.BUTTON1_DOWN_MASK));
		CreateNewAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btncreatenewacc.doClick();
			}
		});
		
		Exit = new JMenuItem("Exit", KeyEvent.VK_E);
		Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.BUTTON1_DOWN_MASK));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnexit.doClick();
				
			}
		});
		
		Help = new JMenuItem("Help", KeyEvent.VK_P);
		Help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.BUTTON1_DOWN_MASK));
		Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Help, "If you are a new user, press on 'Create New Account' button to create a new account." + "\n" + "After you log in, you can start your order.", "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		FileMenu.add(Login);
		FileMenu.add(CreateNewAcc);
		FileMenu.addSeparator();
		FileMenu.add(Exit);
		HelpMenu.add(Help);
		
		MenuBar.add(FileMenu);
		MenuBar.add(HelpMenu);
		
	}

	// Launch the program
	public static void main(String[] args){
		readFile();
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(550, 200, 405, 420);
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
		
		// Create a new JLabel and set it up
		lblTitle = new JLabel("Sign in your account");
		lblTitle.setBounds(120, 20, 300, 25);
		lblTitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lblTitle);
		
		// Create a new JLabel and set it up
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 60, 80, 25);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblEmail);
		
		// Create a new JTextField for user input and set it up
		txtEmail = new JTextField();
		txtEmail.setBounds(110, 60, 230, 25);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtEmail);
		
		// Create a new JLabel and set it up
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 90, 80, 25);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblPassword);
		
		// Create a new JPasswordField for user input and set it up
		txtPassword = new JPasswordField();
		txtPassword.setBounds(110, 90, 230, 25);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtPassword);
		
		// Create a new JCheckBox for user to show password entered
		btnShowPassword = new JCheckBox("Show Password");
		btnShowPassword.setBounds(25, 120, 150, 25);
		btnShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnShowPassword);
		
		// Create a 'Sign In' JButton for user to sign in and set it up
		btnLogin = new JButton("Sign in");
		btnLogin.setBounds(150, 170, 80, 25);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setFocusable(false);
		btnLogin.setMnemonic(KeyEvent.VK_S);
		panel.add(btnLogin);
		
		// Create a new JLabel and set it up
		lblcreatenewacc = new JLabel("Create new account");
		lblcreatenewacc.setBounds(110, 240, 200, 25);
		lblcreatenewacc.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lblcreatenewacc);
		
		// Create a 'Create new account' JButton for user to register and set it up
		btncreatenewacc = new JButton("Create new account");
		btncreatenewacc.setBounds(105, 270, 200, 25);
		btncreatenewacc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncreatenewacc.setFocusable(false);
		btncreatenewacc.setMnemonic(KeyEvent.VK_C);
		panel.add(btncreatenewacc);
		
		// Create a 'Exit' button for user to quit the system
		btnexit = new JButton("Exit");
		btnexit.setBounds(105, 300, 200, 25);
		btnexit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnexit.setFocusable(false);
		btnexit.setMnemonic(KeyEvent.VK_E);
		panel.add(btnexit);
		
		// Create a new JLabel and set it up
		box_Details = new JLabel();
		box_Details.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Details.setBounds(10, 45, 360, 300);
		panel.add(box_Details);
		
		// Set the frame visible
		frame.setVisible(true);
		
		// After press the show password check box, the password entered will be shown
		btnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnShowPassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}
				else {
					txtPassword.setEchoChar('*');
				}
				
			}});
		
		// After press the Sign In button, it will move to OrderingSystem class
		btnLogin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String user_email = txtEmail.getText();
			char[]p = txtPassword.getPassword();
			String user_password = "";
			for(int i = 0; i < p.length; i++) {
				user_password += p[i];
			}
			
			if(email.contains(user_email)){
				index = getIndex(user_email);
				if(removeSpace(password.get(index)).equals(user_password)) {
					OrderingSystem order = new OrderingSystem(index, 0.00);
					order.main(null);
					frame.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Password is incorrect", "Password Error",JOptionPane.ERROR_MESSAGE);
					txtEmail.setText("");
					txtPassword.setText("");
				}
			}
			else if(user_email.isEmpty() || user_password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please key in all details!", "Sign in Error",JOptionPane.ERROR_MESSAGE);
				txtEmail.setText("");
				txtPassword.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid account! Please key in a registed account or register a new one!", "Sign in Error",JOptionPane.ERROR_MESSAGE);
				txtEmail.setText("");
				txtPassword.setText("");
			}	
			
		}});
		
		// After press on Create New Account button, it will move to RegistrationSystem class
		btncreatenewacc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			RegistrationSystem order = new RegistrationSystem();
			order.main(null);
			frame.dispose();
			
		}});
		
		// After press on Exit button, it will quit the system
		btnexit.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
			frame.dispose();
		}
		}
		});
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
		
	// Method to get the index of the user 
	public static int getIndex(String user) {
		int index = email.indexOf(user);
		return index;
	}
		
	// Method to remove space when get the infomation in 'UserDetails.txt' file
	public static String removeSpace(String pass) {
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
			else {
				n += a.charAt(b);
			}
		}
		return n;
	}

}
