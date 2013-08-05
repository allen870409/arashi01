package jp.co.cyberagent.arashi.service;

import java.util.List;

import jp.co.cyberagent.arashi.dto.UserDto;

public interface UserService {
	
	 public List<UserDto> findAllUsers();
	 
	 public UserDto get(int id);
	 
	 public void set(UserDto user);

	public void createUser(String name, int age, int sex);
}
