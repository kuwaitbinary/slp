package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reg_Session {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id_reg_session;

	@ManyToOne
	public Active_Session session_class;

	@ManyToOne
	public Trainee trainee;

	public int getId_reg_session() {
		return id_reg_session;
	}

	public void setId_reg_session(int id_reg_session) {
		this.id_reg_session = id_reg_session;
	}

	
	public Active_Session getSession_class() {
		return session_class;
	}

	public void setSession_class(Active_Session session_class) {
		this.session_class = session_class;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

	

}
