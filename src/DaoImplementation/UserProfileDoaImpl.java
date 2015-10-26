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
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}



	public Trainee retriveUserProfile(int id_trainee) {
		Trainee userProfile = null;

		EntityManager em = this.getMyWayEntityManager();

		Query q = em
				.createQuery("select u from Trainee u where u.id_trainee='"
						+ id_trainee + "'");
		List<Trainee> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;
	}



}
