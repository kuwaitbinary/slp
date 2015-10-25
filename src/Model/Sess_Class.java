package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sess_Class {

	@Id
	private int id_class;
	
	private String name;
	
	private int max_count;
	
	private Trainer trainer;
	
	private Active_Session active_session;

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

	public Active_Session getActive_session() {
		return active_session;
	}

	public void setActive_session(Active_Session active_session) {
		this.active_session = active_session;
	}
	
	
	
}
