import java.util.ArrayList;

public class PatientList {
	
	static ArrayList<Patient> patients = new ArrayList<Patient>();
	
	public static ArrayList<Patient> getPatients() {
		DbConnector connector = new DbConnector();
		patients = connector.getAllPatients();
		return patients;	}

}
