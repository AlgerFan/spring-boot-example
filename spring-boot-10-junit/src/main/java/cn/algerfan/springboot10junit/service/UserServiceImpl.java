package cn.algerfan.springboot10junit.service;

import cn.algerfan.springboot10junit.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl userDaoImpl;
	
	public void addUser(){
		this.userDaoImpl.saveUser();
	}
}
