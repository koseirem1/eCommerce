package eCommerce.core.abstracts;

import eCommerce.entities.concretes.User;

public interface MailService {
	void sendMail(User user);

}
