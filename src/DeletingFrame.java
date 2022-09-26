import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class DeletingFrame extends JFrame {

	private JPanel contentPane;
	public static  JTable tblAllDeleting;
	public static JButton btnDeleteDelete;
	
	// Here we set the boolean "isdelete" to false.
	public static  boolean isdelete =false;

	public DeletingFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// This line of code is simply setting the location of JFrame to center.
		setLocationRelativeTo(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 691, 223);
		contentPane.add(scrollPane);
		// Here our table has no defaultmodel because in the main frame we already declared the model for the JTable here in DeletingFrame.
		tblAllDeleting = new JTable();
		// Here we set the enable to false so that the user will be unable to edit the table if he or she is not clickng the delte button.
		tblAllDeleting.setEnabled(false);
		tblAllDeleting.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				// Here if the boolean delete is equals to true this line of code will be executed.
				if(isdelete ==true) {
					// Here we set a integer to be the storage of our seklected row to delete.
					int selectedrows =tblAllDeleting.getSelectedRow();
			}
			}
		});
		
		// Here we set our JTable inside of the JScrollpane at the viewport
		scrollPane.setViewportView(tblAllDeleting);
		
		btnDeleteDelete = new JButton("DELETE");
		btnDeleteDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Here we called a method deleterow to delete a certain row selected by the user.
				DeleteRow();
			}
		});
		btnDeleteDelete.setBounds(20, 243, 108, 29);
		contentPane.add(btnDeleteDelete);
		
		JButton btnSaveDelete = new JButton("SAVE");
		btnSaveDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Here if the boolean is delete is true, the if statment will do.
				if(isdelete) {
					
					// We declare a integers here to hold the answer of the user in the question in the showconfirmdialog.
					int resultdelete=JOptionPane.showConfirmDialog(contentPane," ARE YOU SURE YOU WANT TO DELETE THIS?");
					
			
					// Here if the result is equal to yes.
					if(resultdelete==JOptionPane.YES_OPTION) {
						
						// The selected row that the users select will be delete.
						Main.modelCollege.removeRow(tblAllDeleting.getSelectedRow());	
						// After deleting the selected row is the table will be set  to unabled( enable = false).
						tblAllDeleting.setEnabled(false);
				
						
					}else if((resultdelete==JOptionPane.NO_OPTION)) {
						// If the user selects nothing will happen and the table will be disable.
						tblAllDeleting.setEnabled(false);
					}
					
					
				}
			}
		});
		btnSaveDelete.setBounds(184, 243, 108, 29);
		contentPane.add(btnSaveDelete);
		
		JLabel lblgg4 = new JLabel("");
		lblgg4.setBounds(0, 0, 711, 388);
		contentPane.add(lblgg4);
		Image PicScreen5=new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		lblgg4.setIcon(new ImageIcon(PicScreen5));
	}
	private void DeleteRow() {
	
		// If you click the Delete button this method will executed and  will do an if statment to check the the table has a content.
		// If the rows are more than 1, delete button will be enable.
		if(tblAllDeleting.getRowCount()>0) {
			// Here if the if stament is satisfied, the boolean is delete will be true and,the table is will be anable to edit.
			isdelete=true;
			// The table will unable to be edited.
			tblAllDeleting.setEnabled(true);
		}else {
			// Here if the table have no content, a JOptionpane will appear.
			JOptionPane.showMessageDialog(contentPane,"CANNOT DELETE, NO INFORMATION INSIDE!!");
		}
	}
}
