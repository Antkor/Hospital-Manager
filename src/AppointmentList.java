import java.util.ArrayList;

public class AppointmentList {

	public static ArrayList<Appointment> getAppointments() {
		DbConnector connector = new DbConnector();
		return connector.getAllAppointments();
	}
	public static String getNamebyAmka(String amka) {
		for(Patient patient: PatientList.patients) {
			if(patient.getAmka() == amka) {
				return patient.getFirstname();
			}
		}
		return null;
	}
	public static String getNameByAm(int am) {
		for(Doctor doctor: DoctorList.doctors) {
			if(doctor.getArMitrwou() == am) {
				return doctor.getFirstname();
			}
		}
		return null;
	}
}
