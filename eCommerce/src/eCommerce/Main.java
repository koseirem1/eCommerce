package eCommerce;

import eCommerce.business.abstracts.UserService;
import eCommerce.business.concretes.UserManager;
import eCommerce.business.concretes.UserValidationManager;
import eCommerce.core.concretes.GoogleManagerAdapters;
import eCommerce.core.concretes.MailManager;
import eCommerce.dataAccess.concretes.HibernateUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		//User user = new User(1, "Ýrem", "Ýlhan", "ilhanirem", "123456", true);
		//User user2 = new User(1, "Ýrem", "Ýlhan", "ilhanirem@gmail.com", "123456", true);
		User user3 = new User(1, "Ýrem", "Ýlhan", "ilhanirem2@gmail.com", "123456", true);
		
		UserService userService = new UserManager(new HibernateUserDao(), new UserValidationManager(), new MailManager(), new GoogleManagerAdapters());
		userService.signUp(user3);
		userService.activationSignUp(user3);
		userService.signIn("ilhanirem@gmail.com", "123456");
		userService.googleSign(user3);
	}

}
