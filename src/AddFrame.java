import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.Period;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.Color;

public class AddFrame extends JFrame {

	
	
	// We use public static instead of private because it is so that we can access or use the components and data type in other JFrames.
	public static JPanel contentPane;
	public static JTextField txtFirstName;
	public static JTextField txtMiddleName;
	public static JTextField txtLastName;
	
	// Here we declare a string for the storage of our txtfields.
	public static String lastname;
	public static String firstname;
	public static String middlename;
	public static String course= "";
	public static String colleg="";
	public static boolean isnew= false;

	// Here we declare a integers for the count of student(for student number), it starts at 1.
	public static int id= 1;
	
	// We also declares integer for the datechooser(storage for the month,days and year).
	public static int Resultyear;
	public static int day;
	public static int month;
	public static int year;
	
	
	// Here is we create a string of array that will hold the college.
	// Then we create a defaultcombobox then we put the string array in the defalut comboboxmodels.
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
	public static JLabel lblAge;
	public static JLabel lblCollege;
	public static JComboBox cboCourse;
	public static JComboBox cboCollege;
	public static JLabel lblId;
	public static JDateChooser dateChooser;
	public static JButton btnNew;
	private JLabel lblbackground;
	
	
	
	


	public AddFrame() {
		setTitle("ADD RECORD OF STUDENTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 739, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// This code is simply setting the location of JFrmae to center.
		setLocationRelativeTo(null);
		
		JLabel lblFirstName = new JLabel("FIRST NAME : ");
		lblFirstName.setForeground(Color.MAGENTA);
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFirstName.setBounds(10, 22, 113, 37);
		contentPane.add(lblFirstName);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(145, 22, 175, 37);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME : ");
		lblMiddleName.setForeground(Color.MAGENTA);
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMiddleName.setBounds(10, 81, 125, 37);
		contentPane.add(lblMiddleName);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setColumns(10);
		txtMiddleName.setBounds(145, 81, 175, 37);
		contentPane.add(txtMiddleName);
		
		JLabel lblLastName = new JLabel("LAST NAME : ");
		lblLastName.setForeground(Color.MAGENTA);
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLastName.setBounds(10, 148, 113, 37);
		contentPane.add(lblLastName);
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		txtLastName.setBounds(145, 148, 175, 37);
		contentPane.add(txtLastName);
		
		JLabel lblBirthDate = new JLabel("BIRTH DATE : ");
		lblBirthDate.setForeground(Color.MAGENTA);
		lblBirthDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBirthDate.setBounds(363, 22, 113, 37);
		contentPane.add(lblBirthDate);
		
		dateChooser = new JDateChooser();
		
		// Here we set the date format to days/months/yr, because the default is day and months and year(it only accpt single digits) so we change it. 
		dateChooser.setDateFormatString("dd/MM/yyyy");
		dateChooser.setBounds(474, 23, 85, 14);
		contentPane.add(dateChooser);
		
		lblAge = new JLabel("AGE : ");
		lblAge.setForeground(Color.MAGENTA);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAge.setBounds(363, 67, 113, 37);
		contentPane.add(lblAge);
		
		lblCollege = new JLabel("COLLEGE");
		lblCollege.setForeground(Color.MAGENTA);
		lblCollege.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCollege.setBounds(363, 126, 113, 37);
		contentPane.add(lblCollege);
		
		JLabel lblCourse = new JLabel("COURSE");
		lblCourse.setForeground(Color.MAGENTA);
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCourse.setBounds(363, 185, 113, 37);
		contentPane.add(lblCourse);
		
		cboCollege = new JComboBox<Object>(college);
		String fruit = ((Object) cboCollege).getValueAt(2);
		cboCollege.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			 
				// Here if the user selects and it match in model of cbocollege, the model of cbo course will be change dynamically.
				if(cboCollege.getSelectedItem()=="CEAS") {
					cboCourse.setModel(CEASprog);
				}else if(cboCollege.getSelectedItem()=="CBAA") {
					cboCourse.setModel(CBAAprog);
				}else if(cboCollege.getSelectedItem()=="CCE") {
					cboCourse.setModel(CCEprog);
				}else if(cboCollege.getSelectedItem()=="CON") {
					cboCourse.setModel(CONprog);
				} 
				cboCollege.removeV
				
			}
		});
		cboCollege.setBounds(486, 133, 92, 27);
		contentPane.add(cboCollege);
		cboCollege.getitem
		System.out.println(cboCollege.getItemCount);
		
		cboCourse = new JComboBox<Object>(CEASprog);
		cboCourse.setBounds(486, 192, 92, 27);
		contentPane.add(cboCourse);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			
				// The users select a course it will be storge in the string called "course".
				if(cboCourse.getSelectedItem()=="BSEED") {
					course="BSEED";
					
			}	else if(cboCourse.getSelectedItem()=="BSSED") {
				course="BSSED";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSPSY") {
				course="BSPSY";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSA") {
				course="BSA";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSBA") {
				course="BSBA";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSCS") {
				course="BSCS";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSCPE") {
				course="BSCPE";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSECE") {
				course="BSECE";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSIE") {
				course="BSIE";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSIT") {
				course="BSIT";
				 	
	     	}else if(cboCourse.getSelectedItem()=="BSN") {
				course="BSN";
				 	
	     	}
				
				
				
				if(cboCollege.getSelectedItem()=="CEAS") {
					
					colleg="CEAS";
					
			}
				else if(cboCollege.getSelectedItem()=="CBAA") {
					
					colleg="CBAA";
			}
				else if(cboCollege.getSelectedItem()=="CCE") {
					
					colleg="CCE";
			}
				else if(cboCollege.getSelectedItem()=="CON") {
				
					colleg="CON";
			}
				
			
				// Here the string we declare above is we use it to be a logical storage for the txtfields, we use get text to get the input of the users.
				lastname =txtLastName.getText();
				firstname =txtFirstName.getText();
				middlename = txtMiddleName.getText();
				
			
				// Here we declared a logical storage obgject for the inputs of the users to add in main model. 
				// The object that we used we called it rowdata.
				// We declare the size of the object to 7.
				Object[] rowdata = new Object[7];
				// Because the arrays is always start at 0, we start at 0.
				// Here all the inputs is we put at the object.
				rowdata[0]=lblId.getText();
				rowdata[1]=lastname;
				rowdata[2]=firstname;
				rowdata[3]=middlename;
				rowdata[4]=Resultyear;
				rowdata[5]=colleg;
				rowdata[6]=course;
				
				
				// Here the row data will be put in model in the main frame upon clicking the add button.
				Main.modelCollege.addRow(rowdata);
				Main.modelCollege.adde
				
				// After clickng the button we set the enabled of the button add to false.
				btnAdd.setEnabled(false);
				// And the btnNew we set enable true so that before the users add a new data,he or she need first to click btn new for the student number
				btnNew.setEnabled(true);
		
			}
		});
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setEnabled(false);
		btnAdd.setBounds(145, 252, 113, 27);
		contentPane.add(btnAdd);
		
		btnNew = new JButton("NEW");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewRow();
				btnAdd.setEnabled(true);
				btnNew.setEnabled(false);
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNew.setBounds(21, 252, 113, 27);
		contentPane.add(btnNew);
		
		JButton btnGetAge = new JButton("Get Age");
		btnGetAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				// Here we declare a string for the date chooser, so that the user will be able to type the birthday.
				String dateofbirth =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				// We also declare a string for the split of the day, months and years.
				String Dob[]=dateofbirth.split("/");
				
				// We parse it to intgers so that we can compute the age of the user.
				 day = Integer.parseInt(Dob[0]);
				 month = Integer.parseInt(Dob[1]);
				 year = Integer.parseInt(Dob[2]);
				
			     // We get the date of the user input.
				 LocalDate selectedData = LocalDate.of(year,month,day);
			
				 // Then we get the current date. 
				 LocalDate currentDate = LocalDate.now();
				
			// Then we declare a new int for the storage of the age.
				 // We compare the selectdate and the currentdate  and compute the age.
				 Resultyear =Period.between(selectedData, currentDate).getYears();
				
			// Displaying the age at the lblAge.
				 lblAge.setText("AGE : "+Resultyear);
			}
		});
		btnGetAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGetAge.setBounds(471, 45, 97, 14);
		contentPane.add(btnGetAge);
		
		lblId = new JLabel("ID   :");
		lblId.setForeground(Color.MAGENTA);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(10, 199, 113, 14);
		contentPane.add(lblId);
		
		lblbackground = new JLabel("");
		lblbackground.setBounds(0, 0, 725, 301);
		contentPane.add(lblbackground);
		Image PicScreen8=new ImageIcon(this.getClass().getResource("/logingg.png")).getImage();
		lblbackground.setIcon(new ImageIcon(PicScreen8));
	}
	private void NewRow() {
		
		//Determine the current operation to do.
		
		// If the user click btnNew, the boolean is new will be set to true.
		isnew =true;
	
		// Display the value of integer to "ID".
		lblId.setText(String.valueOf(id));
		// We concatinate it so that it will increess evry the users click the newBtn.
		id++;
		
	}
}
