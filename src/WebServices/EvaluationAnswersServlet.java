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
		//get answers array from request
		String[] req_answers = request.getParameterValues("answers[]");
		List<Answer> answers = new ArrayList<Answer>();
		
		System.out.println("answers array: "+req_answers.length);
		int i=0;
		for (i = 0; i<req_answers.length; i++){
			Answer a = new Answer();
			Question question = ed.getSingleQuestion(i+1);
			a.setId_qst(question);
			a.setId_class(sessionClass);
			a.setId_trainee(trainee);
			a.setAnswer(Integer.parseInt(req_answers[i]));
			answers.add(a);
		}
		
		ed.setAnswers(answers);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		json.put("result_data", "length: "+req_answers.length+" i = "+i);

		response.getWriter().print(json);
		
	}

}
