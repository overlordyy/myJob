package com.vns.task;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.vns.service.IHomeService;
import com.vns.util.ApplicationContextUtil;

public class HomeTask {

	@Resource
	private IHomeService ihs;
	public void show(){
//		ApplicationContext app = ContextLoader.getCurrentWebApplicationContext();
//		IHomeService hts = app.getBean("homeService", IHomeService.class);
//		IHomeService hts = (IHomeService) ApplicationContextUtil.getBean("homeService");
		ihs.homeTask();
	}
}
