package WebServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.EditProfileDaoImpl;
import DaoImplementation.EvaluationDaoImpl;
import Model.Active_Session;
import Model.Answer;
import Model.Question;
import Model.Sess_Class;
import Model.Trainee;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class EvaluationAnswersServlet
 */
@WebServlet("/EvaluationAnswers")
public class EvaluationAnswersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvaluationAnswersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setAnswers(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		setAnswers(request,response);
	}
	
	
	void setAnswers(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		EvaluationDaoImpl ed = new EvaluationDaoImpl();
		EditProfileDaoImpl ep = new EditProfileDaoImpl();
		
		//Retrieve the trainee info
		int id_trainee = Integer.parseInt((String)request.getParameter("id_trainee"));
		Trainee trainee = ep.getTrainee(id_trainee);
		
		//retrieve the sess_class
		int id_class = Integer.parseInt((String)request.getParameter("id_class"));
		Sess_Class sessionClass = ed.getSessionClass(id_class);
		
		//retrieve the active session
		int id_session = Integer.parseInt((String)request.getParameter("id_session"));
		Active_Session active_Session = ed.getActiveSession(id_session);
		
		//get answers array from request
		String[] req_answers = request.getParameterValues("answers[]");
		List<Answer> answers = new ArrayList<Answer>();
		
		System.out.println("answers array: "+req_answers.length);
		
		//loop on the answers from the request and set them in a list array to be sent to set in the DB
		for (int i = 0; i<req_answers.length; i++){
			Answer a = new Answer();
			Question question = ed.getSingleQuestion(i+1);
			a.setId_qst(question);
			a.setId_class(sessionClass);
			a.setId_trainee(trainee);
			a.setId_session(id_session);
			a.setAnswer(Integer.parseInt(req_answers[i]));
			answers.add(a);
		}
		
		ed.setAnswersInDB(answers);
		
		//the response with the success message
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		json.put("result_data", "");

		response.getWriter().print(json);
		
	}

}
