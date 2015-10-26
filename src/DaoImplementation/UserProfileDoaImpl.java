package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Model.Trainee;

public class UserProfileDoaImpl implements UserProfileDoa {
	
	public EntityManager getMyWayEntityManager() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("myway");
		return emf.createEntityManager();
	}

	@Override
	public Trainee login(String userName, String passWord) {
		Trainee userProfile = null;

		EntityManager em = this.getMyWayEntityManager();

		Query q = em
				.createQuery("select u from Trainee u where u.userName='"
						+ userName + "'and u.passWord = '" + passWord + "'");

		List<Trainee> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;

	}

	@Override
	public Trainee checkUserName(String userName) {
		EntityManager em = this.getMyWayEntityManager();

		Trainee userProfile = null;

		Query q = em
				.createQuery("select u from Trainee u where u.userName='"
						+ userName + "'");

		List<Trainee> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;
	}

	@Override
	public void register(Trainee userProfile) {
		EntityManager em = this.getMyWayEntityManager();
		em.getTransaction().begin();
		em.persist(userProfile);
		em.getTransaction().commit();
	}

	@Override
	public Trainee retriveUserProfile(String userName) {
		Trainee userProfile = null;

		EntityManager em = this.getMyWayEntityManager();

		Query q = em
				.createQuery("select u from Trainee u where u.userName='"
						+ userName + "'");
		List<Trainee> us = q.getResultList();

		if (us.size() != 0) {
			userProfile = us.get(0);
		}

		return userProfile;
	}

	@Override
	public void updateUserProfile(String username, String password,
			String email, String picture) {
		EntityManager em = this.getMyWayEntityManager();

		Query query = em.createQuery("update Trainee u set u.passWord ='"
				+ password + "' where u.userName='" + username + "'");

		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
		query = em.createQuery("update Trainee u set u.email ='" + email
				+ "' where u.userName='" + username + "'");

		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();

		query = em.createQuery("update Trainee u set u.profilePicture ='"
				+ picture + "' where u.userName='" + username + "'");

		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();

	}

}
