import business.abstracts.UserService;
import business.concretes.UserManager;
import core.concretes.EMailManagerAdapter;
import core.concretes.LoginManagerAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user = new User(1, "Mert", "Yýlmaz", "mert@gmail.com", "123456");
		
		UserService userManager = new UserManager(new HibernateUserDao(), new EMailManagerAdapter(), new LoginManagerAdapter());
		
		userManager.register(user);
		
		
		User user2 = new User();
		user2.setEmail("mert@gmail.com");
		user2.setPassword("123456");
		
		userManager.login(user2);
	}

}
