package cn.algerfan.springboot09validate.contorller;


import javax.validation.Valid;

import cn.algerfan.springboot09validate.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AlgerFan
 * @date Created in 2019/1/25 16
 * @Description SpringBoot 表单数据校验
 */
@Controller
public class UsersController {
	/**
	 * 必须传递user这个对象，要不然会报错
	 * @param users
	 */
	@RequestMapping("/addUser")
	public String showPage(@ModelAttribute("user") Users users){
		return "add";
	}
	
	/**
	 * 完成用户添加
	 * @Valid 开启对Users对象的数据校验
	 * @ModelAttribute("user") 将错误结果显示在页面上
	 * BindingResult:封装了校验的结果
	 */
	@RequestMapping("/save")
	public String saveUser(@ModelAttribute("user") @Valid Users users, BindingResult result){
		if(result.hasErrors()){
			return "add";
		}
		System.out.println(users);
		return "ok";
	}
}
