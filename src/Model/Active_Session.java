package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Active_Session {
	
	@Id
	private int id_session;
	
	private Location location;
	
	private Wave wave;

	public int getId_session() {
		return id_session;
	}

	public void setId_session(int id_session) {
		this.id_session = id_session;
	}

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
