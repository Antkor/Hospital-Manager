import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import java.awt.ScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.io.Console;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Patient_GUI extends JFrame {

	private JFrame frame;
	private JTextField text_Amka;
	private JTextField text_Sname;
	private JTextField text_Name;
	private JTextField text_Address;
	private JTextField text_Phone;
	private JTextField text_Email;
	private JTextField text_Age;
	private JComboBox combo_sex;
	private JComboBox combo_blood;
	private JTextArea text_Info;
	private Patient p;

	/**
	 * Launch the application.
	 */

		
			public static void run() {
				try {
					Patient_GUI window = new Patient_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the application.
	 */
	public Patient_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 503, 512);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("\u0394\u03B9\u03B1\u03C7\u03B5\u03AF\u03C1\u03B9\u03C3\u03B7 \u03B1\u03C3\u03B8\u03B5\u03BD\u03AE");
		
		JLabel lblNewLabel = new JLabel("\u0391.\u039C.\u039A.\u0391");
		lblNewLabel.setBounds(20, 27, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\u0395\u03C0\u03CE\u03BD\u03C5\u03BC\u03BF");
		label.setBounds(20, 64, 57, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		label_1.setBounds(20, 104, 46, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7");
		label_2.setBounds(20, 139, 73, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		label_3.setBounds(20, 174, 73, 14);
		frame.getContentPane().add(label_3);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 211, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel label_5 = new JLabel("\u0397\u03BB\u03B9\u03BA\u03AF\u03B1");
		label_5.setBounds(20, 245, 46, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u03A6\u03CD\u03BB\u03BF");
		label_6.setBounds(20, 283, 46, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u039F\u03BC\u03AC\u03B4\u03B1 \u0391\u03AF\u03BC\u03B1\u03C4\u03BF\u03C2");
		label_7.setBounds(20, 321, 89, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u03A0\u03BB\u03B7\u03C1\u03BF\u03C6\u03BF\u03C1\u03AF\u03B5\u03C2");
		label_8.setBounds(20, 356, 73, 14);
		frame.getContentPane().add(label_8);
		
		text_Sname = new JTextField();
		text_Sname.setColumns(10);
		text_Sname.setBounds(103, 61, 115, 20);
		frame.getContentPane().add(text_Sname);
		
		text_Name = new JTextField();
		text_Name.setColumns(10);
		text_Name.setBounds(103, 101, 115, 20);
		frame.getContentPane().add(text_Name);
		
		text_Address = new JTextField();
		text_Address.setColumns(10);
		text_Address.setBounds(103, 136, 115, 20);
		frame.getContentPane().add(text_Address);
		
		text_Phone = new JTextField();
		text_Phone.setColumns(10);
		text_Phone.setBounds(103, 171, 115, 20);
		frame.getContentPane().add(text_Phone);
		
		text_Email = new JTextField();
		text_Email.setColumns(10);
		text_Email.setBounds(103, 208, 115, 20);
		frame.getContentPane().add(text_Email);
		
		text_Age = new JTextField();
		text_Age.setColumns(10);
		text_Age.setBounds(103, 242, 115, 20);
		frame.getContentPane().add(text_Age);
		
		combo_sex = new JComboBox();
		combo_sex.setBounds(113, 280, 46, 20);
		frame.getContentPane().add(combo_sex);
		combo_sex.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "�" }));
		
		combo_blood = new JComboBox();
		combo_blood.setBounds(113, 318, 46, 20);
		frame.getContentPane().add(combo_blood);
		combo_blood.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-" }));
		
		JPanel panel = new JPanel();
		panel.setBounds(341, 11, 134, 248);
		frame.getContentPane().add(panel);
		panel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		panel.setLayout(null);
		
		JButton btn_GetData = new JButton("Get Data");
		btn_GetData.setBounds(24, 113, 89, 23);
		panel.add(btn_GetData);
		btn_GetData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getData();
			}
		});
		
		JButton btn_Save = new JButton("Save");
		btn_Save.setBounds(24, 11, 89, 23);
		panel.add(btn_Save);
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveAction();
			}
		});
		
		
		JButton btn_New = new JButton("New");
		btn_New.setBounds(24, 45, 89, 23);
		panel.add(btn_New);
		btn_New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearFields();
			}
		});
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setBounds(24, 79, 89, 23);
		panel.add(btn_Delete);
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletePatient();
			}
		});
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 321, 453);
		frame.getContentPane().add(panel_1);
		panel_1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
		panel_1.setLayout(null);
		
		text_Amka = new JTextField();
		text_Amka.setBounds(92, 11, 115, 20);
		panel_1.add(text_Amka);
		text_Amka.setColumns(10);
		
		text_Info = new JTextArea();
		text_Info.setBounds(92, 347, 219, 95);
		panel_1.add(text_Info);
				           
	}

private void saveAction() {
	
    if (text_Name.getText().equals("")) {
        JOptionPane.showMessageDialog(null,"Please enter name");
        return;
         }
     if (text_Sname.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please enter  lastname");          
        return;
         }
     
      if (text_Amka.equals("")) {
        JOptionPane.showMessageDialog( null, "Please enter A.M.K.A");
        return;
         }
       if (text_Address.getText().equals("")) {
        JOptionPane.showMessageDialog( null, "Please enter Address");
        return;
         }
        if (text_Email.getText().equals("")) {
        JOptionPane.showMessageDialog( null, "Please enter email");
        return;
         }
        if (text_Age.getText().equals("")) {
	           JOptionPane.showMessageDialog( null, "Please enter Age");
	           return;
	            }
        if (text_Info.getText().equals("")) {
	           JOptionPane.showMessageDialog( null, "Please enter Information");
	           return;
	            }
        if (text_Phone.getText().equals("")) {
	           JOptionPane.showMessageDialog( null, "Please enter Phone");
	           return;
	            }	
        String amka= text_Amka.getText();
        String phone = text_Phone.getText();
        int age =  Integer.parseInt(text_Age.getText());
        String sex = String.valueOf(combo_sex.getSelectedItem());
        String blood = String.valueOf(combo_blood.getSelectedItem());
        p = new Patient(amka, text_Sname.getText(), text_Name.getText(), text_Address.getText(), phone, text_Email.getText(), age, sex, blood, "insurance", text_Info.getText());
        p.save(p);
		System.out.println(sex);
		System.out.println(blood);
	}


private void getData() {
	
	p = Patient.search(text_Amka.getText());
    text_Address.setText(p.getAddress());
    text_Age.setText(String.valueOf(p.getAge()));
    text_Email.setText(p.getEmail());
    text_Phone.setText(p.getTelephone());
    text_Info.setText(p.getInfo());
    text_Sname.setText(p.getLastname());
    text_Name.setText(p.getFirstname());
	
}

private void clearFields() {
	
	text_Address.setText("");
    text_Age.setText("");
    text_Email.setText("");
    text_Phone.setText("");
    text_Info.setText("");
    text_Sname.setText("");
    text_Name.setText("");	
}

private void deletePatient() {
	
	p.delete(p);
	text_Address.setText("");
    text_Age.setText("");
    text_Email.setText("");
    text_Phone.setText("");
    text_Info.setText("");
    text_Sname.setText("");
    text_Name.setText("");
	
}

}
