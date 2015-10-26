package DaoImplementation;
import Model.Trainee;

public interface UserProfileDoa {
 
		
		Trainee login(String userName,String passWord);
		
		Trainee checkUserName(String userName);
		void register(Trainee up);
		
		Trainee retriveUserProfile(String userName);
		
		void updateUserProfile(String username,String password, String email, String picture);

	}


