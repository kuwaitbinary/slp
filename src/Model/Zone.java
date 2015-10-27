package Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Zone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_zone;
	
	private String zone;
	
	@OneToMany(mappedBy = "zone", cascade = CascadeType.ALL)
	List<Location> locations;
	
	public int getId_zone() {
		return id_zone;
	}
	
	public void setId_zone(int id_zone) {
		this.id_zone = id_zone;
	}
	
	public String getZone() {
		return zone;
	}
	
	public void setZone(String zone) {
		this.zone = zone;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	
}