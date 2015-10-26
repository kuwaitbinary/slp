package Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Wave_Date {

	
	int id_wave_date;
	@ManyToOne
	int id_Wave;
	Date date;
	
	public Wave_Date() {
		
	}
	
	public Wave_Date(int id_wave_date, int wave, Date date) {
		super();
		this.id_wave_date = id_wave_date;
		this.id_Wave = wave;
		this.date = date;
	}


	public int getId_wave_date() {
		return id_wave_date;
	}


	public void setId_wave_date(int id_wave_date) {
		this.id_wave_date = id_wave_date;
	}


	public int getWave() {
		return id_Wave;
	}


	public void setWave(int idWave) {
		this.id_Wave = idWave;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}
