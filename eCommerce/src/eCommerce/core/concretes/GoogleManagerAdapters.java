package eCommerce.core.concretes;

import eCommerce.core.abstracts.GoogleService;
import eCommerce.google.GoogleManager;

public class GoogleManagerAdapters implements GoogleService {

	@Override
	public void signToSystem(String message) {
		GoogleManager googleManager = new GoogleManager();
		googleManager.googleSign(message);
		
	}

}
