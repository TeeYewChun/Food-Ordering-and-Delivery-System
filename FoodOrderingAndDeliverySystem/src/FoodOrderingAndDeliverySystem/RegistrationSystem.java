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

public class RegistrationSystem{
	
	// Create component classes
	private static ArrayList<String> email = new ArrayList<String>(); 
	private static ArrayList<String> password = new ArrayList<String>();
	private static ArrayList<String> username = new ArrayList<String>();
	private static ArrayList<String> phonenum = new ArrayList<String>();
	private static ArrayList<String> address = new ArrayList<String>();
	private static ArrayList<Double> ewallet = new ArrayList<Double>();
	private static int index;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lbltitle;
	private static JLabel lblEmail;
	private static JTextField txtEmail;
	private static JLabel lblpassword;
	private static JPasswordField txtpassword;
	private static JLabel lblconfirmpassword;
	private static JPasswordField txtconfirmpassword;
	private static JLabel lblpassword1instruction;
	private static JLabel lblpassword2instruction;
	private static JCheckBox btnCheckPassword;
	private static JLabel lblusername;
	private static JTextField txtusername;
	private static JLabel lblphonenum;
	private static JTextField txtphonenum;
	private static JLabel lbladdress;
	private static JTextField txtaddress;
	private static JLabel lblpostcode;
	private static JTextField txtpostcode;
	private static JLabel lblcity;
	private static JTextField txtcity;
	private static JLabel lblstate;
	private static JTextField txtstate;
	private static JCheckBox btnaggreement;
	private static JButton btnregister;
	private static JButton btnreturn;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem Register;
	private static JMenuItem Return;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	private static ImageIcon imgIcon;
	private static JLabel box_Details;
	
	public RegistrationSystem(){
		
		// Create a new JMenuBar
		// Add action listener and key event on it
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		Register = new JMenuItem("Register", KeyEvent.VK_R);
		Register.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.BUTTON1_DOWN_MASK));
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnregister.doClick();
			}
		});
		
		Return = new JMenuItem("Return", KeyEvent.VK_N);
		Return.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.BUTTON1_DOWN_MASK));
		Return.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnreturn.doClick();
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
				JOptionPane.showMessageDialog(Help, "Fill in your all details and press on 'Register' button" + "\n" + "After register, you can start your order.", "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		FileMenu.add(Register);
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
		
		// Create the frame and set up the size of frame
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(550, 230, 560, 550);
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
		lbltitle = new JLabel("Sign up your account");
		lbltitle.setBounds(180, 20, 300, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 60, 80, 25);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblEmail);
		
		// Create a new JTextField for user input and set it up
		txtEmail = new JTextField();
		txtEmail.setBounds(160, 60, 250, 25);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtEmail);
		
		// Create a new JLabel and set it up
		lblpassword = new JLabel("Password");
		lblpassword.setBounds(20, 90, 80, 25);
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblpassword);
		
		// Create a new JPasswordField for user input and set it up
		txtpassword = new JPasswordField();
		txtpassword.setBounds(160, 90, 250, 25);
		txtpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtpassword);
		
		// Create a new JLabel and set it up
		lblconfirmpassword = new JLabel("Confirm Password");
		lblconfirmpassword.setBounds(20, 120, 130, 25);
		lblconfirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblconfirmpassword);
		
		// Create a new JPasswordField for user input and set it up
		txtconfirmpassword = new JPasswordField();
		txtconfirmpassword.setBounds(160, 120, 250, 25);
		txtconfirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtconfirmpassword);
		
		// Create a new JLabel and set it up
		lblpassword1instruction = new JLabel("Password must have at least one special symbol among @#$%");
		lblpassword1instruction.setBounds(25, 140, 500, 25);
		lblpassword1instruction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblpassword1instruction);
		
		// Create a new JLabel and set it up
		lblpassword2instruction = new JLabel("Length of password should be between 6 to 20 characters");
		lblpassword2instruction.setBounds(25, 155, 450, 25);
		lblpassword2instruction.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(lblpassword2instruction);
		
		// Create a new JCheckBox for user to show password entered
		btnCheckPassword = new JCheckBox("Show Password");
		btnCheckPassword.setBounds(30, 180, 150, 25);
		btnCheckPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnCheckPassword);
		
		// Create a new JLabel and set it up
		lblusername = new JLabel("Username");
		lblusername.setBounds(20, 210, 80, 25);
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblusername);
		
		// Create a new JTextField for user input and set it up
		txtusername = new JTextField();
		txtusername.setBounds(160, 210, 120, 25);
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtusername);
		
		// Create a new JLabel and set it up
		lblphonenum = new JLabel("Phone Number");
		lblphonenum.setBounds(20, 240, 150, 25);
		lblphonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblphonenum);
		
		// Create a new JTextField for user input and set it up
		txtphonenum = new JTextField();
		txtphonenum.setBounds(160, 240, 120, 25);
		txtphonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtphonenum);
		
		// Create a new JLabel and set it up
		lbladdress = new JLabel("Address");
		lbladdress.setBounds(20, 270, 80, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbladdress);
		
		// Create a new JTextField for user input and set it up
		txtaddress = new JTextField();
		txtaddress.setBounds(160, 270, 250, 50);
		txtaddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtaddress);
		
		// Create a new JLabel and set it up
		lblpostcode = new JLabel("Postcode");
		lblpostcode.setBounds(20, 330, 80, 25);
		lblpostcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblpostcode);
		
		// Create a new JTextField for user input and set it up
		txtpostcode = new JTextField();
		txtpostcode.setBounds(160, 330, 100, 25);
		txtpostcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtpostcode);
		
		// Create a new JLabel and set it up
		lblcity = new JLabel("City");
		lblcity.setBounds(280, 330, 80, 25);
		lblcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblcity);
		
		// Create a new JTextField for user input and set it up
		txtcity = new JTextField();
		txtcity.setBounds(310, 330, 100, 25);
		txtcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtcity);
		
		// Create a new JLabel and set it up
		lblstate = new JLabel("State");
		lblstate.setBounds(20, 360, 80, 25);
		lblstate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblstate);
		
		// Create a new JTextField for user input and set it up
		txtstate = new JTextField();
		txtstate.setBounds(160, 360, 80, 25);
		txtstate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtstate);
		
		// Create a new JCheckBox for user
		btnaggreement = new JCheckBox("Did you aggree to accept our promotion advertisement through email");
		btnaggreement.setBounds(20, 390, 500, 25);
		btnaggreement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnaggreement);
		
		// Create a 'Register' JButton to let user continue with OrderingSystem
		btnregister = new JButton("Register");
		btnregister.setBounds(100, 440, 150, 25);
		btnregister.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnregister.setFocusable(false);
		btnregister.setMnemonic(KeyEvent.VK_R);
		panel.add(btnregister);
		
		// Create a 'Return' button to let user return to SignInSystem 
		btnreturn = new JButton("Return");
		btnreturn.setBounds(300, 440, 150, 25);
		btnreturn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnreturn.setFocusable(false);
		btnreturn.setMnemonic(KeyEvent.VK_N);
		panel.add(btnreturn);
		
		// Create a new JLabel and set it up
		box_Details = new JLabel();
		box_Details.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_Details.setBounds(10, 45, 520, 430);
		panel.add(box_Details);
		
		// Set the frame visible
		frame.setVisible(true);
		
		// After press on the show password check box, the password entered will be shown
		btnCheckPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnCheckPassword.isSelected())
				{
					txtpassword.setEchoChar((char)0);
					txtconfirmpassword.setEchoChar((char)0);
				}
				else {
					txtpassword.setEchoChar('*');
					txtconfirmpassword.setEchoChar('*');
				}
				
		}});
		
		// After press on Register button, it will move to OrderingSystem class
		btnregister.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String Email_format = ".com";
			char[] Password_format = {'"', '[', ',', '!', '@', '#', '$' , '%', '&', '*', '(', ')', '_', '+', '=', '|', '<', '>', '?', '{', '}', '\\', '[', ']', '~', '-', '/'};
			String user_email = txtEmail.getText();
			String ad = txtaddress.getText();
			String postcode = txtpostcode.getText();
			String city = txtcity.getText();
			String state = txtstate.getText();
			String user_phone = txtphonenum.getText();
			String user_name = txtusername.getText();
			
			char[]p = txtpassword.getPassword();
			String user_password = "";
			boolean format = false;
			for(int i = 0; i < p.length; i++) {
				user_password += p[i];
			}
			char[]q = txtconfirmpassword.getPassword();
			String confirmpassword = "";
			for(int i = 0; i < q.length; i++) {
				confirmpassword += q[i];
			}
			
			for (int s = 0; s < user_password.length(); s++) {
		            for(char a : Password_format) { 
		            	if(user_password.charAt(s) == a){
		            		format = true;
		            	}
		            }
		     }
		    
			int post = 0;
			boolean approve = true;
			int phoneCheck = 0;
			String user_address = "";
			try {
				post = Integer.parseInt(postcode);
			}catch(Exception e1){
				approve = false;
				JOptionPane.showMessageDialog(null, "Postcode must be a number only!", "Postcode Error", JOptionPane.ERROR_MESSAGE);
			}
			
			try {
				phoneCheck = Integer.parseInt(user_phone);
			}catch(Exception e1){
				approve = false;
				JOptionPane.showMessageDialog(null, "Phone number must be a number only!", "Phone number Error", JOptionPane.ERROR_MESSAGE);
			}
			
			if(approve) {
				user_address = " " + ad + "_ " + post + "#" + city + "_ " + state;
			}
			
			if(user_email.contains(Email_format) && (user_password.equals(confirmpassword))&& format && user_password.length()>=6 && user_password.length()<=20){
				JOptionPane.showMessageDialog(null, "Register successful!");
				email.add(user_email);
				password.add(" " + user_password);
				address.add(convertC(user_address));
				phonenum.add(" " + user_phone);
				username.add(" " + user_name.toUpperCase());
				ewallet.add(0.00);
				index = email.size()-1;
				writeFile();
				OrderingSystem order = new OrderingSystem(index, 0.00);
				order.main(null);
				frame.dispose();
			}
			else if(!(user_email.contains(Email_format))) {
				JOptionPane.showMessageDialog(null, "Please use email to register your account!", "Registration Error",JOptionPane.ERROR_MESSAGE);
				txtEmail.setText(null);
				btnCheckPassword.setText("Show Password");
				btnaggreement.setText("Did you aggree to accept our promotion advertisement through email");
				
			}
			else if(!(user_password.equals(confirmpassword))) {
				JOptionPane.showMessageDialog(null, "Password is not the same", "Registration Error",JOptionPane.ERROR_MESSAGE);
				txtpassword.setText(null);
				txtconfirmpassword.setText(null);
				btnCheckPassword.setText("Show Password");
				btnaggreement.setText("Did you aggree to accept our promotion advertisement through email");
			}
			else if(!format) {
				JOptionPane.showMessageDialog(null, "Password must have at least one special symbol among @#$%.;:?/!", "Registration Error",JOptionPane.ERROR_MESSAGE);
				txtpassword.setText(null);
				txtconfirmpassword.setText(null);
				btnCheckPassword.setText("Show Password");
				btnaggreement.setText("Did you aggree to accept our promotion advertisement through email");
			}
			else if(!(user_password.length()>=6 && user_password.length()<=20)) {
				JOptionPane.showMessageDialog(null, "Length of password should be between 6 to 20 characters.", "Registration Error",JOptionPane.ERROR_MESSAGE);
				txtpassword.setText(null);
				txtconfirmpassword.setText(null);
				btnCheckPassword.setText("Show Password");
				btnaggreement.setText("Did you aggree to accept our promotion advertisement through email");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid account! Please Re-register your account", "Registration Error",JOptionPane.ERROR_MESSAGE);
				txtEmail.setText(null);
				txtpassword.setText(null);
				txtconfirmpassword.setText(null);
				btnCheckPassword.setAction(null);
				txtusername.setText(null);
				txtphonenum.setText(null);
				txtaddress.setText(null);
				txtpostcode.setText(null);
				txtcity.setText(null);
				txtstate.setText(null);
				btnaggreement.setAction(null); 
				btnCheckPassword.setText("Show Password");
				btnaggreement.setText("Did you aggree to accept our promotion advertisement through email");
			}
			
		}});
		
		// After press on Return button, it will return to SignInSystem class
		btnreturn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to return to sign in page?", "1988 Café", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				frame.dispose();
				SignInSystem order = new SignInSystem();
				order.main(null);
		}}});
	}
	
	// Method to convert address from coma into underscore and write into 'UserDetails.txt' file
	public static String convertC(String a) {
		String n = "";
		for(int b = 0; b < a.length(); b++) {
			if(a.charAt(b) == ',') {
				n += '_';
			}
			else {
				n += a.charAt(b);
			}
		}
		return n;

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
		
						
