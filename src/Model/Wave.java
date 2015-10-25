package Model;

public class Wave {
	
	int id_session;
	String id_location;
	int id_course;
	
	
	
	public Wave(int id_session, String id_location, int id_course) {
		super();
		this.id_session = id_session;
		this.id_location = id_location;
		this.id_course = id_course;
	}
	
	public int getId_session() {
		return id_session;
	}
	public void setId_session(int id_session) {
		this.id_session = id_session;
	}
	public String getId_location() {
		return id_location;
	}
	public void setId_location(String id_location) {
		this.id_location = id_location;
	}
	public int getId_course() {
		return id_course;
	}
	public void setId_course(int id_course) {
		this.id_course = id_course;
	}
	
	
	

}
