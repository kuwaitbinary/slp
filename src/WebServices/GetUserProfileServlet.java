package WebServices;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import DaoImplementation.UserProfileDoaImpl;
import Model.Trainee;

/**
 * Servlet implementation class GetUserProfileServlet
 */
@WebServlet("/GetUserProfile")
public class GetUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getUserProfile(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		getUserProfile(request, response);
	}

	
	private void getUserProfile(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String id_trainee = request.getParameter("id_trainee");

		UserProfileDoaImpl userProfileDoa = new UserProfileDoaImpl();
		Trainee userProfile = userProfileDoa.retriveUserProfile(Integer.parseInt(id_trainee));

		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);

		JSONArray result_data = new JSONArray();

		JSONObject jsonReport = new JSONObject();
		

		jsonReport.put("email", userProfile.getEmail());
		
		jsonReport.put("traineeId", userProfile.getId_Trainee());

		jsonReport.put("mobile",userProfile.getMobile());
		jsonReport.put("firstname",userProfile.getFirstname());
		jsonReport.put("lastname",userProfile.getLastname());

		jsonReport.put("subject",userProfile.getSubject());
		


		result_data.add(jsonReport);

		json.put("result_data", result_data);
	
		response.getWriter().print(json);
	}

	
	
}





	

