package eCommerce.business.abstracts;



public interface UserValidationService {
	
	boolean passwordValidation(String password);
	boolean mailValidation(String mail);
	boolean nameValidation(String name);
	boolean surnameValidation(String surname);
	boolean isClickedValidation(boolean isClicked);
	
	
	

}
