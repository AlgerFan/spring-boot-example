package cn.algerfan.springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * </p>
 *
 * @author algerfan
 * @since 2019/7/31 11
 */
@RestController
public class UserController {

    /**
     * 测试thymeleaf
     */
    @RequestMapping("/testThymeleaf")
    public ModelAndView testThymeleaf(Model model){
        //把数据存入model
        model.addAttribute("name", "黑马程序员");
        //返回test.html
        return new ModelAndView("test");
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add(){
        return new ModelAndView("user/add");
    }

    /**
     * 更新用户
     * @return
     */
    @RequestMapping("/update")
    public ModelAndView update(){
        return new ModelAndView("user/update");
    }

    /**
     * 跳转到登录
     * @return
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        return new ModelAndView("login");
    }

    /**
     * 登录逻辑处理
     */
    @RequestMapping("/login")
    public ModelAndView login(String name,String password,Model model){
        //1.获取Subject
        Subject subject = SecurityUtils.getSubject();
        //2.封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        //3.执行登录方法
        try {
            subject.login(token);
            //登录成功，跳转到test.html
            return new ModelAndView("redirect:/testThymeleaf");
        } catch (UnknownAccountException e) {
            //登录失败:用户名不存在
            model.addAttribute("msg", "用户名不存在");
            return new ModelAndView("login");
        }catch (IncorrectCredentialsException e) {
            //登录失败:密码错误
            model.addAttribute("msg", "密码错误");
            return new ModelAndView("login");
        }
    }
}
