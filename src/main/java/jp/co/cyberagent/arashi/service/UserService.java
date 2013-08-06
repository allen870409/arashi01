package jp.co.cyberagent.arashi.service;

import java.util.List;

import jp.co.cyberagent.arashi.model.User;

public interface UserService {
	
	 public List<User> findAllUsers();
	 
	 public User get(int id);
	 
	 public void set(User user);

	public void createUser(String name, int age, int sex);
	
	public void update(int id,String name,int age,int sex);
}
