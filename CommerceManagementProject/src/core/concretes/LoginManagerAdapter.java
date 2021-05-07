package core.concretes;

import core.abstracts.LoginService;
import googleLoginSystem.GoogleLoginManager;

public class LoginManagerAdapter implements LoginService{

	
	@Override
	public void login() {
		
		GoogleLoginManager googleLoginManager = new GoogleLoginManager();
		
		googleLoginManager.loginWithGoogle();
	}

}
