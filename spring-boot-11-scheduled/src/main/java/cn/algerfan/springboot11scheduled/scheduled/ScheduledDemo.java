package cn.algerfan.springboot11scheduled.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author AlgerFan
 * @date Created in 2019/2/16 09
 * @Description Scheduled定时任务
 */
@Component
public class ScheduledDemo {

	/**
	 * 定时任务方法
	 * @Scheduled: 设置定时任务,使用了cron表达式
	 */
	@Scheduled(cron="0/3 * * * * ?")
	public void scheduledMethod(){
		System.out.println("定时器被触发"+new Date());
	}
}
