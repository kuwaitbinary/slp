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
		Query q = em.createQuery("SELECT rs FROM Reg_Session rs where rs.id_reg_session = " + id_trainee);
		reg_Session = q.getResultList();

		return reg_Session;
	}
	
//	public Sess_Class getSess_Class(String id_class)
//	{
//		Sess_Class sess = new Sess_Class();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		sess = (Sess_Class) q.getSingleResult();
//			
//		return sess;
//	}
	
//	public Trainer getTrainer(int id_trainer)
//	{
//		Trainer trainer = new Trainer();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		trainer = (Trainer) q.getSingleResult();
//			
//		return trainer;
//	}
	
//	public Active_Session getActive_Session(String id_session)
//	{
//		Active_Session session = new Active_Session();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		session = (Active_Session) q.getSingleResult();
//			
//		return session;
//	}
	
//	public Location getLocation(String id_Location)
//	{
//		Location location = new Location();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		location = (Location) q.getSingleResult();
//			
//		return location;
//	}
	
//	public Zone getZone(int id_Zone)
//	{
//		Zone zone = new Zone();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		zone = (Zone) q.getSingleResult();
//			
//		return zone;
//	}
	
//	public Wave getWave(String id_Wave)
//	{
//		Wave wave = new Wave();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		wave = (Wave) q.getSingleResult();
//			
//		return wave;
//	}
	
//	public Course getCourse(int id_Course)
//	{
//		Course course = new Course();
//		EntityManager em = this.getSessionEntityManager();
//		
//		Query q = em.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
//		course = (Course) q.getSingleResult();
//			
//		return course;
//	}
	
	public Wave_Date getWaveDate(int id_Wave)
	{
		Wave_Date waveDate = new Wave_Date();
		EntityManager em = this.getSessionEntityManager();
		
		Query q = em.createQuery("SELECT wd FROM Wave_Date wd where wd.id_wave_date = " + id_Wave);
		waveDate = (Wave_Date) q.getSingleResult();
			
		return waveDate;
	}
	
}
