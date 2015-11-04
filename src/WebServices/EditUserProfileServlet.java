package WebServices;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.EditProfileDaoImpl;
import Model.Trainee;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class EditUserProfileServlet
 */
@WebServlet("/EditUserProfile")
public class EditUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		editProfile(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		editProfile(request, response);
	}
	
	void editProfile(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int id = Integer.parseInt((String)request.getParameter("id_trainee"));
		
		String name = URLDecoder.decode((String)request.getParameter("name"), "utf-8");
		System.out.println(name);
		String mobile = (String)request.getParameter("mobile");
		String email = (String)request.getParameter("email");
		String subject = (String)request.getParameter("subject");
		String grade = (String)request.getParameter("grade");
		String password = (String)request.getParameter("password");
		
		EditProfileDaoImpl ep = new EditProfileDaoImpl();
		
		Trainee t = new Trainee();
		
		t.setId_Trainee(id);
		t.setFirstname(name);
		t.setLastname("");
		t.setMobile(mobile);
		t.setEmail(email);
		t.setSubject(subject);
		t.setGrade(grade);
		t.setPassword(password);
		
		ep.editUserProfile(id, t);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		JSONArray result_data = new JSONArray();
		JSONObject jsonReport = new JSONObject();
		
		result_data.add(jsonReport);
		
		json.put("result_data", result_data);
		
		response.getWriter().print(json);
		
	}

}