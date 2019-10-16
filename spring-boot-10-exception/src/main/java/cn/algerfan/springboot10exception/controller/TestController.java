package cn.algerfan.springboot10exception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AlgerFan
 * @date Created in 2019/1/25 16
 * @Description SpringBoot处理异常方式二：@ExceptionHandle注解处理异常
 */
@Controller
public class TestController {
	
	@RequestMapping("/show")
	public String showInfo(){
		String str = null;
		str.length();
		return "index";
	}

	/**
	 * java.lang.NullPointerException
	 */
	@ExceptionHandler(value={java.lang.NullPointerException.class})
	public ModelAndView nullPointerExceptionHandler(Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("error1");
		return mv;
	}

}
