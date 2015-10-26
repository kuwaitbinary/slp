package WebServices;

import java.io.IOException;
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
@WebServlet("/GetSessionsServlet")
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	void viewUserSessions(HttpServletRequest request, HttpServletResponse response) throws IOException{

		
		GetSessionDaoImpl sessionDao = new GetSessionDaoImpl();
		String id_trainee = request.getParameter("username");
		List<Reg_Session> Reg_sessions = sessionDao.getReg_Session(id_trainee);
		
		JSONObject json = new JSONObject();
		json.put("message", "success");
		json.put("result_code", 0);
		
		
		JSONArray result_data = new JSONArray();

		for(int i = 0;i<Reg_sessions.size();i++) {
			
			JSONObject jsonReport = new JSONObject();
			Reg_Session regSession = Reg_sessions.get(i);
			Sess_Class sessClass = sessionDao.getSess_Class(regSession.getId_class());
			Trainer trainer = sessClass.getTrainer();
			Active_Session activeSession = sessClass.getActive_session();
			Location location = activeSession.getLocation();
			Zone zone = sessionDao.getZone(location.getId_zone());
			Wave wave = activeSession.getWave();
			Course course = sessionDao.getCourse(wave.getId_course());
			Wave_Date waveDate = sessionDao.getWaveDate(wave.getId_wave());
			
			
			jsonReport.put("class_name", sessClass.getName());
			jsonReport.put("course_name", course.getName());
			jsonReport.put("location_name", location.getLocation());
			jsonReport.put("location_gps", location.getGps());
			jsonReport.put("zone", zone.getZone());
			jsonReport.put("trainer_name", trainer.getFirstname() + trainer.getLastname());
			jsonReport.put("wave_date", waveDate.getDate());
			
			
			
			result_data.add(jsonReport);
		}
		
		json.put("result_data", result_data);
		
		
		response.getWriter().print(json);
	}
}
