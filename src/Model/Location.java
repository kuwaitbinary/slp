package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_location;
	
	private String location;
	
	private String gps;
	
	@Column(columnDefinition = "id_zone")
	@ManyToOne
	private Zone zone;
	
	@OneToOne(mappedBy = "location")
	private Active_Session activeSession;
	
	public int getId_location() {
		return id_location;
	}
	
	public void setId_location(int id_location) {
		this.id_location = id_location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getGps() {
		return gps;
	}
	
	public void setGps(String gps) {
		this.gps = gps;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Active_Session getActiveSession() {
		return activeSession;
	}

	public void setActiveSession(Active_Session activeSession) {
		this.activeSession = activeSession;
	}

}