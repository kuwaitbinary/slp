package Model;

import java.util.Date;

public class Wave_Date {

	int id_wave_date;
	String wave;
	Date date;
	
	public Wave_Date() {
		
	}
	
	public Wave_Date(int id_wave_date, String wave, Date date) {
		super();
		this.id_wave_date = id_wave_date;
		this.wave = wave;
		this.date = date;
	}


	public int getId_wave_date() {
		return id_wave_date;
	}


	public void setId_wave_date(int id_wave_date) {
		this.id_wave_date = id_wave_date;
	}


	public String getWave() {
		return wave;
	}


	public void setWave(String wave) {
		this.wave = wave;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	
}
