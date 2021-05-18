package eCommerce.business.concretes;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.abstracts.GoogleService;
import eCommerce.core.abstracts.MailService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class UserManager implements UserService {
	
    private UserDao userDao;
	private UserValidationManager userValidManager;
	private MailService mailService;
	private GoogleService googleService;
	
	public UserManager(UserDao userDao, UserValidationManager userValidManager, MailService mailService, GoogleService googleService) {
		super();
		this.userDao = userDao;
		this.userValidManager = userValidManager;
		this.mailService = mailService;
		this.googleService = googleService;
	}
	
	@Override
	public void signUp(User user) {
		boolean validStatus = true;
		 if (userDao.getAll() != null) { 
	            for (User userExist : userDao.getAll()) {
	                if(user.geteMail() == userExist.geteMail()) {
	                    System.out.println("Bu mail adresiyle daha önce kayıt yapılmıştır!");
	                    return;
	                }
	            }
	        }
		 
	        if (!userValidManager.mailValidation(user.geteMail())){ 
	            System.out.println("Geçersiz e-posta adresi.");
	            validStatus =false;
	        }
	        if (!userValidManager.nameValidation(user.getName())){
	            System.out.println("Geçersiz isim.");
	            validStatus =false;
	        }
	        if (!userValidManager.surnameValidation(user.getSurname())){
	            System.out.println("Geçersiz soyadı.");
	            validStatus =false;
	        }
	        
	        if (!userValidManager.passwordValidation(user.getPassword())){
	            System.out.println("Geçersiz şifre");
	            validStatus =false;
	        }
	        
	        if (validStatus==false) {
	            System.out.println("Kayıt gerçekleştirilemedi.Lütfen tekrar deneyiniz");
	        } else {
	        	//aktivasyon maili gönder.
	        	this.mailService.sendMail(user);
	        }
		
	}
	
	@Override
	public void activationSignUp(User user) {
		if(user.getIsClicked() == true) {
			userDao.add(user);
			System.out.println("Kaydınız başarılı bir şekilde tamamlandı.");
		} else {
			System.out.println("Kaydınız tamamlanmamıştır.");
		}
		
	}

	//Bu kısım normal
	@Override
	public void signIn(String mail, String password) {
		boolean signStatus = false;
        for (User userExist : userDao.getAll()) {
            if(mail == userExist.geteMail() && password == userExist.getPassword()) {
            	signStatus = true;
            }
        }
        
        if(signStatus) {
        	 System.out.println("Giriş yapıldı!");
        } else {
        	System.out.println("Giriş başarısız!");
        }
		
	}

	@Override
	public void googleSign(User user) {
		this.googleService.signToSystem("Google ile giriş yapıldı " + user.geteMail());
		
	}



}
