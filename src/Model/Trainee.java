package Model;

public class Trainee {

	private int id_Trainee;
	private int id_School;
	private String password;
	private String email;
	private String mobile;
	private String firstname;
	private String lastname;
	private String grade;
	private String subject;
	
	
	
	public int getId_Trainee() {
		return id_Trainee;
	}
	
	public void setId_Trainee(int id_Trainee) {
		this.id_Trainee = id_Trainee;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId_School() {
		return id_School;
	}
	
	public void setId_School(int id_School) {
		this.id_School = id_School;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
}
