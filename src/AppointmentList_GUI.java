import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppointmentList_GUI {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	


	/**
	 * Launch the application.
	 */

			public static void run() {
				try {
					AppointmentList_GUI window = new AppointmentList_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public AppointmentList_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Λίστα ραντεβού");
		frame.setBounds(100, 100, 832, 473);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String col[] = {"Ημέρα","Ώρα", "ΑΜΚΑ", "Επώνυμο Ασθενή", "ΑΜ Ιατρού","Επώνυμο Ιατρού", "Πληροφορίες"};

		tableModel = new DefaultTableModel(col, 0);
		
		JButton btnNewButton = new JButton("Προβολή όλων");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadTable();
			}
		});
		btnNewButton.setBounds(10, 11, 179, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 796, 378);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
	}
	
	private void loadTable() {
		ArrayList<Appointment> Apps = new ArrayList<Appointment>();
		Apps = AppointmentList.getAppointments();
		for (int i = 0; i < Apps.size(); i++){
			String date = Apps.get(i).getDay().toString();
			String time = Apps.get(i).getTime();
			String amka = Apps.get(i).getAmkaPatient();
			String lnameP = AppointmentList.getNamebyAmka(amka);
			String am = String.valueOf(Apps.get(i).getArMitrwoyDoctor());
			String lnameD = AppointmentList.getNameByAm(Integer.parseInt(am));
			String info = Apps.get(i).getInfo();
			
					
			Object[] data = {date, time, amka, lnameP, am, lnameD, info};
			
			tableModel.addRow(data);
					
		}

}
}
