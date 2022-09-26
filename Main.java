import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	
	// We declare the JFrames into private so that we can call it later in the code 
	private JPanel contentPane;
	private LoginFrame LoginMain;
	private DeletingFrame deletingframe;
	private AddFrame addMain;
	private UpdateFrame updateframe;
	
	public static JTable table;
	public static JButton btnAdd;
	public static JButton btnUpdate;
	public static JButton btnDelete;
	
	public static String [] columsTables= {"ID","LAST NAME","FIRST NAME","MIDDLE NAME","AGE","COLLEGE","PROGRAM"};
	public static DefaultTableModel modelCollege = new DefaultTableModel();
	public static String[] colleges= {"CEAS","CBAA","CCE","CON"};
	public static DefaultComboBoxModel<Object>college=new DefaultComboBoxModel<Object>(colleges);
	
	public static String[] CEAS= {"BSEED","BSSED","BSPSY"};
	public static DefaultComboBoxModel<Object>CEASprog=new DefaultComboBoxModel<Object>(CEAS);
	
	public static String[] CBAA= {"BSA","BSBA"};
	public static DefaultComboBoxModel<Object>CBAAprog=new DefaultComboBoxModel<Object>(CBAA);
	
	public static String[] CCE= {"BSCS","BSCPE","BSECE","BSIE"};
	public static DefaultComboBoxModel<Object>CCEprog=new DefaultComboBoxModel<Object>(CCE);
	
	public static String[] CON= {"BSIT","BSN"};
	public static DefaultComboBoxModel<Object>CONprog=new DefaultComboBoxModel<Object>(CON);
	
	public static JButton btnLogin;
	private JLabel lblmainb;
		
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 835, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			// This line of code is used to call the LoginFrame upon clicking the btnLogin
					LoginMain= new LoginFrame();
				// This line of code is for the LoginFrame to be actually visible.
				LoginMain.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(10, 11, 148, 31);
		contentPane.add(btnLogin);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addMain= new AddFrame();
				addMain.setVisible(true);
			}
		});
		btnAdd.setEnabled(false);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(10, 319, 102, 32);
		contentPane.add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 801, 218);
		contentPane.add(scrollPane);
		
		table = new JTable(modelCollege);
		table.setEnabled(false);
		modelCollege.setColumnIdentifiers(columsTables);
		scrollPane.setViewportView(table);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// This line of code is used to call the UpdateFrame upon clicking the btnUpdate.
				updateframe= new UpdateFrame();
			
				// This line of code is used to make the UpdateFrame visible by which another JFrame is shown.
				updateframe.setVisible(true);
				
				// This line of code is to convert the model of the UpdateFrame to modelCollege.
				UpdateFrame.tblAll.setModel(modelCollege);
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(141, 319, 102, 32);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				// This line of code is for the DeleteFrame to be visible upon clicking the btnDelete.
				deletingframe= new DeletingFrame();
				
				// This line of code is used to make the DeleteFrame visible by which another JFrame is shown.
				deletingframe.setVisible(true);
				
				//this code is to set the model of the tblDeleting(table at the DeletingFrame) to model college so that the default model is college.
				deletingframe.tblAllDeleting.setModel(modelCollege);
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(276, 319, 102, 32);
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//this code is simply exiting the program by clicking the btnExit. This button has the capability of deleting all the frames including the child frames.
				System. exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBounds(635, 425, 159, 32);
		contentPane.add(btnExit);
		
		lblmainb = new JLabel("");
		lblmainb.setBounds(0, -30, 832, 498);
		contentPane.add(lblmainb);
		Image PicScreen6=new ImageIcon(this.getClass().getResource("/mainb.png")).getImage();
		lblmainb.setIcon(new ImageIcon(PicScreen6));
	}
}