package FoodOrderingAndDeliverySystem;

//Import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Ebanking {
	
	// Create component classes
	private static double totalPrice;
	private static double amount;
	private static int index;
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel lbltitle;
	private static JLabel box_TopUp;
	private static JLabel lblbank;
	private static JRadioButton txtBank1;
	private static JRadioButton txtBank2;
	private static JRadioButton txtBank3;
	private static ButtonGroup btnGroup;
	private static ImageIcon BankLogo1;
	private static ImageIcon BankLogo2;
	private static ImageIcon BankLogo3;
	private static JLabel lblBankLogo1;
	private static JLabel lblBankLogo2;
	private static JLabel lblBankLogo3;
	private static JLabel lblName;
	private static JTextField txtName;
	private static JLabel lblPassword;
	private static JPasswordField txtPassword;
	private static JLabel lblAmount;
	private static JLabel txtAmount;
	private static JButton btnPay;
	private static JButton btnCancel;
	private static JCheckBox btnShowPassword;
	private static ImageIcon imgIcon;

	// Accept the infomation from TopUpSystem
	public Ebanking(double totalPrice, double amount, int index) {
		this.totalPrice = totalPrice;
		this.index = index;
		this.amount = amount;
		
	}
	
	// Launch the program
	public static void main(String[] args) {
		
		// Create the frame and set it up
		frame = new JFrame();
		frame.setTitle("1988 Café");
		frame.setBounds(570, 270, 400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		// Create the JPanel and add it to frame
		panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		// Create a new ImageIcon
		// Add it into JFrame and set it as ImageIcon of JFrame
		imgIcon = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\Logo.jpg");
		frame.setIconImage(imgIcon.getImage());
		
		Add_Details();
		
		// set text of JLabel 
		txtAmount.setText(String.format("RM %.2f", totalPrice));
		
		// After press on Show Password check box, it will show the password that user entered
		btnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnShowPassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}
				else {
					txtPassword.setEchoChar('*');
				}
				
		}});
		
		// After press on Pay button, it will move to Payment class
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[]p = txtPassword.getPassword();
				String password = "";
				for(int i = 0; i < p.length; i++) {
					password += p[i];
				}
				String name = txtName.getText();
				if(txtBank1.isSelected() || txtBank2.isSelected() || txtBank3.isSelected()) {
					if(!password.isEmpty() && !name.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Top Up with credit card successfully! Will automatic return to eWallet payment page and continue your payment!");
						Payment order = new Payment(totalPrice, amount, index, true);
						order.main(null);
						frame.dispose();
					}
				}
				else if(password.isEmpty() || name.isEmpty() || !(txtBank1.isSelected()) || !(txtBank2.isSelected()) || !(txtBank3.isSelected())) {
					JOptionPane.showMessageDialog(null, "Please key in your payment account details!", "Top Up Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select your bank before click the pay button", "Top Up Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		// After press on Cancel button, it will return to Payment class
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to cancel the Online Top Up System", "FPX Top Up System", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
					TopUpSystem order = new TopUpSystem(totalPrice, index);
					order.main(null);
					frame.dispose();
		}
				
		}
		});
		
		// Set the frame visible
		frame.setVisible(true);
	}
	
	// Create new JLabel, JRadioButton, ImageIcom, JTextField, JPasswordField and JButton
	public static void Add_Details() {
		
		// Create a new JLabel and set it up
		lbltitle = new JLabel("FPX Payment");
		lbltitle.setBounds(25, 20, 300, 25);
		lbltitle.setFont(new Font("Algerian", Font.PLAIN, 18));
		panel.add(lbltitle);
		
		// Create a new JLabel and set it up
		box_TopUp = new JLabel();
		box_TopUp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		box_TopUp.setBounds(10, 10, 350, 330);
		panel.add(box_TopUp);
		
		// Create a new JLabel and set it up
		lblbank = new JLabel("Bank Selected");
		lblbank.setBounds(20, 50, 100, 25);
		lblbank.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblbank);
	        
		// Create a 'Affin Bank' JRadioButton and set it up
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		txtBank1 = new JRadioButton("Affin Bank");
		txtBank1.setBounds(130, 50, 100, 25);
		txtBank1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BankLogo1 = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\AffinBank.jpg");
		lblBankLogo1 = new JLabel();
		lblBankLogo1.setIcon(BankLogo1);
		lblBankLogo1.setBounds(250, 40, 80, 50);
		panel.add(txtBank1);
		panel.add(lblBankLogo1);
		
		// Create a 'Affin Bank' JRadioButton and set it up
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		txtBank2 = new JRadioButton("MayBank2u");
		txtBank2.setBounds(130, 90, 120, 25);
		txtBank2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BankLogo2 = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\maybank.jpg");
		lblBankLogo2 = new JLabel();
		lblBankLogo2.setIcon(BankLogo2);
		lblBankLogo2.setBounds(250, 80, 80, 50);
		panel.add(txtBank2);
		panel.add(lblBankLogo2);
		
		// Create a 'Affin Bank' JRadioButton and set it up
		// Create a new ImageIcon
		// Create a new JLabel and add ImageIcon into label
		txtBank3 = new JRadioButton("Public Bank");
		txtBank3.setBounds(130, 130, 120, 25);
		txtBank3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BankLogo3 = new ImageIcon("C:\\Users\\User\\eclipse-workspace\\FoodOrderingAndDeliverySystem\\src\\publicbank.jpg");
		lblBankLogo3 = new JLabel();
		lblBankLogo3.setIcon(BankLogo3);
		lblBankLogo3.setBounds(250, 120, 80, 50);
		panel.add(txtBank3);
		panel.add(lblBankLogo3);
		
		// Create a new ButtonGroup to limit only one bank can be choosen
		btnGroup = new ButtonGroup();
		btnGroup.add(txtBank1);
		btnGroup.add(txtBank2);
		btnGroup.add(txtBank3);
		
		// Create a new JLabel and set it up
		lblName = new JLabel("UserName");
		lblName.setBounds(20, 170, 150, 25);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblName);
		
		// Create a new JTextField for user input and set it up
		txtName = new JTextField();
		txtName.setBounds(130, 170, 150, 25);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtName);
		
		// Create a new JLabel and set it up
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 200, 150, 25);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblPassword);
		
		// Create a new JPasswordField for user input and set it up
		txtPassword = new JPasswordField();
		txtPassword.setBounds(130, 200, 150, 25);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtPassword);
		
		// Create a new JCheckBox for user to show password entered
		btnShowPassword = new JCheckBox("Show Password");
		btnShowPassword.setBounds(25, 230, 250, 25);
		btnShowPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(btnShowPassword);
		
		// Create a new JLabel and set it up
		lblAmount = new JLabel("Amount");
		lblAmount.setBounds(20, 260, 150, 25);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAmount);
		
		// Create a new JLabel and set it up
		txtAmount = new JLabel();
		txtAmount.setBounds(130, 260, 150, 25);
		txtAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtAmount);
		
		// Create a 'Pay' JButton for user to continue with payment and set it up
		btnPay = new JButton("Pay");
		btnPay.setBounds(40, 300, 150, 25);
		btnPay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPay.setFocusable(false);
		btnPay.setMnemonic(KeyEvent.VK_P);
		panel.add(btnPay);
		
		// Create a 'Cancel' JButton for user to choose again the ways to top up and set it up
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(200, 300, 120, 25);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setFocusable(false);
		btnCancel.setMnemonic(KeyEvent.VK_C);
		panel.add(btnCancel);
		
	}
	
}
