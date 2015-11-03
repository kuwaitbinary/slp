package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Answer;
import Model.Question;

public class EvaluationDao {
	
	//method to get the entity manager 
		public EntityManager getEvaluationEntityManager() {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("tremble_persistence_unit");
			return emf.createEntityManager();
		}
		
		//returns all questions from the DB 
		public List<Question> getQuestions(){
			EntityManager em = this.getEvaluationEntityManager();
			List<Question> questions = null;
			
			Query q = em.createQuery("select q from Question q");
			questions = q.getResultList();
			
			return questions;
		}
		
		//set the list of answers submitted by the user
		public void setAnswers(List<Answer> answers){
			EntityManager em = this.getEvaluationEntityManager();

			em.getTransaction().begin();
			em.persist(answers);
			em.getTransaction().commit();
		}

}
