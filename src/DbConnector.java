import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public Patient getPatientByAmka(String amka) {
		Patient p = null;
		openConnection();
		try {		
			ResultSet rs = st.executeQuery("select * from patient where amka='"+amka+"'");			
			while(rs.next()) {
				p = new Patient(rs.getString("amka"), rs.getString("lastname"), rs.getString("firsname"), rs.getString("address"), 
						rs.getString("telephone"), rs.getString("email"), rs.getInt("age"), rs.getString("gender"), 
						rs.getString("bloodtype"), rs.getString("insurance"), rs.getString("info"));
			}
		}
		catch (Exception e) {
			return null;
		}
		finally {
			closeConnection();
		}
		return p;
	}
	
	public void deletePatient(Patient p) {
		openConnection();
		String query = "DELETE FROM patient WHERE amka = ? ";
		java.sql.PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getAmka());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		closeConnection();

	}
	
	public void savePatient(Patient p) {
		openConnection();
		
		String query = "INSERT INTO `patient` (`amka`, `date_created`, `date_updated`, `firstname`, `lastname`, `address`, `telephone`, `email`, `age`, `gender`, `bloodtype`, `insurance`, `info`)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		java.sql.PreparedStatement pstmt = null;

		try {
			
		    java.util.Date today = new java.util.Date();
		    java.sql.Date sqlDate =  new java.sql.Date(today.getTime());
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, p.getAmka());
			pstmt.setDate(2, sqlDate);
			pstmt.setDate(3, sqlDate);
			pstmt.setString(4, p.getFirstname());
			pstmt.setString(5, p.getLastname());
			pstmt.setString(6, p.getAddress());
			pstmt.setString(7, p.getTelephone());
			pstmt.setString(8, p.getEmail());
			pstmt.setInt(9, p.getAge());
			pstmt.setString(10, p.getGender());
			pstmt.setString(11, p.getBloodType());
			pstmt.setString(12, p.getInsurance());
			pstmt.setString(13, p.getInfo());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		closeConnection();
	}
	
	public ArrayList<Doctor> getAllDoctors() {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		openConnection();
		try {		
			ResultSet rs = st.executeQuery("select * from doctor");
			
			while(rs.next()) {
				Doctor d = new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("telephone"), 
										rs.getString("speciality"), rs.getInt("department_id"));
				doctors.add(d);
			}
		}
		catch (Exception e) {
			return null;
		}
		finally {
			closeConnection();
		}
		return doctors;
	}
	
	public Doctor getDoctorByAm(int am) {
		Doctor d = null;
		openConnection();
		try {		
			ResultSet rs = st.executeQuery("select * from doctor where id='"+am+"'");			
			while(rs.next()) {
				d = new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("telephone"), 
						rs.getString("speciality"), rs.getInt("department_id"));
			}
		}
		catch (Exception e) {
			return null;
		}
		finally {
			closeConnection();
		}
		return d;
	}
	
	public void deleteDoctor(Doctor d) {
		openConnection();
		String query = "DELETE FROM doctor WHERE id = ? ";
		java.sql.PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, d.getArMitrwou());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		closeConnection();
	}
	
	public void saveDoctor(Doctor d) {		
		openConnection();
				
		String query = "INSERT INTO `doctor` (`date_created`, `date_updated`, `name`, `surname`, `telephone`, `speciality`, `department_id`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?) ";
		java.sql.PreparedStatement pstmt = null;

		try {
			
		    java.util.Date today = new java.util.Date();
		    java.sql.Date sqlDate =  new java.sql.Date(today.getTime());
			
			pstmt = conn.prepareStatement(query);
			pstmt.setDate(1, sqlDate);
			pstmt.setDate(2, sqlDate);
			pstmt.setString(3, d.getFirstname());
			pstmt.setString(4, d.getLastname());
			pstmt.setString(5, d.getTelephone());
			pstmt.setString(6, d.getSpeciality());
			pstmt.setInt(7, d.getDepartment());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		closeConnection();
	}
}
