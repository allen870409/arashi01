package jp.co.cyberagent.arashi.service.impl;

import java.util.List;

import jp.co.cyberagent.arashi.dao.UserDao;
import jp.co.cyberagent.arashi.model.User;
import jp.co.cyberagent.arashi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserDao userDao;
	@Override
	@Transactional
	public List<User> findAllUsers() {
		 return userDao.findAllUsers();  
	}
	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return userDao.get(id);
	}
	@Override
	public void set(User user) {
		userDao.save(user);
	}
	@Override
	public User createUser(String name, int age, int sex) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setSex(sex);
		userDao.save(user);
		return user;
	}

	
}
