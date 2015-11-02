package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ans;
	
	private int answer;
	
	@OneToOne
	private Question id_qst;
	
	private int id_session;
	
	@OneToOne
	private Sess_Class id_class;
	
	@ManyToOne
	private Trainee id_trainee;
	
	
	public int getId_ans() {
		return id_ans;
	}
	public void setId_ans(int id_ans) {
		this.id_ans = id_ans;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public int getId_secssion() {
		return id_session;
	}
	public void setId_secssion(int id_secssion) {
		this.id_session = id_secssion;
	}
	
	public Sess_Class getId_class() {
		return id_class;
	}
	public void setId_class(Sess_Class id_class) {
		this.id_class = id_class;
	}
	public Question getId_qst() {
		return id_qst;
	}
	public void setId_qst(Question id_qst) {
		this.id_qst = id_qst;
	}
	public int getId_session() {
		return id_session;
	}
	public void setId_session(int id_session) {
		this.id_session = id_session;
	}
	public Trainee getId_trainee() {
		return id_trainee;
	}
	public void setId_trainee(Trainee id_trainee) {
		this.id_trainee = id_trainee;
	}
	
}
