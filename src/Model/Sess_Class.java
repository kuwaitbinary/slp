package Model;

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
public class Sess_Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_class;
	
	private String name;
	
	private int max_count;
	
	@OneToOne
	//@Column(name = "id_trainer")
	private Trainer trainer;

	@ManyToOne
	//@Column(name = "id_session")
	private Active_Session activeSession;
	
	@OneToMany(mappedBy = "session_class", cascade=CascadeType.ALL)
	private List<Reg_Session> registeredSessions;
	
	public int getId_class() {
		return id_class;
	}

	public void setId_class(int id_class) {
		this.id_class = id_class;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMax_count() {
		return max_count;
	}

	public void setMax_count(int max_count) {
		this.max_count = max_count;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Active_Session getActiveSession() {
		return activeSession;
	}

	public void setActiveSession(Active_Session activeSession) {
		this.activeSession = activeSession;
	}

	public List<Reg_Session> getRegisteredSessions() {
		return registeredSessions;
	}

	public void setRegisteredSessions(List<Reg_Session> registeredSessions) {
		this.registeredSessions = registeredSessions;
	}
		
}