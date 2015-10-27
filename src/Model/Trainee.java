package Model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainee {

	@Id
	private int id_Trainee;
	private int id_School;
	private String password;
	private String email;
	private String mobile;
	private String firstname;
	private String lastname;
	private String grade;
	private String subject;
	
	@OneToMany(mappedBy = "trainee", cascade = CascadeType.ALL)
	private ArrayList<Reg_Session> regSession;

	public int getId_Trainee() {
		return id_Trainee;
	}

	public void setId_Trainee(int id_Trainee) {
		this.id_Trainee = id_Trainee;
	}

	public int getId_School() {
		return id_School;
	}

	public void setId_School(int id_School) {
		this.id_School = id_School;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public ArrayList<Reg_Session> getRegSession() {
		return regSession;
	}

	public void setRegSession(ArrayList<Reg_Session> regSession) {
		this.regSession = regSession;
	}
		
}