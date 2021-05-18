package eCommerce.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import eCommerce.business.abstracts.UserValidationService;

public class UserValidationManager implements UserValidationService {

	@Override
	public boolean passwordValidation(String password) {
		if(password != null && password != "") {
			if(password.length() < 6) {
				System.out.println("Þifre 6 karakterden küçük olamaz!");
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public boolean mailValidation(String mail) {
		
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"+"[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern p = Pattern.compile(regex);
  
        if (mail == null) {
            return false;
        }
  
        Matcher m = p.matcher(mail);
        return m.matches();
	
	}

	@Override
	public boolean nameValidation(String name) {
		if(name != null) {
			if(name.length() < 2) {
				System.out.println("Geçersiz isim");
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
			
	}

	@Override
	public boolean surnameValidation(String surname) {
		if(surname != null) {
			if(surname.length() < 2) {
				System.out.println("Geçersiz soyisim");
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean isClickedValidation(boolean isClicked) {
		return isClicked;
	}

}
