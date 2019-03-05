package com.test.schedule;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;

public class ScheduleInitUtil implements InitializingBean, ApplicationContextAware {
	
	private static Log logger = LogFactory.getLog(ScheduleInitUtil.class);

	private static ApplicationContext applicationContext;

	private Properties properties = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ScheduleInitUtil.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("------------------");
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------properties: ------------------" + properties);
		Thread.sleep(2000);
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------------------------------------");
		logger.debug("-------------------------------------------------------");
		TBScheduleManagerFactory tbscheduleManagerFactory = new TBScheduleManagerFactory();
		tbscheduleManagerFactory.setApplicationContext(applicationContext);
		tbscheduleManagerFactory.init(properties);  // ZK configuration in zk properties file.
		tbscheduleManagerFactory.setZkConfig(convert(properties));
		logger.info("TBBPM 成功启动schedule调度引擎 ...");
	}

	private Map<String, String> convert(Properties p) {
		Set<String> keys = p.stringPropertyNames();
		Map<String, String> map = new HashMap<String, String>();
		for (String key : keys) {
			map.put(key, p.getProperty(key));
		}
		return map;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

}
