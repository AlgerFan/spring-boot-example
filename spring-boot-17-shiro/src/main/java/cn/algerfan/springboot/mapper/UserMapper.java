package cn.algerfan.springboot.mapper;

import cn.algerfan.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author AlgerFan
 */
@Mapper
public interface UserMapper {

	/**
	 * 通过用户名查找用户
	 * @param name
	 * @return
	 */
	User findByName(@Param("name") String name);

}
