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

/**
 * Servlet implementation class ForgetPasswordServlet
 */
@WebServlet("/ForgetPasswordServlet")
public class ForgetPasswordServlet extends HttpServlet {
	  private static final Random RANDOM = new SecureRandom();
	private static final long serialVersionUID = 1L;

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	       response.setContentType("text/html;charset=UTF-8");
	       PrintWriter out = response.getWriter();
	 
	try {
	  
	 
	 
	//Database
	       String email=request.getParameter("email");
	       ExecuteNonQ ex=new ExecuteNonQ();
	       
	 
// out.print(email);
	 
	       ResultSet rs=ex.SelectQueryByFieldWithCondition("USER_ID,Password","USER_ACCOUNTS","NBC_Email",email);
	 try{
	 
	        while(rs.next()){
	            String id=rs.getString("id_trainee");
	            String pwd=rs.getString("password");
	            out.print(id+pwd);     
	            response.sendRedirect("index?page=SendForgotPassword?email='"+email+"'&uid="+id+"&pwd="+pwd+"");
	            }
	  }
	 
	 catch(Exception e){e.getLocalizedMessage();
	   }
	 
	//End Database
	       
	        }
	
	finally {            
	        out.close();
	        }
	    }

    public ForgetPasswordServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		resetPassword(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		resetPassword(request, response);
	}
	  
	 @Override
	 
	    public String getServletInfo() {
	 
	        return "Short description";

	    }
	 
	 public void resetPassword(HttpServletRequest request, HttpServletResponse response){
		 
		 String id = request.getParameter("id_trainee");
		 
		 String newPassword = generateRandomPassword();
		 
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

	 @Override 
	 public void getPendingEvents(String newPassword, String id_trainee) { 

	 EntityManager em = this.getMyWayEntityManager(); 
	 Query q = em.createQuery("UPDATE Trainee SET password='"+newPassword+"' WHERE id_trainee='"+id_trainee+"'"); 
	 events = q.getResultList(); 
	
	  
		return events; 
	 } 


	 
	 
	} 
