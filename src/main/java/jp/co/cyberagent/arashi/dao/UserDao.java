package jp.co.cyberagent.arashi.dao;

import java.util.List;

import jp.co.cyberagent.arashi.model.User;

public interface UserDao {

	public List<User> findAllUsers();
	
	public User get(Integer id);
	
	public void save(User user);
}
