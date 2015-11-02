package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_qst;
	
	private int section;
	private String qst;
	
	@OneToOne
	private Answer answers;

	public int getId_qst() {
		return id_qst;
	}

	public void setId_qst(int id_qst) {
		this.id_qst = id_qst;
	}

	public int getSection() {
		return section;
	}

	public void setSection(int section) {
		this.section = section;
	}

	public String getQst() {
		return qst;
	}

	public void setQst(String qst) {
		this.qst = qst;
	}

	public Answer getAnswers() {
		return answers;
	}

	public void setAnswers(Answer answers) {
		this.answers = answers;
	}
	

}
