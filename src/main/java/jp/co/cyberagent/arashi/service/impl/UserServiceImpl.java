package jp.co.cyberagent.arashi.service.impl;

import java.util.Date;
import java.util.List;

import jp.co.cyberagent.arashi.dao.UserDao;
import jp.co.cyberagent.arashi.model.User;
import jp.co.cyberagent.arashi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired 
	UserDao userDao;
	@Override
	
	public List<User> findAllUsers() {
		return userDao.findAllUsers();  
	}
	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		Long date1 = new Date().getTime();
		User user = userDao.get(id);
		Long time = new Date().getTime()-date1;
		System.out.println(time);
		return user;
	}
	@Override
	public void set(User user) {
		userDao.save(user);
	}
	@Override
	public void createUser(String name, int age, int sex) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setSex(sex);
		userDao.save(user);
	}
	@Override
	public void update(int id, String name, int age, int sex) {
		User user = userDao.get(id);
		user.setName(name);
		user.setAge(age);
		user.setSex(sex);
	}

	
}
