import java.util.ArrayList;

public class DoctorList {

	private static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	
	public static ArrayList<Doctor> getDoctors() {
		DbConnector connector = new DbConnector();
		doctors = connector.getAllDoctors();
		return doctors;
	}
}
