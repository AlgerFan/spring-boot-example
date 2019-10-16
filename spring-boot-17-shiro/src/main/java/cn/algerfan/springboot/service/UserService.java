package cn.algerfan.springboot.service;

import cn.algerfan.springboot.domain.User;

/**
 * @author AlgerFan
 */
public interface UserService {

	/**
	 * 通过用户名查找用户
	 * @param name
	 * @return
	 */
	User findByName(String name);

}
