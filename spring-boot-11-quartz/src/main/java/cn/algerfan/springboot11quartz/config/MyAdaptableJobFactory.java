package cn.algerfan.springboot11quartz.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @author AlgerFan
 * @date Created in 2019/2/16 09
 */
@Component("myAdaptableJobFactory")
public class MyAdaptableJobFactory extends AdaptableJobFactory {

	//AutowireCapableBeanFactory 可以将一个对象添加到SpringIOC容器中，并且完成该对象注入
	@Autowired
	private AutowireCapableBeanFactory autowireCapableBeanFactory;
	
	/**
	 * 该方法需要将实例化的任务对象手动的添加到springIOC容器中并且完成对象的注入
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object obj = super.createJobInstance(bundle);
		//将obj对象添加Spring IOC容器中，并完成注入
		this.autowireCapableBeanFactory.autowireBean(obj);
		return obj;
	}

}
