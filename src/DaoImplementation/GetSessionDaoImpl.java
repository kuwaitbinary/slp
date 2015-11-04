package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Active_Session;
import Model.Course;
import Model.Location;
import Model.Reg_Session;
import Model.Sess_Class;
import Model.Trainer;
import Model.Wave;
import Model.Wave_Date;
import Model.Zone;

public class GetSessionDaoImpl {

	public EntityManager getSessionEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tremble_persistence_unit");
		return emf.createEntityManager();
	}
	
	// getting the list of sessions a single user has
	public List<Reg_Session> getReg_Session(String id_trainee) {
		// TODO Auto-generated method stub
		EntityManager em = this.getSessionEntityManager();
		List<Reg_Session> reg_Session = null;
		Query q = em.createQuery("SELECT rs FROM Reg_Session rs where rs.trainee = " + id_trainee);
		reg_Session = q.getResultList();

		return reg_Session;
	}
	
	public List<Wave_Date> getWaveDates(int id_Wave)
	{
		List<Wave_Date> waveDates;
		EntityManager em = this.getSessionEntityManager();
		
		Query q = em.createQuery("SELECT wd FROM Wave_Date wd where wd.wave = " + id_Wave);
		waveDates = q.getResultList();
			
		return waveDates;
	}
	
}
