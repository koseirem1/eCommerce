package eCommerce.core.concretes;

import eCommerce.core.abstracts.MailService;
import eCommerce.entities.concretes.User;

public class MailManager implements MailService{

	@Override
	public void sendMail(User user) {
		System.out.println("Aktivasyon maili " + user.geteMail() + "adresinize gönderildi.");
		
	}

}
