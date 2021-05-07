package core.concretes;

import core.abstracts.EMailService;
import jMail.JMailManager;

public class EMailManagerAdapter implements EMailService{

	
	@Override
	public boolean sendMail(String email) {
		// TODO Auto-generated method stub
		JMailManager jMailManager = new JMailManager();

		jMailManager.sendMailForValidation(email);
		
		
		System.out.println("Hesap doðrulandý.");
		return true;
	}

}
