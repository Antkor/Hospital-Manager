
public class Patient {

	private String amka;
	private String lastname;
	private String firstname;
	private String address;
	private String telephone;
	private String email;
	private int age;
	private String gender;
	private String bloodType;
	private String insurance;
	private String info;
	private DbConnector connector;
	
	public Patient(String amka, String lastname, String firstname, String address,
			String telephone, String email, int age, String gender,
			String bloodType, String insurance, String info) {
		
		this.amka = amka;
		this.lastname = lastname;
		this.firstname = firstname;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;
		this.info = info;
		
	}
	public String getAmka() {
		return amka;
	}
	public void setAmka(String amka) {
		this.amka = amka;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getInsurance() {
		return bloodType;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getBloodType() {
		return bloodType;
	}
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
