package Model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Wave_Date {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_wave_date;
	
//	@ManyToOne
//	private Wave wave;
	
	@Temporal(TemporalType.DATE)
	private Date date;

//	public Wave_Date(int id_wave_date, Wave wave, Date date) {
//		super();
//		this.id_wave_date = id_wave_date;
//		this.wave = wave;
//		this.date = date;
//	}

	public int getId_wave_date() {
		return id_wave_date;
	}

	public void setId_wave_date(int id_wave_date) {
		this.id_wave_date = id_wave_date;
	}

//	public Wave getWave() {
//		return wave;
//	}
//
//	public void setWave(Wave wave) {
//		this.wave = wave;
//	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
		
}