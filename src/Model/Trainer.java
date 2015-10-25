package Model;

public class Trainer {

	private int id_Trainer;
	private String name;
	private String password;
	private String firstname;
	private String lastname;
	
	
	public int getId_Trainer() {
		return id_Trainer;
	}
	
	public void setId_Trainer(int id_Trainer) {
		this.id_Trainer = id_Trainer;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
}
