import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class DoctorList_GUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					DoctorList_GUI window = new DoctorList_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public DoctorList_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u039B\u03AF\u03C3\u03C4\u03B1 \u0399\u03B1\u03C4\u03C1\u03CE\u03BD");
		frame.setBounds(100, 100, 894, 435);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String col[] = {"Αριθμός μητρώου","Επώνυμο","Όνομα","Τηλέφωνο","Ειδικότητα","Τμήμα"};

		tableModel = new DefaultTableModel(col, 0);
		
		JButton btnNewButton = new JButton("Προβολή ιατρών");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadTable();
			}
		});
		btnNewButton.setBounds(10, 11, 146, 23);
		frame.getContentPane().add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 858, 340);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
	}
	
	private void loadTable() {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		doctors = DoctorList.getDoctors();
		for (int i = 0; i < doctors.size(); i++){
			String arMitr = String.valueOf(doctors.get(i).getArMitrwou());
			String ln = doctors.get(i).getLastname();
			String fn = doctors.get(i).getFirstname();
			String ph = doctors.get(i).getTelephone();
			String sp = doctors.get(i).getSpeciality();
			String dep = String.valueOf(doctors.get(i).getDepartment());
			
			Object[] data = {arMitr, ln, fn, ph, sp, dep};
			
			tableModel.addRow(data);
					
		}
	}
}
