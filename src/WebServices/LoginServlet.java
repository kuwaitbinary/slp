package WebServices;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.UserProfileDoaImpl;
import Model.Trainee;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// to create the DB tables
		UserProfileDoaImpl u = new UserProfileDoaImpl();
		u.getMyWayEntityManager();
		// to call the login method below
		login(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		login(request, response);
	}

	void login(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int id_trainee = Integer.parseInt((String) request
				.getParameter("idTrainee"));

		String password = request.getParameter("password");

		UserProfileDoaImpl user = new UserProfileDoaImpl();

		Trainee t = user.retriveUserProfile(id_trainee);

//		String Realpassword = t.getPassword();

		boolean isAuthorised = password == t.getPassword();

		JSONObject json = new JSONObject();

		json.put("message", "success");

		json.put("result_code", 0);

		JSONArray result_data = new JSONArray();

		JSONObject jsonReport = new JSONObject();

		jsonReport.put("flag", String.valueOf(isAuthorised));

		result_data.add(jsonReport);

		json.put("result_data", result_data);

		response.getWriter().print(json);
	}

}