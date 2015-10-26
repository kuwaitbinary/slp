package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Wave {
	
	int id_wave;
	String wave;
	
	@ManyToOne
	@Column(columnDefinition = "id_course")
	private Course course;
	
	@OneToMany
	List<Wave_Date> waveDate = new ArrayList<Wave_Date>();
	
	@OneToMany(mappedBy="wave",cascade=CascadeType.ALL)
	List<Active_Session> sessions = new ArrayList<Active_Session>();
	
	public Wave() {
		
	}

	public int getId_wave() {
		return id_wave;
	}

	public void setId_wave(int id_wave) {
		this.id_wave = id_wave;
	}

	public String getWave() {
		return wave;
	}

	public void setWave(String wave) {
		this.wave = wave;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
