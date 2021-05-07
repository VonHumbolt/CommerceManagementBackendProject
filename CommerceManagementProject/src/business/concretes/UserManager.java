package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserService;
import core.abstracts.EMailService;
import core.abstracts.LoginService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	private EMailService mailService;
	private LoginService loginService;
	
	public UserManager(UserDao userDao, EMailService mailService, LoginService loginService) {
		this.userDao = userDao;
		this.mailService = mailService;
		this.loginService = loginService;
	}
	
	@Override
	public void login(User user) {
		
		User userFromDatabase = this.userDao.Get(user.getEmail());
		
		if(userFromDatabase != null && userFromDatabase.getPassword() == user.getPassword()) {
			System.out.println("Hoþgeldiniz " + userFromDatabase.getFirstName());
		
		} else {
			System.out.println("Email veya þifre hatalý!");
		}
	}

	@Override
	public void register(User user) {
		
		Pattern pattern = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(user.getEmail());
		boolean isEmailValid = matcher.find();
		
		if(!isEmailValid) {
			System.out.println("Lütfen emailinizi doðru girdiðinizden emin olun.");
			
			if(user.getPassword().length() < 6) {
				System.out.println("Þifre en az 6 haneli olmalýdýr.");
				
				if(this.userDao.Get(user.getEmail()) != null) {
					System.out.println("Bu email daha önce kullanýlmýþ!");
					
					if(user.getFirstName().length() < 2 && user.getLastName().length() < 2) {
						System.out.println("Ýsim ve soyisim en az 2 haneli olmalýdýr.");
						
					}
				}
			}
		} 
		else {
			
			boolean isValidated = this.mailService.sendMail(user.getEmail());
			
			if(isValidated) {
				this.userDao.add(user);
			}
			
		}
		
	}

	@Override
	public void loginWithGoogle() {
		
		this.loginService.login();
		
	}

}
