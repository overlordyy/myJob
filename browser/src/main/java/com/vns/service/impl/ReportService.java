package com.vns.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vns.service.IReportService;
import com.vns.util.DateUtil;

@Service
public class ReportService implements IReportService{

	public void statistic() {
		// 获取昨日交易统计数据
		Date current = new Date();
		Date begin = DateUtil.getYesterdayBeginDate(current);
		Date end = DateUtil.getYesterdayEndDate(current);
		statDataImpl(begin, end);
	}
	
	public void statisticHistory(Date begin, Date end){
		// 日期时间都置为0时0分0秒，便于计算日期相隔天数
		Date beginN = DateUtil.get0SecDate(begin);
		Date endN = DateUtil.get0SecDate(end);
		// 区得相隔天数
		int days = DateUtil.differentDaysByMillisecond(beginN, endN);
		if (days < 0) {
			return;
		}
		
		// 根据相隔天数，循环统计这段时间内每一天的数据
		int i = 0; // 如果相隔0天，也得计算一天
		do {
			Date beginDate = DateUtil.getNdayAgoBeginDate(end, i);
			Date endDate = DateUtil.getNdayAgoEndDate(end, i);
			statDataImpl(beginDate, endDate);
			i++;
		} while (i < days);
	}

	public List<?> getReportAllData() {
		return null;
	}

	public void statDataImpl(Date begin, Date end) {
		
	}
}
