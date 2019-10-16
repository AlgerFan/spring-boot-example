package cn.algerfan.springboot11scheduled.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;

/**
 * @author AlgerFan
 * @date Created in 2019/2/16 09
 * @Description 定义任务类
 */
public class QuartzDemo implements Job {

	/**
	 * 任务被触发时所执行的方法
	 */
	public void execute(JobExecutionContext arg0) {
		System.out.println("Execute...."+new Date());
	}

}
