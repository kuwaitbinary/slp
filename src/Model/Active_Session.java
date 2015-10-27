package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Active_Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_session;
	
//	@OneToOne
//	@Column(columnDefinition = "id_location")
//	private Location location;
//	
//	@ManyToOne
//	@Column(columnDefinition = "id_wave")
//	private Wave wave;
//	
//	@OneToMany (mappedBy = "activeSession", cascade=CascadeType.ALL)
//	private ArrayList<Sess_Class> sessionClasses;

	public int getId_session() {
		return id_session;
	}

	public void setId_session(int id_session) {
		this.id_session = id_session;
	}

//	public Location getLocation() {
//		return location;
//	}
//
//	public void setLocation(Location location) {
//		this.location = location;
//	}
//
//	public Wave getWave() {
//		return wave;
//	}
//
//	public void setWave(Wave wave) {
//		this.wave = wave;
//	}
//
//	public ArrayList<Sess_Class> getSessionClasses() {
//		return sessionClasses;
//	}
//
//	public void setSessionClasses(ArrayList<Sess_Class> sessionClasses) {
//		this.sessionClasses = sessionClasses;
//	}

}
