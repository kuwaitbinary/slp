package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Trainee;

public class UserProfileDoaImpl {
	
	public EntityManager getUserProfileEntityManager() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tremble_persistence_unit");
		return emf.createEntityManager();
	}



	public Trainee retriveUserProfile(int id_trainee) {
		Trainee userProfile = null;

		EntityManager em = this.getUserProfileEntityManager();
		
		try {
			Query q = em
					.createQuery("select u from Trainee u where u.id_trainee="
							+ id_trainee);
			userProfile = (Trainee)q.getSingleResult();
			
			return userProfile;
			
		} catch (NoResultException e){
			return null;
		}
		

	}



}