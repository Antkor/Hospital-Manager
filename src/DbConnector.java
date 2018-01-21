import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

public class DbConnector {
	
	private Connection conn;
	private Statement st;
	ResultSet rs;
	
	private void openConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");			
			st = conn.createStatement();
		}
		catch (Exception e) {
			
		}
	}
	
	private void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			
			if (st != null) {
				st.close();
			}
			
			if (conn != null) {
				conn.close();
			}
		}
		catch (Exception e) {
			
		}
	}
	
	public ArrayList<Patient> getAllPatients() {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		openConnection();
		try {		
			
			ResultSet rs = st.executeQuery("select * from patient");
			
			while(rs.next()) {				
				
				System.out.println(rs.getString("firstname"));				
				Patient p = new Patient(rs.getString("amka"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("address"), 
										rs.getString("telephone"), rs.getString("email"), rs.getInt("age"), rs.getString("gender"), 
										rs.getString("bloodtype"), rs.getString("insurance"), rs.getString("info"));
				
				patients.add(p);

			}
		}
		catch (Exception e) {
			return null;
		}
		finally {
			closeConnection();
		}
		return patients;
	}
}
