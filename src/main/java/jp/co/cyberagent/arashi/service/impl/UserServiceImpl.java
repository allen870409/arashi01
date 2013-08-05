package jp.co.cyberagent.arashi.service.impl;

import java.util.LinkedList;
import java.util.List;

import jp.co.cyberagent.arashi.dao.UserDao;
import jp.co.cyberagent.arashi.dto.UserDto;
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
	public List<UserDto> findAllUsers() {
		List<UserDto> list = new LinkedList<UserDto>();
		UserDto dto= new UserDto();
		List<User> users = userDao.findAllUsers();  
		for(User u:users){
			dto.setName(u.getName());
			dto.setAge(u.getAge());
			dto.setId(u.getId());
			dto.setSex(u.getSex());
			list.add(dto);
		}
		return list;
	}
	@Override
	public UserDto get(int id) {
		// TODO Auto-generated method stub
		UserDto dto= new UserDto();
		User u = userDao.get(id);
		dto.setName(u.getName());
		dto.setAge(u.getAge());
		dto.setId(u.getId());
		dto.setSex(u.getSex());
		return dto;
	}
	@Override
	public void set(UserDto user) {
		User u = new User();
		u.setAge(user.getAge());
		u.setName(user.getName());
		u.setSex(user.getSex());
		userDao.save(u);
	}
	@Override
	public void createUser(String name, int age, int sex) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setSex(sex);
		userDao.save(user);
	}

	
}
