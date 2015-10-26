package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Reg_Session;

public class GetSessionDaoImpl {

	public EntityManager getSessionEntityManager() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}
	
	// getting the list of sessions a single user has
	public List<Reg_Session> getReg_Session(String id_trainee) {
		// TODO Auto-generated method stub
		EntityManager em = this.getSessionEntityManager();
		List<Reg_Session> reg_Session = null;
		Query q = em
				.createQuery("SELECT event FROM Event event where event.status = 'approved' ");
		reg_Session = q.getResultList();

		return reg_Session;
	}
	
	
}
