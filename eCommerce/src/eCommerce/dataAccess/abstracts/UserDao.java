package eCommerce.dataAccess.abstracts;


import java.util.List;

import eCommerce.entities.concretes.User;

public interface UserDao {
	void add(User user);
	User get(int id);
	List<User> getAll();

}
