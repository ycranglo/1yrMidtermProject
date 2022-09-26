import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UpdateFrame extends JFrame {

	public static JPanel contentPane;
	public static JTextField txtMnameUpdate;
	public static JTextField txtLnameUpdate;
	public static JTable tblAll;
	public static boolean isupdate=false;
	public static String [] columsTablesUpdate= {"ID","LAST NAME","FIRST NAME","MIDDLE NAME","AGE","COLLEGE","PROGRAM"};
	
	
	
	// We declare all of this to private so that we can call it later in the code.
	private AddFrame addMain;
	
	// This line is a string array that will hold the college.
		// Then we create a defaultcombobox to contain the string of array created beforehand.
	public static String[] colleges= {"CEAS","CBAA","CCE","CON"};
	public static DefaultComboBoxModel<Object>college=new DefaultComboBoxModel<Object>(colleges);
	
	public static String[] CEAS= {"BSEED","BSSED","BSPSY"};
	public static DefaultComboBoxModel<Object>CEASprog=new DefaultComboBoxModel<Object>(CEAS);
	
	public static String[] CBAA= {"BSA","BSBA"};
	public static DefaultComboBoxModel<Object>CBAAprog=new DefaultComboBoxModel<Object>(CBAA);
	
	public static String[] CCE= {"BSCS","BSCPE","BSECE","BSIE","BSIT"};
	public static DefaultComboBoxModel<Object>CCEprog=new DefaultComboBoxModel<Object>(CCE);
	
	public static String[] CON= {"BSN"};
	public static DefaultComboBoxModel<Object>CONprog=new DefaultComboBoxModel<Object>(CON);
	
	
	public static JComboBox cboCollegeUpdate;
	public static JComboBox cboCourseUpdate;
	public static JDateChooser dateChooser;
	public static JLabel lblAgeUpdate;
	public static JTextField txtFnameUpdate;

	// We also declare integers for the datechooser(storage for the month, days and years).
	public static int Resultyear;
	public static int day;
	public static int month;
	public static int year;

	public static JButton btnGetAgeUpdate;
	public static JButton btnSaveUp;
	public static JLabel lblIDUpdate;
	public static JButton btnUpdateUp;
	private JLabel lblgg2;
	private JLabel lblgg3;

	public UpdateFrame() {
		setTitle("UPDATE STUDENTS INFO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 760, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// This code is simply setting the location of JFrame to center.
		setLocationRelativeTo(null);
		
		JLabel lblFNameUpdate = new JLabel("FIRST NAME : ");
		lblFNameUpdate.setForeground(new Color(0, 0, 0));
		lblFNameUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFNameUpdate.setBounds(10, 10, 110, 28);
		contentPane.add(lblFNameUpdate);
		
		JLabel lblMNameUpdate = new JLabel("MIDDLE NAME : ");
		lblMNameUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMNameUpdate.setBounds(10, 48, 110, 28);
		contentPane.add(lblMNameUpdate);
		
		JLabel lblLNameUpdate = new JLabel("LAST NAME : ");
		lblLNameUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLNameUpdate.setBounds(10, 92, 110, 28);
		contentPane.add(lblLNameUpdate);
		
		lblIDUpdate = new JLabel("ID : ");
		lblIDUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIDUpdate.setBounds(10, 136, 110, 28);
		contentPane.add(lblIDUpdate);
		
		JLabel lblBDateUpdate = new JLabel("BIRTH DATE : ");
		lblBDateUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBDateUpdate.setBounds(264, 10, 110, 28);
		contentPane.add(lblBDateUpdate);
		
		lblAgeUpdate = new JLabel("AGE : ");
		lblAgeUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAgeUpdate.setBounds(264, 56, 110, 28);
		contentPane.add(lblAgeUpdate);
		
		JLabel lblCollegeUpdate = new JLabel("COLLEGE : ");
		lblCollegeUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCollegeUpdate.setBounds(264, 100, 110, 28);
		contentPane.add(lblCollegeUpdate);
		
		JLabel lblCourseUpdate = new JLabel("COURSE : ");
		lblCourseUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCourseUpdate.setBounds(264, 144, 110, 28);
		contentPane.add(lblCourseUpdate);
		
		txtFnameUpdate = new JTextField();
		txtFnameUpdate.setEnabled(false);
		txtFnameUpdate.setBounds(102, 15, 128, 22);
		contentPane.add(txtFnameUpdate);
		txtFnameUpdate.setColumns(10);
		
		txtMnameUpdate = new JTextField();
		txtMnameUpdate.setEnabled(false);
		txtMnameUpdate.setColumns(10);
		txtMnameUpdate.setBounds(102, 53, 128, 22);
		contentPane.add(txtMnameUpdate);
		
		txtLnameUpdate = new JTextField();
		txtLnameUpdate.setEnabled(false);
		txtLnameUpdate.setColumns(10);
		txtLnameUpdate.setBounds(102, 98, 128, 22);
		contentPane.add(txtLnameUpdate);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(381, 10, 85, 19);
		contentPane.add(dateChooser);
		
		cboCollegeUpdate = new JComboBox<Object>(college);
		cboCollegeUpdate.setEnabled(false);
		cboCollegeUpdate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			
				// Here if the user select a data it will match in the model of cboCollege, the model of cboCourse will be change dynamically.
				if(cboCollegeUpdate.getSelectedItem()=="CEAS") {
					cboCourseUpdate.setModel(CEASprog);
				}else if(cboCollegeUpdate.getSelectedItem()=="CBAA") {
					cboCourseUpdate.setModel(CBAAprog);
				}else if(cboCollegeUpdate.getSelectedItem()=="CCE") {
					cboCourseUpdate.setModel(CCEprog);
				}else if(cboCollegeUpdate.getSelectedItem()=="CON") {
					cboCourseUpdate.setModel(CONprog);
				} 
				
			}
			
		});
		cboCollegeUpdate.setBounds(339, 106, 110, 19);
		contentPane.add(cboCollegeUpdate);
		
		cboCourseUpdate = new JComboBox<Object>(CEASprog);
		cboCourseUpdate.setEnabled(false);
		cboCourseUpdate.setBounds(339, 145, 110, 19);
		contentPane.add(cboCourseUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 709, 140);
		contentPane.add(scrollPane);
		
		tblAll = new JTable(Main.modelCollege) {

			public boolean editCellAt(int row,int column,java.util.EventObject e) {
				return false;
			   }
			};
		tblAll.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(isupdate== true) {
					int selectedrows =tblAll.getSelectedRow();
					
					
					/*
					 * To display current selected row.
					 * 
					 */
					lblIDUpdate.setText(Main.modelCollege.getValueAt(selectedrows, 0).toString());
					
					/*
					 *  This will Display the lastname in jtable using index 1.	
					 */
				txtLnameUpdate.setText(Main.modelCollege.getValueAt(selectedrows, 1).toString());
					/*
					 *  Display the firstname in jtable using index 2.
					 */
				txtFnameUpdate.setText(Main.modelCollege.getValueAt(selectedrows, 2).toString());
					
					/*
					 *  Display the firstname in jtable using index 3.
					 */
					txtMnameUpdate.setText(Main.modelCollege.getValueAt(selectedrows, 3).toString());
					
					/*
					 *  Display the AGE in jtable using index 4.
					 */
					lblAgeUpdate.setText(Main.modelCollege.getValueAt(selectedrows, 4).toString());
					

					/*
					 *  Display the cboCollege and cboCourse  in JTable using index 4.
					 */
					cboCollegeUpdate.setSelectedItem(Main.modelCollege.getValueAt(selectedrows, 5).toString());
					cboCourseUpdate.setSelectedItem(Main.modelCollege.getValueAt(selectedrows, 6).toString());
				}
				
			}
		
	});
		
			tblAll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			tblAll.setEnabled(false);
			Main.modelCollege.setColumnIdentifiers(columsTablesUpdate);
		scrollPane.setViewportView(tblAll);
		
		btnGetAgeUpdate = new JButton("GET AGE");
		btnGetAgeUpdate.setEnabled(false);
		btnGetAgeUpdate.addActionListener(new ActionListener() {
			public static String dateofbirth;
			public static String dobs[];

			public void actionPerformed(ActionEvent e) {
				
				// Here we declare a string for the date chooser, so that the user will be able to type the birthday.
				dateofbirth = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				// We also declare a string for the day, months and years to be split.
				dobs = dateofbirth.split("/");
				
				// We parse it to intgers so that we can compute the age of the user.
				 day = Integer.parseInt(dobs[0]);
				 month = Integer.parseInt(dobs[1]);
				 year = Integer.parseInt(dobs[2]);
				  // We get the date from the input of the user.
				LocalDate selectedData = LocalDate.of(year,month,day);
				 // Then we get the current date.
				LocalDate currentDate = LocalDate.now();
				// Then we declare a new int for the storage of the age.
				 // We compare the selectdate and the currentdate  and compute the age.
				Resultyear =Period.between(selectedData, currentDate).getYears();
				// Displaying the age at the lblAge.
				lblAgeUpdate.setText(""+Resultyear);
			}
		});
		btnGetAgeUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGetAgeUpdate.setBounds(391, 34, 97, 14);
		contentPane.add(btnGetAgeUpdate);
		
		btnSaveUp = new JButton("SAVE");
		btnSaveUp.setEnabled(false);
		btnSaveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isupdate) {
					
					// Declare an int for the storage of the selectedrow that the users select. 
					int SelectedRow =tblAll.getSelectedRow();
				
					
					
					
					// Here is if the user put the new data at the jtxtfield, it will be saved at the JTable.
					tblAll.setValueAt(txtLnameUpdate.getText(), SelectedRow,1);
					
					tblAll.setValueAt(txtFnameUpdate.getText(), SelectedRow,2);
				
					tblAll.setValueAt(txtMnameUpdate.getText(), SelectedRow,3);
					
					tblAll.setValueAt(lblAgeUpdate.getText(), SelectedRow,4);
					
					tblAll.setValueAt(cboCollegeUpdate.getSelectedItem(), SelectedRow,5);
					
					tblAll.setValueAt(cboCourseUpdate.getSelectedItem(), SelectedRow,6);
					
					
					
					JOptionPane.showMessageDialog(contentPane,"SELECTED INFORMATION UPDATED!!");
				}
			
				
				// Setting the setenabled to false.
				txtFnameUpdate.setEnabled(false);
				txtMnameUpdate.setEnabled(false);
				txtLnameUpdate.setEnabled(false);
				dateChooser.setEnabled(false);
				cboCollegeUpdate.setEnabled(false);
				cboCourseUpdate.setEnabled(false);
				lblIDUpdate.setEnabled(false);
				btnGetAgeUpdate.setEnabled(false);
				lblAgeUpdate.setEnabled(false);
				btnSaveUp.setEnabled(false);
				
				// Setting the setenabled to true.
				btnUpdateUp.setEnabled(true);
			}
			
		});
		btnSaveUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSaveUp.setBounds(530, 92, 128, 28);
		contentPane.add(btnSaveUp);
		
		btnUpdateUp = new JButton("UPDATE ");
		btnUpdateUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// Called the UpdateRow method.
				UpdateRow();
				
				// Setting the setEnabled to true.
				txtFnameUpdate.setEnabled(true);
				txtMnameUpdate.setEnabled(true);
				txtLnameUpdate.setEnabled(true);
				dateChooser.setEnabled(true);
				cboCollegeUpdate.setEnabled(true);
				cboCourseUpdate.setEnabled(true);
				lblIDUpdate.setEnabled(true);
				btnGetAgeUpdate.setEnabled(true);
				lblAgeUpdate.setEnabled(true);
				btnSaveUp.setEnabled(true);
			
				// Setting the setEnabled to false.
				
				btnUpdateUp.setEnabled(false);
				
			}
		});
		btnUpdateUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdateUp.setBounds(530, 53, 128, 28);
		contentPane.add(btnUpdateUp);
		
		lblgg3 = new JLabel("");
		lblgg3.setBounds(-11, 0, 757, 380);
		contentPane.add(lblgg3);
		Image PicScreen4=new ImageIcon(this.getClass().getResource("/gg2.png")).getImage();
		lblgg3.setIcon(new ImageIcon(PicScreen4));
		
	
	}
	
		private void UpdateRow() {
		
		// If the content of the JTable is more than 0, this line of code will be executed.
		if(Main.modelCollege.getRowCount()>0) {
			
			// Set the boolean isupdate to true.
			isupdate = true;
			
			// SetEnabled property of table to truee so the the users wil be able to edit.
			tblAll.setEnabled(true);
		}else {
			// If it is less than 0, this line of code will be executed.
			JOptionPane.showMessageDialog(contentPane,"NO INFORMATION INSIDE TO UPDATE!!");
		}

	}
}
