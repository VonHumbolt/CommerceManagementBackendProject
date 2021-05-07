package business.abstracts;

import entities.concretes.User;

public interface UserService {
	void login(User user);
	void register(User user);
	void loginWithGoogle();
}
