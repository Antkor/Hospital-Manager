import java.util.Date;

public class Appointment {

	private Date day;
	private String time;
	private String amkaPatient;
	private int arMitrwoyDoctor;
	private String info;
	private DbConnector connector;

	public Appointment(Date day, String time, String amkaPatient, int arMitrwoyDoctor, String info) {
		this.day = day;
		this.time = time;
		this.amkaPatient = amkaPatient;
		this.arMitrwoyDoctor = arMitrwoyDoctor;
		this.info = info;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getAmkaPatient() {
		return amkaPatient;
	}
	public void setAmkaPatient(String amkaPatient) {
		this.amkaPatient = amkaPatient;
	}
	public int getArMitrwoyDoctor() {
		return arMitrwoyDoctor;
	}
	public void setArMitrwoyDoctor(int arMitrwoyDoctor) {
		this.arMitrwoyDoctor = arMitrwoyDoctor;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
