package WebServices;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import DaoImplementation.EvaluationDao;
import Model.Question;

/**
 * Servlet implementation class GetQuestionsServlet
 */
@WebServlet("/GetQuestions")
public class GetQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getQuestions(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getQuestions(request, response);
	}
	
	//method retrieves the questions from DB and returns them in response as a String in json structure
	void getQuestions(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		EvaluationDao evaluationDao = new EvaluationDao();
		List<Question> questions = evaluationDao.getQuestions();
		
		int[] sections = {0,0,0,0};
		
		//to count number of questions per section
		for (int i= 0; i<questions.size(); i++){
			Question q = questions.get(i);
			
			int sectionNo = q.getSection();
			switch (sectionNo){
			case 1:
				sections[0]+=1;
				break;
			case 2:
				sections[1]+=1;
				break;
			case 3:
				sections[2]+=1;
				break;
			case 4:
				sections[3]+=1;
				break;
			}
		}
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		json.put("sections", sections.toString());
		
		//turn list of questions to json array
		JSONArray result_data = new JSONArray();
		for (int i = 0; i < questions.size(); i++) {

			JSONObject jsonReport = new JSONObject();			
			Question q = questions.get(i);
			
			jsonReport.put("question_id", q.getId_qst());
			jsonReport.put("section", q.getSection());
			jsonReport.put("question", q.getQst());

			result_data.add(jsonReport);
		}

		json.put("result_data", result_data);

		response.getWriter().print(json);
		
	}

}
