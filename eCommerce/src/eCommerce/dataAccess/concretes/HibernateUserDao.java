package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	
	ArrayList<User> users = new ArrayList<User>();
	

	@Override
	public void add(User user) {
		System.out.println("Hibernate ile eklendi. + " + user.getId());
		
	}

	@Override
	public User get(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		
		return null;
	}

	@Override
	public ArrayList<User> getAll() {
		
		users.add(new User(1,"Irem","Ilhan","ilhanirem@gmail.com","123456",true));
		users.add(new User(2,"Fatih","Ilhan","ilhanfatih@gmail.com","123456",false));
		return users;
	}

}
