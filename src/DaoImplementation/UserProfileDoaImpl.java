package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Model.Trainee;

public class UserProfileDoaImpl {
	
	public EntityManager getMyWayEntityManager() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tremble_persistence_unit");
		return emf.createEntityManager();
	}



	public Trainee retriveUserProfile(int id_trainee) {
		Trainee userProfile = null;

		EntityManager em = this.getMyWayEntityManager();

		Query q = em
				.createQuery("select u from Trainee u where u.id_trainee="
						+ id_trainee);
		
		Object result = q.getSingleResult();
		
		if (result != null){
		userProfile = (Trainee) result;
		}else {
			return null;
		}

		return userProfile;
	}



}