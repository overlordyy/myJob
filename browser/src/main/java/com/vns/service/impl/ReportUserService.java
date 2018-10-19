package com.vns.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vns.dao.ReportUserMapper;
import com.vns.service.IReportUserService;
import com.vns.vo.ReportUser;

@Service
public class ReportUserService extends ReportService implements IReportUserService {

	@Autowired
	private ReportUserMapper rum;
	
	@Override
	public List<ReportUser> getReportAllData() {
		return rum.getReportAllData();
	}

	/**
	 * 统计具体执行方法
	 * 注：只统计1天的
	 * @param begin
	 * @param end
	 */
	@Override
	public void statDataImpl(Date begin, Date end) {
		ReportUser param = new ReportUser();
		param.setBeginDate(begin);
		param.setEndDate(end);
		ReportUser ru = rum.statYesterdayUserData(param);
		
		if (null != ru) {
			ru.setCreateDate(end);
			
			int isExist = rum.isExist(ru);
			if (isExist > 0) {
				// 更新
				rum.update(ru);
			} else {
				// 入库
				rum.insert(ru);
			}
		}
	}
	
}
