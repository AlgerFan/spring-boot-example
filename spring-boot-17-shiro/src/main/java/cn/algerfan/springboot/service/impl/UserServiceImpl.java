package cn.algerfan.springboot.service.impl;

import cn.algerfan.springboot.domain.User;
import cn.algerfan.springboot.mapper.UserMapper;
import cn.algerfan.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author AlgerFan
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByName(String name) {
		return userMapper.findByName(name);
	}
	
}
