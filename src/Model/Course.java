package Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_course;
	
	private String name;
	
	private String syllabus;
	
	private int duration;
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	List<Wave> waves;

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getSyllabus() {
		return syllabus;
	}
	
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getI() {
		return id_course;
	}
	
	public void setI(int i) {
		this.id_course = i;
	}

	public List<Wave> getWaves() {
		return waves;
	}

	public void setWaves(List<Wave> waves) {
		this.waves = waves;
	}

}