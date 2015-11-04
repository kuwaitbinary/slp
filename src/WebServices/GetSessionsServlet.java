package WebServices;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.json.java.JSONArray;
import com.ibm.json.java.JSONObject;

import DaoImplementation.GetSessionDaoImpl;
import Model.Active_Session;
import Model.Course;
import Model.Location;
import Model.Reg_Session;
import Model.Sess_Class;
import Model.Trainer;
import Model.Wave;
import Model.Wave_Date;
import Model.Zone;

/**
 * Servlet implementation class GetSessionsServlet
 */
@WebServlet("/GetSessions")
public class GetSessionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetSessionsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		viewUserSessions(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		viewUserSessions(request, response);
	}
	
	void viewUserSessions(HttpServletRequest request, HttpServletResponse response) throws IOException{

		GetSessionDaoImpl sessionDao = new GetSessionDaoImpl();
		String id_trainee = request.getParameter("id_trainee");
		List<Reg_Session> Reg_sessions = sessionDao.getReg_Session(id_trainee);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		for(int i = 0;i<Reg_sessions.size();i++) {
			
			JSONObject jsonReport = new JSONObject();
			Reg_Session regSession = Reg_sessions.get(i);
			Sess_Class sessClass = regSession.getSession_class();
			Active_Session activeSession = sessClass.getActiveSession();
			
			Trainer trainer = sessClass.getTrainer();
			
			Location location = activeSession.getLocation();
			Zone zone = location.getZone();
			
			Wave wave = activeSession.getWave();
			Course course = wave.getCourse();
			
			List<Wave_Date> waveDates = sessionDao.getWaveDates(wave.getId_wave());
			
			jsonReport.put("id_session", activeSession.getId_session());
			jsonReport.put("id_class", sessClass.getId_class());
			jsonReport.put("class_name", sessClass.getName());
			jsonReport.put("course_name", course.getName());
			jsonReport.put("location_name", location.getLocation());
			jsonReport.put("location_gps", location.getGps());
			jsonReport.put("zone", zone.getZone());
			jsonReport.put("trainer_name", trainer.getFirstname() + trainer.getLastname());
			
			//setting the array of the dates to be sent in the request
			if (waveDates.size()==0){
				jsonReport.put("wave_date", "");
			}else{
				String dates = waveDates.get(0).getDate().toString();
				for (int j= 1; j<waveDates.size(); j++){
					dates= dates+","+new SimpleDateFormat("ddMMyyyy").format(waveDates.get(j).getDate());
				}
				System.out.println(dates);
				jsonReport.put("wave_date", dates);
			}
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		response.getWriter().print(json);
	}
}
