package cn.algerfan.springboot10exception.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AlgerFan
 * @date Created in 2019/1/25 17
 * @Description 全局异常处理类
 */
@ControllerAdvice
public class GlobalException {
	/**
	 * java.lang.ArrayIndexOutOfBoundsException
	 */
	@ExceptionHandler(value={ArrayIndexOutOfBoundsException.class})
	public ModelAndView arithmeticExceptionHandler(Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("error1");
		return mv;
	}
	
	/**
	 * java.lang.NullPointerException
	 */
	@ExceptionHandler(value={NullPointerException.class})
	public ModelAndView nullPointerExceptionHandler(Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.toString());
		mv.setViewName("error2");
		return mv;
	}
	
}
