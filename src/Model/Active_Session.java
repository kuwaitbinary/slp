package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Active_Session {
	
	@Id
	private int id_session;
	
	private Location location;
	
	private Wave wave;
	
	

}
