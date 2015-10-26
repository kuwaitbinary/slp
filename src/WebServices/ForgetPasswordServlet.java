package WebServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImplementation.EditProfileDaoImpl;
import DaoImplementation.ForgotPasswordDaoImpl;
import Model.Trainee;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	  private static final Random RANDOM = new SecureRandom();
	private static final long serialVersionUID = 1L;



    public ForgetPasswordServlet() {
    	 super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		updatePassword(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		updatePassword(request, response);
	}
	  
void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		int id = Integer.parseInt((String)request.getParameter("idTrainee"));
		
		ForgotPasswordDaoImpl ep = new ForgotPasswordDaoImpl();
		String newPassword = generateRandomPassword();
		Trainee t = new Trainee();
		t.setPassword(newPassword);
		
		
		ep.forgotPassword(id, t);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		//for(int i = 0;i<favorites.size();i++) {
			
			JSONObject jsonReport = new JSONObject();
			
			
			//jsonReport.put("name", f.getName());
			//jsonReport.put("latitude", f.getLatitude());
			//jsonReport.put("longitude", f.getLongitude());
			
			result_data.add(jsonReport);
		//}
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);

}
	
	
	 @Override
	 
	    public String getServletInfo() {
	 
	        return "Forgot Password";

	    }
	 
	 
	 public static String generateRandomPassword ()
	  {
	      // Pick from some letters that won't be easily mistaken for each
	      // other. So, for example, omit o O and 0, generateRandomPassword1 l and L.
	      String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";

	      String pw = "";
	      for (int i=0; i<8; i++)
	      {
	          int index = (int)(RANDOM.nextDouble()*letters.length());
	          pw += letters.substring(index, index+1);
	      }
	      return pw;
	  } 
	} 
