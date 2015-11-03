package WebServices;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Answer;

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
	
		int id_trainee = Integer.parseInt((String)request.getParameter("id_trainee"));
		int id_class = Integer.parseInt((String)request.getParameter("id_class"));
//		String answers = (String)request.getParameter("answers");
		
		JSONObject jsnobject = JSONObject.parse(request.toString());
		List<Answer> answers = new ArrayList<Answer>();
		
		JSONArray ansArray = (JSONArray) jsnobject.get("answers");
		for (int i = 0; i<ansArray.size();i++){
			JSONObject tempJSON = (JSONObject) ansArray.get(i);
			Answer a = new Answer();
//			a.setId_qst();
			
			
		}
		
		
	}

}
