import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JButton btnShow;
	private JButton btnLogin2;
	// Here we declare a boolean called hide to true, because we will use it in the showing and hiding of the password later.
 	public static boolean hide=true;

	public LoginFrame() {
		setTitle("LOGIN ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// This line of code is simply setting the location of JFrame to center.
		setLocationRelativeTo(null);
		
		JLabel lblEmail = new JLabel("USERNAME : ");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(10, 11, 102, 26);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(182, 14, 150, 26);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD : ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(10, 47, 117, 26);
		contentPane.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(182, 59, 150, 26);
		contentPane.add(txtPassword);
		
		btnShow = new JButton("SHOW");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// If the hide is true, the condition inside the if statement will be do.
				if(hide) {
				// Here the echo char is changed to char(to see the character one by one).
						txtPassword.setEchoChar((char)0);
			 			
			 		}else {
			 			// Here if the boolean hide is false, it will set the char to "*" (password default char).
			 			txtPassword.setEchoChar('*');
			 		}
				// Here if the boolean hide is true, it will be false, else it will be true.
						hide=!hide;
			}
		});
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnShow.setBounds(192, 95, 85, 26);
		contentPane.add(btnShow);
		
		btnLogin2 = new JButton("LOGIN");
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	We declare a string to be a storage for the txtPassword.
				String pass = txtPassword.getText();
			//	We declare a string to be a storage for the txtEmail.
				String username= txtEmail.getText();
				
				// Here we declare the default pass and username to admin.
				// If the password is equal to admin and user equal to admin the condition inside the if stament will be executed.
				if(pass.equals("admin")&&username.equals("admin")) {
				// The LoginFrame will be "setvisible" to false.
					setVisible(false);
					
				// Before the user can access all the buttons, first he/she must enter the right username and password (admin, admin).
				// The button in main will be set enabled to true if the conditioned is satisfied so that the user will be able to access the program.
					Main.btnDelete.setEnabled(true);
					Main.btnAdd.setEnabled(true);
					Main.btnUpdate.setEnabled(true);
					Main.btnLogin.setEnabled(false);
					
				}else {
					// This line of code is for the checking if the if statement is not satisfied. This line of code will show up.
					JOptionPane.showMessageDialog(null, "PLEASE ENTER THE CORRECT PASSWORD AND EMAIL!!");
				}
				
		 	}
			
		});
		btnLogin2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin2.setBounds(10, 142, 148, 31);
		contentPane.add(btnLogin2);
		
		JLabel lblProfile = new JLabel("");
		lblProfile.setBackground(Color.CYAN);
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(132, 11, 47, 33);
		contentPane.add(lblProfile);
		Image PicScreen1=new ImageIcon(this.getClass().getResource("/profile-group-icon.png")).getImage();
		lblProfile.setIcon(new ImageIcon(PicScreen1));
		
		JLabel lblPadlock = new JLabel("");
		lblPadlock.setBounds(132, 55, 47, 30);
		contentPane.add(lblPadlock);
		Image PicScreen2=new ImageIcon(this.getClass().getResource("/lock-icon.png")).getImage();
		lblPadlock.setIcon(new ImageIcon(PicScreen2));
		
		JLabel lblgg1 = new JLabel("");
		lblgg1.setBackground(Color.CYAN);
		lblgg1.setBounds(-10, 0, 352, 263);
		contentPane.add(lblgg1);
		Image PicScreen3=new ImageIcon(this.getClass().getResource("/gg1.png")).getImage();
		lblgg1.setIcon(new ImageIcon(PicScreen3));
		
		
	}
}