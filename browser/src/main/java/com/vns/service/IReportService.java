package com.vns.service;

import java.util.Date;
import java.util.List;

/**
 * 报表Service
 * @author Lvp
 *
 */
public interface IReportService {

	/**
	 * 获取交易报表的所有数据，全周期
	 * @return
	 */
	public List<?> getReportAllData();
	
	/**
	 * 昨日数据统计（用于定时任务
	 */
	public void statistic();
	
	/**
	 * 统计某一段时间内的数据
	 * @param begin
	 * @param end
	 */
	public void statisticHistory(Date begin, Date end);
	
	/**
	 * 统计具体执行方法
	 * @param begin
	 * @param end
	 */
	public void statDataImpl(Date begin, Date end);
}
