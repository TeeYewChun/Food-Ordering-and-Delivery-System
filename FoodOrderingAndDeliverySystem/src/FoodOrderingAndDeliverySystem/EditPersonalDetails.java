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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

public class EditPersonalDetails{
	
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
	private static JLabel box_Details;
	private static ImageIcon imgIcon;
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
	private static JButton btnConfirm;
	private static JButton btnCancel;
	private static JMenuBar MenuBar;
	private static JMenu FileMenu;
	private static JMenu HelpMenu;
	private static JMenuItem Confirm;
	private static JMenuItem Cancel;
	private static JMenuItem Exit;
	private static JMenuItem Help;
	private static String Num;
	private static String Road;
	private static String Taman;
	private static String Code;
	private static String City;
	private static String State;
	
	// Accept the infomation from ConfirmationSystem class
	public EditPersonalDetails(int index, double totalPrice) {
		this.index = index;
		this.totalPrice = totalPrice;
		
	}
	
	// Create a new JMenuBar
	public static void CreateMenuBar() {
		
		// Add action listener and key event on MenuItem
		MenuBar = new JMenuBar();
		
		FileMenu = new JMenu("File");
		FileMenu.setMnemonic(KeyEvent.VK_F);
		HelpMenu = new JMenu("Help");
		HelpMenu.setMnemonic(KeyEvent.VK_H);
		
		Confirm = new JMenuItem("Confirm", KeyEvent.VK_C);
		Confirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.BUTTON1_DOWN_MASK));
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConfirm.doClick();
				
			}
		});
		
		Cancel = new JMenuItem("Cancel", KeyEvent.VK_L);
		Cancel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.BUTTON1_DOWN_MASK));
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel.doClick();
				
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
				JOptionPane.showMessageDialog(Help, "Delete the old personal details and fill in the new one." + "\n" + "If you confirm want to change it after change your personal details, press on 'Confirm' button." + "\n" + "If you not, press on 'Return' button, it will return to personal details and order details confirmation page." , "Help", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
			
		FileMenu.add(Confirm);
		FileMenu.add(Cancel);
		FileMenu.addSeparator();
		FileMenu.add(Exit);
		HelpMenu.add(Help);
		
		MenuBar.add(FileMenu);
		MenuBar.add(HelpMenu);
		
	}
	
	// Launch the program
	public static void main(String[] args) {
		readFile();
		CreateMenuBar();
		
		// Create the frame and set up the size of frame 
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(520, 230, 500, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setJMenuBar(MenuBar);
		
		// Create a new ImageIcon
		// Add it into JFrame and set it as ImageIcon of JFrame
		imgIcon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Logo.jpg");
		frame.setIconImage(imgIcon.getImage());
		
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		Add_Details();
		
		frame.setVisible(true);
		
		// After press the Confirm button, it will move to ConfirmationSystem class
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ad = txtaddress.getText();
				String postcode = txtpostcode.getText();
				String city = txtcity.getText();
				String state = txtstate.getText();
				String user_phone = txtphonenum.getText();
				String user_name = txtusername.getText();
				
				if(!ad.isEmpty() || !postcode.isEmpty() || !city.isEmpty() || !city.isEmpty() || ! user_name.isEmpty() || !user_phone.isEmpty()) {
					
					int post = 0;
					boolean approve = true;
					int phoneCheck = 0;
					String user_address = "";
					try {
						post = Integer.parseInt(postcode);
					}catch(Exception e1){
						approve = false;
						JOptionPane.showMessageDialog(null, "Postcode must be a number only!", "Postcode Error", JOptionPane.ERROR_MESSAGE);
						txtpostcode.setText(null);
					}
					
					try {
						phoneCheck = Integer.parseInt(user_phone);
					}catch(Exception e1){
						approve = false;
						JOptionPane.showMessageDialog(null, "Phone number must be a number only!", "Phone number Error", JOptionPane.ERROR_MESSAGE);
						txtphonenum.setText(null);
					}
					
					if(approve) {
						user_address = " " + ad + "_ " + post + "#" + city + "_ " + state;
						JOptionPane.showMessageDialog(null, "Edit Personal Details Successful!");
						username.set(index, " " + user_name.toUpperCase());
						phonenum.set(index, " " + user_phone);
						address.set(index, convertC(user_address));
						index = email.size()-1;
						writeFile();
						ConfirmationSystem order = new ConfirmationSystem(true);
						order.main(null);
						frame.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please key in your all new Personal Details!", "Edit Personal Details Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		// After press on Cancel button, it will return to Confirmation System
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfirmationSystem order = new ConfirmationSystem();
				order.main(null);
				frame.dispose();
				
			}
		});
	}
	
	// Create new JLabel, JButton and JTextField 
	public static void Add_Details() {
		Seperate_Address();
		
		// Create a new JLabel and set it up
		lbltitle = new JLabel("Edit Your Personal Details");
		lbltitle.setBounds(110, 20, 300, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		box_Details = new JLabel();
		box_Details.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		box_Details.setBounds(10, 45, 450, 240);
		panel.add(box_Details);
		
		// Create a new JLabel and set it up
		lblusername = new JLabel("Username");
		lblusername.setBounds(20, 60, 80, 25);
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblusername);
		
		// Create a new JTextField for user to change the infomation and set it up
		txtusername = new JTextField(removeSpace(username.get(index)));
		txtusername.setBounds(160, 60, 120, 25);
		txtusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtusername);
		
		// Create a new JLabel and set it up
		lblphonenum = new JLabel("Phone Number");
		lblphonenum.setBounds(20, 90, 150, 25);
		lblphonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblphonenum);
		
		// Create a new JTextField for user to change the infomation and set it up
		txtphonenum = new JTextField(removeSpace(phonenum.get(index)));
		txtphonenum.setBounds(160, 90, 120, 25);
		txtphonenum.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtphonenum);
		
		// Create a new JLabel and set it up
		lbladdress = new JLabel("Address");
		lbladdress.setBounds(20, 120, 80, 25);
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lbladdress);
		
		// Create a new JTextField for user to change the infomation and set it up
		txtaddress = new JTextField(Num + "," + Road + "," + Taman);
		txtaddress.setBounds(160, 120, 250, 50);
		txtaddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtaddress);
		
		// Create a new JLabel and set it up
		lblpostcode = new JLabel("Postcode");
		lblpostcode.setBounds(20, 180, 80, 25);
		lblpostcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblpostcode);
		
		// Create a new JTextField for user to change the infomation and set it up
		txtpostcode = new JTextField(removeSpace(Code));
		txtpostcode.setBounds(160, 180, 100, 25);
		txtpostcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtpostcode);
		
		// Create a new JLabel and set it up
		lblcity = new JLabel("City");
		lblcity.setBounds(280, 180, 80, 25);
		lblcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblcity);
		
		// Create a new JTextField for user to change the infomation and set it up
		txtcity = new JTextField(City);
		txtcity.setBounds(310, 180, 100, 25);
		txtcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtcity);
		
		// Create a new JLabel and set it up
		lblstate = new JLabel("State");
		lblstate.setBounds(20, 210, 80, 25);
		lblstate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblstate);
		
		// Create a new JTextField for user to change the infomation and set it up
		txtstate = new JTextField(removeSpace(State));
		txtstate.setBounds(160, 210, 80, 25);
		txtstate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtstate);
		
		// Create a 'Confirm' JButton for user to save the personal details change and set it up
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(50, 250, 150, 25);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirm.setFocusable(false);
		btnConfirm.setMnemonic(KeyEvent.VK_C);
		panel.add(btnConfirm);
		
		// Create a 'Cancel' JButton for user to cancel edit personal details and set it up
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(250, 250, 150, 25);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setFocusable(false);
		btnCancel.setMnemonic(KeyEvent.VK_L);
		panel.add(btnCancel);
		
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
	
	// Method to seperate address from one line into many line when get the infomation in 'UserDetails.txt' file
	public static void Seperate_Address() {
		String l = removeSpace(convertUnderScore(address.get(index)));
		String[] line = l.split(",");
		String temp;
		String n = "";
		Num = line[0];
		Road = line[1];
		Taman = line[2];
		temp = line[3];
		State = line[4];
		
		String c;
		String[] a = temp.split("#");
		temp = a[0];
		City = a[1];
		for(int b = 0; b < temp.length(); b++) {
			if (temp.charAt(b) == '#') {
				n += ' ';
			}
			else {
				n += temp.charAt(b);
			}
		}
		Code = n;
	}

}
