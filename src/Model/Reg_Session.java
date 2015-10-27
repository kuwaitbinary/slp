package Model;

import javax.persistence.Column;
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
	//@Column(name = "id_class")
	public Sess_Class session_class;

	@ManyToOne
	//@Column(name = "id_trainee")
	public Trainee trainee;

	public int getId_reg_session() {
		return id_reg_session;
	}

	public void setId_reg_session(int id_reg_session) {
		this.id_reg_session = id_reg_session;
	}

	public Sess_Class getSession_class() {
		return session_class;
	}

	public void setSession_class(Sess_Class session_class) {
		this.session_class = session_class;
	}

	public Trainee getTrainee() {
		return trainee;
	}

	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}

}