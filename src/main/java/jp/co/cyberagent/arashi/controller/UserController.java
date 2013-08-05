package jp.co.cyberagent.arashi.controller;

import java.util.List;

import jp.co.cyberagent.arashi.dto.UserDto;
import jp.co.cyberagent.arashi.model.User;
import jp.co.cyberagent.arashi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/create/{name}/{age}/{sex}", method = RequestMethod.GET)
	@ResponseBody
	public void createUser(@PathVariable String name,@PathVariable int age,@PathVariable int sex){
		
		userService.createUser(name, age,sex);
		
	}
	
	@RequestMapping(value = "/listuser", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDto> listUser(){
		
		return userService.findAllUsers();
		
	}
}
