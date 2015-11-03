package DaoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Model.Answer;
import Model.Question;
import Model.Sess_Class;

public class EvaluationDaoImpl {
	
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
		
		public Question getSingleQuestion(int q_id){
			EntityManager em = this.getEvaluationEntityManager();
			Question question;
			Query q = em.createQuery("select q from Question q where q.id_qst="+q_id);
			question = (Question)q.getSingleResult();
			return question;
		}
		
		public Sess_Class getSessionClass(int c_id){
			EntityManager em = this.getEvaluationEntityManager();
			Sess_Class sc;
			Query q = em.createQuery("select c from Sess_Class c where c.id_class="+c_id);
			sc = (Sess_Class)q.getSingleResult();
			return sc;
		}


}
