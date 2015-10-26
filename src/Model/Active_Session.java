package Model;

import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToOne
	private Location location;
	
	@ManyToOne
	private Wave wave;
	
	@OneToMany (mappedBy = "activeSession", cascade=CascadeType.ALL)
	private List<Sess_Class> sessionClasses;
	

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Wave getWave() {
		return wave;
	}

	public void setWave(Wave wave) {
		this.wave = wave;
	}
	
	

}
