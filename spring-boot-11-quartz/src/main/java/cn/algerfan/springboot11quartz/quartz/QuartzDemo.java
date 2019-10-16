package cn.algerfan.springboot11quartz.quartz;

import java.util.Date;

import cn.algerfan.springboot11quartz.service.UsersService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author AlgerFan
 * @date Created in 2019/2/16 09
 * @Description Job类
 */
public class QuartzDemo implements Job {
	
	@Autowired
	private UsersService usersService;
	
	@Override
	public void execute(JobExecutionContext arg0) {
		System.out.println("定时器被触发"+new Date());
		this.usersService.addUsers();
	}
}
