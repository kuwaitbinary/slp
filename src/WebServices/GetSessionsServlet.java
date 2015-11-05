package WebServices;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		
		Reg_Session rs = Reg_sessions.get(0);
		Sess_Class sc = rs.getSession_class();
		Active_Session as = sc.getActiveSession();
		
		
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
			
			Calendar c = Calendar.getInstance();    
			c.setTime(waveDates.get(0).getDate());
			c.add(Calendar.DATE, 14);
			Date date = c.getTime();
			Wave_Date temp = new Wave_Date();
			temp.setDate(date);
			waveDates.add(temp);
			
			c.setTime(waveDates.get(1).getDate());
			c.add(Calendar.DATE, 14);
			date = c.getTime();
			temp = new Wave_Date();
			temp.setDate(date);

			waveDates.add(temp);

			c.setTime(waveDates.get(2).getDate());
			c.add(Calendar.DATE, 14);
			date = c.getTime();
			temp = new Wave_Date();
			temp.setDate(date);
			
			waveDates.add(temp);
			
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
				String dates = new SimpleDateFormat("dd-MM-yyyy").format(waveDates.get(0).getDate());
				for (int j= 1; j<waveDates.size(); j++){
//					dates= dates+","+ new SimpleDateFormat("dd-MM-yyyy").format(addDays(waveDates.get(j).getDate(), 14));
					dates= dates+","+new SimpleDateFormat("dd-MM-yyyy").format(waveDates.get(j).getDate());
				}
				System.out.println(dates);
				jsonReport.put("wave_date", dates);
			}
			
			//check if the trainee done the evaluation or not
			boolean doneFlag = sessionDao.doneEvaluating(id_trainee, as.getId_session());
			System.out.println("BOOLEAN Flag: "+doneFlag);
			
			if (doneFlag){
				jsonReport.put("isEvaluationDone", "true");
			} else {
				jsonReport.put("isEvaluationDone", "false");
			}
			
			result_data.add(jsonReport);
		}
		
		
		json.put("result_data", result_data);
		
		response.getWriter().print(json);
	}
	
	public static Date addDays(Date date, int days) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
                 
        return cal.getTime();
    }
}
