package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reg_Session {

@Id
public int id_reg_session;

@ManyToOne
public String id_class;

@ManyToOne
public String id_trainee;



public int getId_reg_session() {
	return id_reg_session;
}
public void setId_reg_session(int id_reg_session) {
	this.id_reg_session = id_reg_session;
}


public String getId_class() {
	return id_class;
}
public void setId_class(String id_class) {
	this.id_class = id_class;
}


public String getId_trainee() {
	return id_trainee;
}
public void setId_trainee(String id_trainee) {
	this.id_trainee = id_trainee;
}
	
	
	
	
}
