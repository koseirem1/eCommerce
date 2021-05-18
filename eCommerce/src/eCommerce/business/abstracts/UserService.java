package eCommerce.business.abstracts;

import eCommerce.entities.concretes.User;

public interface UserService {
	
	void signUp(User user);
	void activationSignUp(User user);
	void signIn(String mail,String password);
	void googleSign(User user);
}
