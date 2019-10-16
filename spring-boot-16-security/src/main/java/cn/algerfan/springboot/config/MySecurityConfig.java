package cn.algerfan.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author algerfan
 * @date 2019/10/16 13:29
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/product/**").hasRole("商品管理员")
                .antMatchers("/order/**").hasRole("订单管理员")
                .antMatchers("/admin/**").hasRole("超级管理员");

        /*
        开启自动配置的登陆功能，效果，如果没有登陆，没有权限就会来到登陆页面
        使用默认的登录页面
        1、/login来到登陆页
        2、重定向到/login?error表示登陆失败
         */
        //http.formLogin();
        /*
        使用自己的登录页面
        1、默认post形式的 /login代表处理登陆
        2、一但定制loginPage；那么 loginPage的post请求就是登陆
         */
        http.formLogin().usernameParameter("user").passwordParameter("pwd")
                .loginPage("/userLogin");

        /*
        开启自动配置的注销功能，注销成功以后来到首页
        1、访问 /logout 表示用户注销，清空session
        2、注销成功会返回 /login?logout 页面；
         */
        http.logout().logoutSuccessUrl("/");

        /*
        开启记住我功能，默认为remember-me
        登陆成功以后，将cookie发给浏览器保存，以后访问页面带上这个cookie，只要通过检查就可以免登录
         */
        http.rememberMe().rememberMeParameter("remeber");
    }

    /**
     * 定义认证规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("zhangsan").password("123456").roles("商品管理员","订单管理员")
                .and()
                .withUser("lisi").password("123456").roles("订单管理员","超级管理员")
                .and()
                .withUser("wangwu").password("123456").roles("商品管理员","超级管理员");
    }

    /**
     * 已过期，开发时过渡使用
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}
