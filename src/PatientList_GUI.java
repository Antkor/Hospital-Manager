import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PatientList_GUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					PatientList_GUI window = new PatientList_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the application.
	 */
	public PatientList_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 871, 447);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String col[] = {"AMKA","Επώνυμο","Όνομα", "Διεύθυνση", "Τηλέφωνο", "Εmail", "Ηλικία", "Φύλο", "Ομάδα Αίματος", "Info"};

		tableModel = new DefaultTableModel(col, 0);
		
		JButton btnNewButton = new JButton("Προβολή ασθενών");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadTable();
			}
		});
		btnNewButton.setBounds(10, 11, 185, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 48, 835, 349);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		
	}
		private void loadTable() {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		patients = PatientList.getPatients();
		System.out.println(patients);
		for (int i = 0; i < patients.size(); i++){
			String amka = patients.get(i).getAmka();
			String ln = patients.get(i).getLastname();
			String fn = patients.get(i).getFirstname();
			String address = patients.get(i).getAddress();
			String ph = patients.get(i).getTelephone();
			String Email = patients.get(i).getEmail();
			int age = patients.get(i).getAge();
			String sex = patients.get(i).getGender();
			String blood = patients.get(i).getBloodType();
			String info = patients.get(i).getInfo();
			
			Object[] data = {amka, ln, fn, address, ph, Email, 
                    age, sex, blood, info};
			
			tableModel.addRow(data);
					
		}
		
	}
}
